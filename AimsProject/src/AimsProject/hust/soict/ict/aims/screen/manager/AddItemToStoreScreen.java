package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JPanel{
    protected Store store;
    protected JTextField idField, titleField, categoryField, costField;
    protected JPanel center = new JPanel();
    public AddItemToStoreScreen(Store store){
        this.store = store;
        center.setLayout(new GridLayout(10, 1));
        JLabel idLabel = new JLabel("ID");
        idField = new JTextField(20);
        JLabel titleLabel = new JLabel("TITLE");
        titleField = new JTextField(20);
        JLabel categoryLabel = new JLabel("CATEGORY");
        categoryField = new JTextField(20);
        JLabel costLabel = new JLabel("COST");
        costField = new JTextField(20);

        center.add(idLabel);
        center.add(idField);
        center.add(titleLabel);
        center.add(titleField);
        center.add(categoryLabel);
        center.add(categoryField);
        center.add(costLabel);
        center.add(costField);

        add(center, BorderLayout.CENTER);
    }
    protected void addItem(){

    }
}
