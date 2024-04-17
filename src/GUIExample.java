import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIExample implements ActionListener, MouseListener, MouseMotionListener {
    public JPanel panel;
    private final int rectWidth = 100; // Width of the rectangle
    private final int rectHeight = 100; // Height of the rectangle
    private int mouseX, mouseY; // Mouse coordinates
    private int rectX;
    private int rectY;

    public GUIExample() {
        panel = new JPanel(new BorderLayout()){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(rectX,rectY, rectWidth, rectHeight);
            }
        };
        JButton button = new JButton("Click me");
        button.addActionListener(this);
        panel.add(button, BorderLayout.SOUTH);
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Button Clicked");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Updating coordinate a rectangle
        rectX = e.getX() - (rectWidth/2);
        rectY = e.getY() - (rectHeight/2);
        panel.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX(); //X- mouseCordinate
        mouseY = e.getY(); //Y- mouseCordinate
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - mouseX; //Mouse coordinate when dragging
        int dy = e.getY() - mouseY;
        //Check if the new position of the rectangle is within the bounds of the panel
        if(rectX + dx >= 0 && rectX + dx + rectWidth <= panel.getWidth()){
            rectX += dx; //Update coordinate of a rectangle
        }
        if(rectY + dy >= 0 && rectY + dx + rectHeight <= panel.getHeight()){
            rectY += dy;
        }
        mouseX = e.getX();
        mouseY = e.getY();
        panel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
