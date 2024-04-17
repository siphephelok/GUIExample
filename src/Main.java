import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setTitle("GUI Example");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        GUIExample guiExample = new GUIExample();
        frame.add(guiExample.panel);
        frame.setVisible(true);
    }
}
