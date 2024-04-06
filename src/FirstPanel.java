import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends JPanel {
    private JButton btn1,btn2,btn3,btn4,btn5;
    public FirstPanel(){
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 600, 600);
        this.setLayout(null); // Set layout to null to manually position buttons

        // Calculate button height and spacing
        int buttonHeight = 80;
        int spacing = (600 - (buttonHeight * 5)) / 6; // Adjust spacing to evenly distribute buttons

        // Calculate total height occupied by buttons and spacing
        int totalHeight = 5 * buttonHeight + 6 * spacing;
        // Calculate starting y position to center the buttons vertically
        int startY = (600 - totalHeight) / 2;

        // Initialize and position buttons
        btn1 = new JButton("START NEW GAME");
        btn1.setBounds(90, startY+10, 400, buttonHeight);
        // Add ActionListener to btn1
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show StartNewGamePanel when btn1 is clicked
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(FirstPanel.this);
                frame.setContentPane(new StartNewGamePanel());
                frame.revalidate(); // Refresh the frame
            }
        });

        btn2 = new JButton("TOTAL RECORD");
        btn2.setBounds(90, startY + buttonHeight + spacing, 400, buttonHeight);

        btn3 = new JButton("PREVIOUS GAMES ");
        btn3.setBounds(90, startY + 2 * (buttonHeight + spacing), 400, buttonHeight);

        btn4 = new JButton("SETTING");
        btn4.setBounds(90, startY + 3 * (buttonHeight + spacing), 400, buttonHeight);
        // Add ActionListener to btn4
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show SettingPanel when btn4 is clicked
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(FirstPanel.this);
                frame.setContentPane(new SettingPanel((GameFrame)frame));
                frame.revalidate(); // Refresh the frame
            }
        });

        btn5 = new JButton("EXIT");
        btn5.setBounds(90, startY + 4 * (buttonHeight + spacing), 400, buttonHeight);
        // Add ActionListener to btn5 to exit the program
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the program when btn5 is clicked
                System.exit(0);
            }
        });

        // Add buttons to the panel
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
    }
}
