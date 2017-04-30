import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PatternGUI extends JPanel {
    private JPanel main_panel ;
    private JPanel root ;

    Point start = null ;
    Point end = null ;

    public PatternGUI() {
        root.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                start = mouseEvent.getPoint() ;
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                start = null ;
            }
        });
        root.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                end = mouseEvent.getPoint() ;
                Graphics g = root.getGraphics() ;
                if (start != null) {
                    g.setColor(Color.RED) ;
                    g.drawLine(start.x, start.y, end.x, end.y) ;
                }
            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                end = mouseEvent.getPoint() ;
                Graphics g = root.getGraphics() ;
                if (start != null) {
                    g.setColor(Color.RED) ;
                    g.drawLine(start.x, start.y, end.x, end.y) ;
                }
                repaint() ;
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g) ;
        if (start != null) {
            g.setColor(Color.RED) ;
            g.drawLine(start.x, start.y, end.x, end.y) ;
        }
    }

    public static void main(String[] args) {
        PatternGUI patternGUI = new PatternGUI() ;
        JFrame frame = new JFrame("Draw") ;
        frame.setContentPane(patternGUI.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(600, 600) ;
        frame.setLocation(300, 300) ;
        frame.setResizable(false) ;
        frame.setVisible(true) ;
    }
}