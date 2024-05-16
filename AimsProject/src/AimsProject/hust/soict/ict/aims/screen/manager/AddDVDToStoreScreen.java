package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.store.*;
import AimsProject.hust.soict.ict.aims.media.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDVDToStoreScreen extends AddItemToStoreScreen{
    private JTextField lengthField, directorField;
    private JButton addButton;
    public AddDVDToStoreScreen(Store store){
        super(store);
        JLabel lengthLabel = new JLabel("LENGTH");
        lengthField = new JTextField(20);
        JLabel directorLabel  = new JLabel("DIRECTOR");
        directorField = new JTextField(20);

        addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
                JOptionPane.showMessageDialog(null,"New DVD has been added");
            }
        });

        center.add(lengthLabel, labelConstrains);
        center.add(lengthField, fieldConstrains);
        center.add(directorLabel, labelConstrains);
        center.add(directorField, fieldConstrains);
        center.add(addButton);
    }

    public void addItem(){
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());
        String director = directorField.getText();

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(dvd);
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        lengthField.setText("");
        directorField.setText("");
    }

    public static void main(String[] args) {
        Store store = new Store();
        AddDVDToStoreScreen addDVDScreen = new AddDVDToStoreScreen(store);
        addDVDScreen.setVisible(true);
    }
}
