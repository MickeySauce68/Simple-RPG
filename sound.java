package fantasyadventure;

import java.io.File;                                        //imports for main function of the game
import java.io.IOException;                                 //
import javax.sound.sampled.AudioInputStream;                //imports for the sound of game 
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class sound 
{
    public static void Music() throws UnsupportedAudioFileException 
    {
        //---->Edit where file is located to add sound<----
            File file = new File("");
        try (AudioInputStream stream = AudioSystem.getAudioInputStream(file)) 
        {
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();    
        } 
        catch (IOException | LineUnavailableException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
}
