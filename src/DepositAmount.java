import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DepositAmount {
    private JPanel ask_panel;
    private JButton proceedButton;
    private JButton quitButton1;
    private JTextField enterYourAccountNumberTextField;
    private JTextField textField1;
    private JPanel print_panel;
    private JPanel changed_panel;
    private JButton proceedButton1;
    private JButton quitButton;
    private JTextField transactionStatusTextField;
    private JTextField textField2;
    private JPanel mid_panel;
    private JTextField enterTheAmountDepositTextField;
    private JTextField textField3;
    private JButton quitButton2;
    private JButton proceedButton2;
    private JTextField print_balance;

    public static boolean deposit = false ;
    public static String account_number ;
    public String correct_pass = "", value = "" ;
    public long balance ;

    public DepositAmount() {
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deposit = true;
                account_number = textField1.getText();
                if (!account_number.equals("")) {
                    String fpass = account_number + "_password.txt";
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fpass));
                        String line;
                        while ((line = reader.readLine()) != null)
                            correct_pass += line;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.exit(1) ;
                    }
                    System.out.println("Correct_pass: " + correct_pass);
                    ATM_VerifyPassword atm_verifyPassword = new ATM_VerifyPassword();
                    atm_verifyPassword.correctPassword = correct_pass;
                    new ATM_Password().main();
                }
            }
        });

        proceedButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fbalance = account_number + "_balance.txt" ;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fbalance)) ;
                    String line ;
                    while ((line = reader.readLine()) != null)
                        value += line ;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage()) ;
                    System.exit(1) ;
                }
                //System.out.println("Balance: " + value) ;
                balance = Long.parseLong(value);
                balance += Long.parseLong(textField3.getText());
                try {
                    FileWriter fstream = new FileWriter(fbalance) ;
                    BufferedWriter out = new BufferedWriter(fstream) ;
                    out.write(Long.toString(balance)) ;
                    out.close() ;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    System.exit(1) ;
                }
                new DepositAmount().main_print();
            }
        });

        proceedButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Bank().main();
            }
        });

        quitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ask_panel.setVisible(false);
            }
        });

        quitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mid_panel.setVisible(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                print_panel.setVisible(false);
            }
        });
    }


    public static void main() {
        DepositAmount depositAmount = new DepositAmount();

        JFrame frame = new JFrame("Deposit amount");
        frame.setContentPane(depositAmount.ask_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setVisible(true);
    }

    public static void main_deposit() {
        DepositAmount depositAmount = new DepositAmount();

        JFrame frame = new JFrame("Deposit amount");
        frame.setContentPane(depositAmount.mid_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setVisible(true);
    }

    public static void main_print() {
        DepositAmount depositAmount = new DepositAmount();

        JFrame frame = new JFrame("Deposit amount");
        frame.setContentPane(depositAmount.print_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setVisible(true);

        depositAmount.textField2.setText("Successful");
        String fbalance = account_number + "_balance.txt" ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fbalance)) ;
            String line ;
            while ((line = reader.readLine()) != null)
                depositAmount.value += line ;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()) ;
            System.exit(1) ;
        }
        depositAmount.print_balance.setText(depositAmount.value + "/-") ;
    }
}