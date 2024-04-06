import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SettingPanel extends JPanel {
    private JCheckBox aimCheckBox;
    private JCheckBox musicCheckBox;
    private JCheckBox saveHistoryCheckBox;
    private JButton applyButton;
    private GameFrame gameFrame;

    public SettingPanel(GameFrame gameFrame) {
        this.gameFrame=gameFrame;
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(4, 1)); // 4 rows, 1 column grid layout

        // Panel for aim visibility
        JPanel aimPanel = new JPanel();
        aimPanel.setBackground(Color.WHITE);
        aimCheckBox = new JCheckBox("Show Aim");
        aimPanel.add(aimCheckBox);

        // Panel for music toggle
        JPanel musicPanel = new JPanel();
        musicPanel.setBackground(Color.WHITE);
        musicCheckBox = new JCheckBox("Play Music");
        musicCheckBox.setSelected(true);
        musicPanel.add(musicCheckBox);

        // Panel for saving game history
        JPanel saveHistoryPanel = new JPanel();
        saveHistoryPanel.setBackground(Color.WHITE);
        saveHistoryCheckBox = new JCheckBox("Save Game History");
        saveHistoryPanel.add(saveHistoryCheckBox);

        // Panel for apply button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        applyButton = new JButton("Apply");
        buttonPanel.add(applyButton);

        // Add panels to the ThirdPanel
        this.add(aimPanel);
        this.add(musicPanel);
        this.add(saveHistoryPanel);
        this.add(buttonPanel);

        // ActionListener for the apply button
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions when apply button is clicked
                boolean showAim = aimCheckBox.isSelected();
                boolean playMusic = musicCheckBox.isSelected();
                boolean saveHistory = saveHistoryCheckBox.isSelected();


                System.out.println("Show Aim: " + showAim);
                System.out.println("Play Music: " + playMusic);
                System.out.println("Save Game History: " + saveHistory);
                gameFrame.setPlayMusic(playMusic);



        ;


        }});
        musicCheckBox.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // If the checkbox is checked (selected)
                gameFrame.setPlayMusic(true); // Start playing the music
            } else {
                // If the checkbox is unchecked (deselected)
                gameFrame.setPlayMusic(false); // Stop playing the music
            }
        }
    });}}