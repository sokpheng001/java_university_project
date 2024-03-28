package view.components;

import repository.DataList;
import repository.DataStore;
import repository.DataStoreMap;
import utils.FontComponent;
import utils.WindowsFrameObject;
import view.WindowsFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewWordForm {
    private final static WindowsFrame windows = WindowsFrameObject.WINDOWS_APP_OBJECT.getObject();
    private static final JLabel newWordLabel = new JLabel("New Word");
    private static final JLabel newWordDescriptionLabel = new JLabel("Word Meaning");
    private final static JButton cancelButton = new JButton("Cancel");
    private final static JButton addButton = new JButton("Add");
    private final static JPanel buttonManagerPanel = new JPanel(new GridLayout(1,0,8,0));
    private final static JDialog addNewWordForm = new JDialog(windows, "Add new word", true);
    private final static JTextField wordInput = new JTextField();
    private final static JPanel inputWordPanel = new JPanel();
    private final static JTextArea descriptionInput = new JTextArea();
    private final static JPanel inputDescriptionPanel = new JPanel();
//
    private final static JPanel wordLabelPanel = new JPanel();
    private final static JPanel wordDescriptionLabelPanel = new JPanel();
    private static void customizingButtonAndInput(){
//add font

//
        wordLabelPanel.setBackground(Color.white);
        wordLabelPanel.setBounds(8,8,150,27);
        wordLabelPanel.add(newWordLabel);

//
        wordInput.setPreferredSize(new Dimension(300,50));
        wordInput.setHorizontalAlignment(JTextField.CENTER);
        inputWordPanel.setBounds(8,38,300,50);
        inputWordPanel.add(wordInput);
        // word description
        wordDescriptionLabelPanel.setBackground(Color.white);
        wordDescriptionLabelPanel.setBounds(8,96,150,27);
        wordDescriptionLabelPanel.add(newWordDescriptionLabel);
//        add description panel
        descriptionInput.setPreferredSize(new Dimension(470,200));
        inputDescriptionPanel.setBounds(8,124,470,200);
        descriptionInput.setBorder(new EmptyBorder(5,5,0, 0));
        inputDescriptionPanel.add(new JScrollPane(descriptionInput));
//add button

        ButtonHandCursorHandler.handCursorOnButton(cancelButton);
        ButtonHandCursorHandler.handCursorOnButton(addButton);
        buttonManagerPanel.add(cancelButton);
        buttonManagerPanel.add(addButton);
        addButton.setName("addNewWord button");
        cancelButton.setName("cancelNewWord button");
        buttonManagerPanel.setBounds(277,332,201,35);
//        INPUT
//;
    }
    public static void open(){
        customizingButtonAndInput();
        addNewWordForm.add(wordLabelPanel);
        addNewWordForm.add(wordDescriptionLabelPanel);
        addNewWordForm.getContentPane().setLayout(null);
        addNewWordForm.add(inputWordPanel);
        addNewWordForm.add(inputDescriptionPanel);
        addNewWordForm.getContentPane().add(buttonManagerPanel);
//
        addWordAction();
//
        addNewWordForm.setSize(500,414);
        addNewWordForm.setLocationRelativeTo(windows);
        addNewWordForm.setResizable(false);
        addNewWordForm.setVisible(true);

    }
    private static void addWordAction(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataStoreMap.words.put(
                        wordInput.getText(),
                        descriptionInput.getText()
                )   ;
                DataList.lists.add(wordInput.getText());

                Content.dictionaryContent();
                System.out.println(DataList.lists);
            }
        });
    }
}
