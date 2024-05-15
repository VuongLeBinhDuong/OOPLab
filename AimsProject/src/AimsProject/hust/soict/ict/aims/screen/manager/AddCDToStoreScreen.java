package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.store.Store;
import AimsProject.hust.soict.ict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCDToStoreScreen extends AddItemToStoreScreen{
    private JTextField artistField, directorField;
    private JPanel trackPanel;
    private JButton addTrackButton;
    private JButton addButton;
    private List<trackPanel> trackPanels;

    private class trackPanel extends JPanel {
        private JTextField nameField, lengthField;
        public trackPanel() {
            nameField = new JTextField(20);
            lengthField = new JTextField(10);
            add(new JLabel("TRACK NAME"));
            add(nameField);
            add(new JLabel("LENGTH"));
            add(lengthField);
        }

        public String getTrackName() {
            return nameField.getText();
        }

        public int getLength() {
            try {
                return Integer.parseInt(lengthField.getText());
            } catch (NumberFormatException e) {
                // Handle invalid input gracefully
                return 0;
            }
        }
    }

    private void addTrack() {
        trackPanel newTrackPanel = new trackPanel();
        trackPanel.add(newTrackPanel);
        trackPanels.add(newTrackPanel);
        trackPanel.revalidate();
        trackPanel.repaint();
    }

    public AddCDToStoreScreen (Store store){
        super(store);
        JLabel directorLabel  = new JLabel("DIRECTOR");
        directorField = new JTextField(20);
        center.add(directorLabel);
        center.add(directorField);
        JLabel artistLabel = new JLabel("ARTIST");
        artistField = new JTextField(20);

        trackPanel = new JPanel();
        trackPanel.setLayout(new BoxLayout(trackPanel, BoxLayout.Y_AXIS));
        trackPanels = new ArrayList<>();

        center.add(artistLabel);
        center.add(artistField);

        center.add(new JLabel("TRACKS"));
        center.add(trackPanel);

        addTrackButton = new JButton("ADD TRACK");
        addTrackButton.addActionListener((ActionEvent e) -> {
            addTrack();
        });

        center.add(addTrackButton);

        addButton = new JButton("ADD CD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
                JOptionPane.showMessageDialog(null,"New CD has been added");
            }
        });

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int preferredWidth = (int) (screenSize.width * 0.55);
        int preferredHeight = (int) (screenSize.height * 0.55);
        Dimension preferredSize = new Dimension(preferredWidth, preferredHeight);
        scrollPane.setPreferredSize(preferredSize);
        add(scrollPane, BorderLayout.CENTER);

        center.add(addButton);

    }

    protected void addItem() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String artist = artistField.getText();
        String director = directorField.getText();

        List<Track> tracks = new ArrayList<Track>();

        for (trackPanel trackPanel : trackPanels) {
            String trackName = trackPanel.getTrackName();
            int length = trackPanel.getLength();
            tracks.add(new Track(trackName, length));
        }

        CompactDisc CD = new CompactDisc(id, title, category, cost, director, artist, tracks);
        store.addMedia(CD);
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        directorField.setText("");
        trackPanels.clear();

    }

    public static void main(String[] args) {
        Store store = new Store();
        AddCDToStoreScreen addCDScreen = new AddCDToStoreScreen(store);
        addCDScreen.setVisible(true);
    }
}
