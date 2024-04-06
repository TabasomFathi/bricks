import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartNewGamePanel extends JPanel {

        private JComboBox<String> difficultyComboBox;
        private JComboBox<String> colorComboBox;
        private JTextField nameTextField;
        private JButton startButton;
        private JPanel parentPanel;

        public StartNewGamePanel() {
            this.setBackground(Color.WHITE);
            this.setLayout(new GridLayout(5, 1)); // 5 rows, 1 column grid layout

            // Panel for choosing difficulty
            JPanel difficultyPanel = new JPanel();
            difficultyPanel.setBackground(Color.WHITE);
            JLabel difficultyLabel = new JLabel("Choose Difficulty:");
            String[] difficultyOptions = {"Easy", "Medium", "Hard"};
            difficultyComboBox = new JComboBox<>(difficultyOptions);
            difficultyPanel.add(difficultyLabel);
            difficultyPanel.add(difficultyComboBox);

            // Panel for choosing ball color
            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(Color.WHITE);
            JLabel colorLabel = new JLabel("Choose Ball Color:");
            String[] colorOptions = {"Black", "Blue", "Red", "Green"};
            colorComboBox = new JComboBox<>(colorOptions);
            colorPanel.add(colorLabel);
            colorPanel.add(colorComboBox);

            // Panel for entering name
            JPanel namePanel = new JPanel();
            namePanel.setBackground(Color.WHITE);
            JLabel nameLabel = new JLabel("Enter Your Name:");
            nameTextField = new JTextField(20);
            namePanel.add(nameLabel);
            namePanel.add(nameTextField);

            // Panel for start button
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            startButton = new JButton("Start Game");
            buttonPanel.add(startButton);

            // Add panels to the SecondPanel
            this.add(difficultyPanel);
            this.add(colorPanel);
            this.add(namePanel);
            this.add(buttonPanel);

            // ActionListener for the start button
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Perform actions when start button is clicked
                    String difficulty = (String) difficultyComboBox.getSelectedItem();
                    String color = (String) colorComboBox.getSelectedItem();
                    String name = nameTextField.getText();

                    System.out.println("Difficulty: " + difficulty);
                    System.out.println("Color: " + color);
                    System.out.println("Name: " + name);

                    // Create and show GamePanel when START is clicked
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(StartNewGamePanel.this);
                    frame.setContentPane(new GamePanelAgain());
                    frame.revalidate(); // Refresh the frame
                }
            });
        }
    }
