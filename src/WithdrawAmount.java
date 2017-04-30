import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WithdrawAmount {
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
    private JPanel mid_panel;
    private JTextField enterTheAmountWithdrawTextField;
    private JTextField textField3;
    private JTextField textField2;
    private JButton proceedButton2;
    private JButton quitButton2;
    private JTextField print_balance;

    public static boolean withdraw = false ;
    public static String account_number ;
    public String correct_pass = "", value = "" ;
    public long balance ;
    public static boolean possible = false ;

    public WithdrawAmount() {
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                withdraw = true ;
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
                // System.out.println("Balance: " + value) ;
                balance = Long.parseLong(value) ;
                if(balance >= Long.parseLong(textField3.getText())) {
                    balance -= Long.parseLong(textField3.getText());
                    possible = true ;
                    try {
                        FileWriter fstream = new FileWriter(fbalance) ;
                        BufferedWriter out = new BufferedWriter(fstream) ;
                        out.write(Long.toString(balance)) ;
                        out.close() ;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.exit(1) ;
                    }
                } else
                    possible = false ;
                new WithdrawAmount().main_print() ;
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

        quitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mid_panel.setVisible(false) ;
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                print_panel.setVisible(false) ;
            }
        });
    }

    public static void main() {
        WithdrawAmount withdrawAmount = new WithdrawAmount() ;

        JFrame frame = new JFrame("Withdraw amount") ;
        frame.setContentPane(withdrawAmount.ask_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }

    public static void main_withdraw() {
        WithdrawAmount withdrawAmount = new WithdrawAmount() ;

        JFrame frame = new JFrame("Withdraw amount") ;
        frame.setContentPane(withdrawAmount.mid_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }

    public static void main_print() {
        WithdrawAmount withdrawAmount = new WithdrawAmount() ;

        JFrame frame = new JFrame("Withdraw amount") ;
        frame.setContentPane(withdrawAmount.print_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;

        if(withdrawAmount.possible)
            withdrawAmount.textField2.setText("Successful") ;
        else
            withdrawAmount.textField2.setText("Un-successful") ;

        String fbalance = account_number + "_balance.txt" ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fbalance)) ;
            String line ;
            while ((line = reader.readLine()) != null)
                withdrawAmount.value += line ;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()) ;
            System.exit(1) ;
        }
        withdrawAmount.print_balance.setText(withdrawAmount.value + "/-") ;
    }
}