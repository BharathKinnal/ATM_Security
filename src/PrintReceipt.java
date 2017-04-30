import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class PrintReceipt {

    private JPanel ask_panel;
    private JButton proceedButton;
    private JButton quitButton1;
    private JTextField enterYourAccountNumberTextField;
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextField receiptTextField;
    private JPanel print_panel;
    private JButton proceedButton2;
    private JButton quitButton2;
    private JTextField textField2;

    public static boolean print_receipt = false ;
    public static String account_number ;
    public String correct_pass = "" ;

    public PrintReceipt() {
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                print_receipt = true ;
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

        proceedButton2.addActionListener(new ActionListener() {
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

        quitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                print_panel.setVisible(false) ;
            }
        });
    }

    public static void main() {
        PrintReceipt printReceipt = new PrintReceipt() ;

        JFrame frame = new JFrame("Print Receipt") ;
        frame.setContentPane(printReceipt.ask_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }

    public static void main_print() {
        PrintReceipt printReceipt = new PrintReceipt();

        JFrame frame = new JFrame("Print Receipt");
        frame.setContentPane(printReceipt.print_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setVisible(true);

        printReceipt.textArea1.setText(new ATM_VerifyPassword().details) ;
        printReceipt.textField2.setText("Balance: " + new ATM_VerifyPassword().balance_check) ;
    }
}