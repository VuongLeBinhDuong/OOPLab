package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.store.Store;
import AimsProject.hust.soict.ict.aims.media.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    private JTextArea authors;
    private JButton addButton;
    public AddBookToStoreScreen(Store store){
        super(store);
        JLabel authorLabel = new JLabel("AUTHOR");
        authors = new JTextArea(5, 20);
        JScrollPane authorScrollPane = new JScrollPane(authors);
        addButton = new JButton("ADD");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
                JOptionPane.showMessageDialog(null,"New Book has been added");
            }
        });

        center.add(authorLabel);
        center.add(authorScrollPane);
        center.add(addButton);
    }

    protected void addItem() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String[] authorsArray = authors.getText().split("\n");
        List<String> authorsList = new ArrayList<>();
        for (String author : authorsArray) {
            authorsList.add(author);
        }

        Book book = new Book(id, title, category, cost, authorsList);
        store.addMedia(book);
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        authors.setText("");
    }
}
