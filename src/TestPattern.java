import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TestPattern {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw a line") ;
        frame.setSize(600, 600) ;
        frame.setLocation(300, 300) ;
        frame.setResizable(false) ;

        JPanel panel = new JPanel() {
            Point start = null ;
            Point end = null ;
            {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        start = mouseEvent.getPoint() ;
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {
                        end = mouseEvent.getPoint() ;
                        start = null ;
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent mouseEvent) {
                        end = mouseEvent.getPoint() ;
                    }

                    @Override
                    public void mouseDragged(MouseEvent mouseEvent) {
                        end = mouseEvent.getPoint() ;
                        repaint() ;
                    }
                });
            }

            public void paint(Graphics graphics) {
                super.paint(graphics) ;
                if(start != null) {
                    graphics.setColor(Color.RED) ;
                    graphics.drawLine(start.x, start.y, end.x, end.y) ;
                }
            }
        } ;
        frame.add(panel) ;
        frame.setVisible(true) ;
    }
}