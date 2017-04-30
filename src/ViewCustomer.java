import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class ViewCustomer {
    public JTextArea textArea1;
    private JTextField textField2;
    private JButton proceedToFetchDetailsButton;
    private JTextField enterYourAccountNumberTextField;
    private JPanel enter_panel;
    private JPanel area_panel;
    private JTextField customerDetailsTextField;
    private JButton proceedButton;
    private JButton quitButton;
    private JPanel main_panel;
    private JButton quitButton1;

    public static String account_number ;
    public String correct_pass = "" ;
    public static boolean view_customer = false ;

    public ViewCustomer() {
        proceedToFetchDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view_customer = true ;
                account_number = textField2.getText() ;
                if(!account_number.equals("")) {
                    String fpass = account_number + "_password.txt" ;
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fpass)) ;
                        String line ;
                        while((line = reader.readLine()) != null)
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

        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Bank().main() ;
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                enter_panel.setVisible(false) ;
            }
        });

        quitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                area_panel.setVisible(false) ;
            }
        });
    }

    public static void main() {
        ViewCustomer viewCustomer = new ViewCustomer() ;

        JFrame frame = new JFrame("View Customer Details") ;
        frame.setContentPane(viewCustomer.enter_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }

    public static void main_details() {
        ViewCustomer viewCustomer = new ViewCustomer() ;

        JFrame frame = new JFrame("View Customer Details") ;
        frame.setContentPane(viewCustomer.area_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;

        viewCustomer.textArea1.setText(ATM_VerifyPassword.details) ;
    }
}