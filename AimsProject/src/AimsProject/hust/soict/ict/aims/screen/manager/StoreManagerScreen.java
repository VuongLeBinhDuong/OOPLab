package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.media.*;
import AimsProject.hust.soict.ict.aims.store.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class StoreManagerScreen extends JFrame{
    private Store store;
    private JPanel north;
    private JPanel center;
    private JScrollPane scrollPane = new JScrollPane();
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View Store");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddBookToStoreScreen(store));
            }
        });

        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddCDToStoreScreen(store));
            }
        });

        addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddDVDToStoreScreen(store));
            }
        });

        viewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchStoreScreen();
            }
        });

        menu.add(viewStore);
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(new Color(200,179,237));
        List<Media> mediaInStore = store.getItemsInStore();
        center.removeAll();
        for (int i=0;i<mediaInStore.size();i++){
            GridBagConstraints mediaConstraints = new GridBagConstraints();
            mediaConstraints.gridx = i % 3;
            mediaConstraints.gridy = i / 3;
            mediaConstraints.insets = new Insets(5, 5, 5, 5);
            mediaConstraints.fill = GridBagConstraints.BOTH;
            mediaConstraints.weightx = 1.0;
            mediaConstraints.weighty = 1.0;

            MediaStore cell = new MediaStore(mediaInStore.get(i));
            cell.setPreferredSize(new Dimension(320, 120));
            center.add(cell, mediaConstraints);
        }
        center.revalidate();
        center.repaint();
        return center;
    }

    private void switchAddScreen(JPanel panel){
        getContentPane().remove(scrollPane);
        getContentPane().remove(center);
        this.center = panel;
        getContentPane().add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void switchStoreScreen(){
        getContentPane().remove(scrollPane);
        getContentPane().remove(center);
        this.center = createCenter();
        scrollPane = new JScrollPane(center);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public StoreManagerScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        this.center = createCenter();
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(center, BorderLayout.CENTER);
        scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cp.add(scrollPane, BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
