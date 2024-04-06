import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class GameFrame extends JFrame {
    private FirstPanel firstPanel;
    private Clip backgroundMusicClip; // Store the Clip object
    private boolean playMusic; // Variable to store the state of play music option

    public GameFrame() {
        this.setTitle("Brick Breaker");
        this.setDefaultCloseOperation(GameFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        playMusic = true;
        firstPanel = new FirstPanel();
        this.add(firstPanel);

        // Play background music if playMusic option is true
        if (playMusic){ backgroundMusicClip = playBackgroundMusic("C:\\Users\\tabas\\Desktop\\2_cardigan.wav");}

        SettingPanel settingPanel = new SettingPanel(this);
        this.setVisible(true);
    }

    private Clip playBackgroundMusic(String filePath) {
        try {
            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));

            // Get a Clip object
            Clip clip = AudioSystem.getClip();

            // Open the audio input stream with the Clip
            clip.open(audioInputStream);

            // Loop the clip continuously
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing the clip
            clip.start();
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPlayMusic(boolean playMusic) {
        // If play music option changes
        if (playMusic != this.playMusic) {
            this.playMusic = playMusic;

            if (playMusic) {
                // Start playing the music
                backgroundMusicClip = playBackgroundMusic("C:\\Users\\tabas\\Desktop\\2_cardigan.wav");
            }
            else {
                // Stop playing the music

                    backgroundMusicClip.stop();
                    backgroundMusicClip.close();
            }
//
    }
    }}
