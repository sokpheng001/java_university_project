package view.components;

import repository.DataList;
import repository.DataStoreMap;
import utils.FontComponent;
import utils.WordSearchedHistoryList;
import view.WindowsFrame;
import utils.WindowsFrameObject;
import view.components.mouseHover.HandCursorHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class Content{
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    public final static JPanel content = new JPanel(new GridLayout(0,2));
    private  static DefaultListModel<String> words;
    private  static JList<String> jList;
    public static void loadingWord(){
        words = new DefaultListModel<>();
        DataList.lists.forEach(words::addElement);
        DataList.lists.forEach(System.out::println);
        jList = new JList<>(words);
        jList.setBorder(new EmptyBorder(5,5,0, 0));
    }
    public static JPanel dictionaryContent(){
//        DataList.lists = new ArrayList<>();
//        DataStore.getAllWords().forEach((k,v)->{
//            DataList.lists.add(k);
//        });
        loadingWord();
        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        System.out.println(DataStoreMap.words);
//         listen when select each element of jlist
//         add font to description of words
        jTextArea.setText("This is a JTextArea with custom font.");
        // Create an empty border with padding
        int padding = 10; // Adjust the padding as needed
        jTextArea.setBorder(new EmptyBorder(5,5,0, 0));
        // Set font for the JTextArea
         // Example font: Arial, bold, size 16
        jTextArea.setFont(FontComponent.font);
//        set up JList with hand cursor
        jList.setName("word");
        HandCursorHandler.handCursorOnButton(jList);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Ensure the event is not fired multiple times
                    String selectedWord = jList.getSelectedValue();
//                    System.out.println(selectedWord);
//                    JOptionPane.showMessageDialog(windows, "You selected: " + selectedWord);
                    jTextArea.setText(
                            STR."""
                                    អត្ថន័យរបស់ពាក្យ [ \{selectedWord} ]
                                    ខ្លឹមសារ:
                                    \{DataStoreMap.words.get(selectedWord)}
                                    """
                    );
                    WordSearchedHistoryList.searchedWord.add(selectedWord);
                    System.out.println(WordSearchedHistoryList.searchedWord);
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
//                System.out.println(SearchArea.searchField.getText());
                filterWords(SearchArea.searchField.getText());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
//                System.out.println(SearchArea.searchField.getText());
                filterWords(SearchArea.searchField.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
//                System.out.println(SearchArea.searchField.getText());
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
        try{
            DefaultListModel<String> defaultListModel = new DefaultListModel<>();
            List<String> stringArrayList = DataList.lists;
            stringArrayList.forEach(e->{
                String item = e.toLowerCase();
                if(item.contains(word.toLowerCase())){
                    defaultListModel.addElement(e);
                }
            });
            words = defaultListModel;
            jList.setModel(words);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
