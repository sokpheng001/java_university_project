package view.components;

import repository.DataStore;
import view.WindowsFrame;
import view.WindowsFrameObject;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class Content{
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private final static JPanel content = new JPanel(new GridLayout(0,2));
    private  static DefaultListModel<String> words;
    private  static JList<String> jList;
    private  static List<String> lists;
    public static JPanel dictionaryContent(){
        lists = new ArrayList<>();
        DataStore.getAllWords().forEach((k,v)->{
            lists.add(k);
        });
        words = new DefaultListModel<>();
        lists.forEach(words::addElement);
        jList = new JList<>(words);
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
//         listen when select each element of jlist
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Ensure the event is not fired multiple times
                    String selectedWord = jList.getSelectedValue();
                    System.out.println(selectedWord);
//                    JOptionPane.showMessageDialog(windows, "You selected: " + selectedWord);
                    jTextArea.setText(
                            """
                                    Document Title: Sample Document

                                    Introduction:
                                    This is a sample document written in Java String. It demonstrates how to represent
                                    a document with various sections and text content.

                                    Main Content:
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi vel enim eleifend
                                    ultricies vitae vel velit. Integer auctor massa ut sem bibendum, at dignissim enim
                                    pellentesque. Nullam hendrerit massa at tincidunt ultricies. Ut id arcu lectus. Donec
                                    placerat quis velit in varius. In hac habitasse platea dictumst. Duis pretium lorem eget
                                    eros efficitur, a fringilla urna lobortis. Nam sit amet nisi vitae velit iaculis sodales.
                                    Maecenas in lacinia nisl. Fusce congue tortor justo, non ultricies elit malesuada id.

                                    Conclusion:
                                    This concludes the sample document. Thank you for reading.\t""" + selectedWord
                            );
                    jTextArea.setEditable(false);
                    content.add(jScrollPane);
                    content.revalidate();
                    content.repaint();
                }
            }
        });
//         filter word by search
        SearchArea.searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(SearchArea.searchField.getText());
                filterWords(SearchArea.searchField.getText());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println(SearchArea.searchField.getText());
                filterWords(SearchArea.searchField.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(SearchArea.searchField.getText());
                filterWords(SearchArea.searchField.getText());
            }
        });
        content.setBackground(Color.WHITE);
        JScrollPane jScrollPane1 = new JScrollPane(jList);
        content.add(jScrollPane1);
//        content.add();
        return content;
    }
    private static void filterWords(String word){
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        List<String> stringArrayList =lists;
        stringArrayList.forEach(e->{
            String item = e.toLowerCase();
            if(item.contains(word.toLowerCase())){
                defaultListModel.addElement(e);
            }
        });
        words = defaultListModel;
        jList.setModel(words);
    }
}
