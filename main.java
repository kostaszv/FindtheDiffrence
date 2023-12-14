import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import game.Diffrence;
import game.Imgdata;
import game.Save_to_Xml;
import game.CompareImg.*;
public class main {
    public static void main(String[] args) {
        
            
           System.out.println(game.ReadImage.ReadImages());
            Save_to_Xml.Save();
    }       


}
