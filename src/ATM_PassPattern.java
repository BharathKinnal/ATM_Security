import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ATM_PassPattern extends JPanel {
    private JPanel pattern_panel ;
    private JLabel dot1Label ;
    private JLabel dot2Label ;
    private JLabel dot3Label ;
    private JLabel dot4Label ;
    private JLabel dot5Label ;
    private JLabel dot6Label ;
    private JLabel dot7Label ;
    private JLabel dot8Label ;
    private JLabel dot9Label ;
    private JPanel main_panel ;

    ArrayList<Point> points = new ArrayList<Point>() ;

    public ATM_PassPattern() {
        dot1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot1Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot2Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot3Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot4Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot4Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot5Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot5Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot6Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot6Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot7Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot7Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot8Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot8Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });

        dot9Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dotsMousePressed(mouseEvent);
            }
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dotsMouseReleased(mouseEvent);
            }
        });
        dot9Label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                screenMouseDragged(mouseEvent);
            }
        });
    }

    private void dotsMousePressed(MouseEvent mouseEvent) {
        // Do Nothing
    }

    private void dotsMouseReleased(MouseEvent mouseEvent) {
        // Do Nothing
    }

    private void screenMouseDragged(MouseEvent mouseEvent) {
        points.add(mouseEvent.getPoint()) ;
        repaint() ;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics) ;
        for(int i = 0; i < points.size()-2 ; i++) {
            Point start = points.get(i) ;
            Point end = points.get(i+1) ;
            graphics.setColor(Color.red) ;
            graphics.drawLine(start.x, start.y, end.x, end.y) ;
        }
    }

    public static void main() {
        ATM_PassPattern atm_passPattern = new ATM_PassPattern() ;

        JFrame frame = new JFrame("ATM Pattern") ;
        frame.setContentPane(atm_passPattern.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }
}