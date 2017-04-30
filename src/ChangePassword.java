import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class ChangePassword {
    private JButton proceedButton;
    private JButton quitButton1;
    private JPanel changed_panel;
    private JPanel ask_panel;
    private JButton proceedButton1;
    private JButton quitButton;
    private JTextField thePasswordHasBeenTextField;
    private JTextField enterYourAccountNumberTextField;
    private JTextField textField1;

    public static boolean change_pass = false ;
    public static String account_number ;
    public String correct_pass = "" ;

    public ChangePassword() {
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                change_pass = true ;
                account_number = textField1.getText() ;
                if (!account_number.equals("")) {
                    String fpass = account_number + "_password.txt" ;
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fpass)) ;
                        String line ;
                        while ((line = reader.readLine()) != null)
                            correct_pass += line ;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage()) ;
                        System.exit(1) ;
                    }
                    System.out.println("Correct_pass: " + correct_pass) ;
                    ATM_VerifyPassword atm_verifyPassword = new ATM_VerifyPassword() ;
                    atm_verifyPassword.correctPassword = correct_pass ;
                    new ATM_Password().main() ;
                }
            }
        });

        proceedButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Bank().main() ;
            }
        });

        quitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ask_panel.setVisible(false) ;
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changed_panel.setVisible(false) ;
            }
        });
    }

    public static void main() {
        ChangePassword changePassword = new ChangePassword() ;

        JFrame frame = new JFrame("Change Password") ;
        frame.setContentPane(changePassword.ask_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }

    public static void main_print() {
        ChangePassword changePassword = new ChangePassword() ;

        JFrame frame = new JFrame("Change Password") ;
        frame.setContentPane(changePassword.changed_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }
}