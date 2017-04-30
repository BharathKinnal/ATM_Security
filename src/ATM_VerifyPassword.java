import javax.swing.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ATM_VerifyPassword {
    private JTextField passField ;
    private JPanel main_panel ;
    private JPanel tool_panel ;
    private JButton quitButton ;
    private JButton proceedButton ;

    boolean flag ;
    String account_number ;
    public static String details = "" ;
    public static String balance_check = "" ;
    static String correctPassword, enteredPassword ;

    public ATM_VerifyPassword() {
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!flag) {
                    ATM_Password atm_password = new ATM_Password();
                    atm_password.main();
                } else {
                    ViewCustomer viewCustomer = new ViewCustomer() ;
                    ChangePassword changePassword = new ChangePassword() ;
                    WithdrawAmount withdrawAmount = new WithdrawAmount() ;
                    DepositAmount depositAmount = new DepositAmount() ;
                    PrintReceipt printReceipt = new PrintReceipt() ;

                    if (viewCustomer.view_customer) {
                        account_number = viewCustomer.account_number;
                        String fname = account_number + ".txt";
                        try {
                            details = readFile(fname);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.exit(1) ;
                        }
                        // System.out.println(details) ;
                        viewCustomer.view_customer = false ;
                        viewCustomer.main_details() ;
                    } else if(changePassword.change_pass) {
                        ATM_SetPassword atm_setPassword = new ATM_SetPassword() ;
                        atm_setPassword.main() ;
                    } else if(withdrawAmount.withdraw) {
                        WithdrawAmount.withdraw = false ;
                        withdrawAmount.main_withdraw() ;
                    } else if(depositAmount.deposit) {
                        depositAmount.deposit = false ;
                        depositAmount.main_deposit() ;
                    } else if (printReceipt.print_receipt) {
                        account_number = printReceipt.account_number ;
                        String fname = account_number + ".txt";
                        try {
                            details = readFile(fname);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.exit(1) ;
                        }
                        String fbalance = account_number + "_balance.txt";
                        try {
                            balance_check = readFile(fbalance) ;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.exit(1) ;
                        }
                        printReceipt.print_receipt = false ;
                        printReceipt.main_print() ;
                    }
                }
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main_panel.setVisible(false) ;
            }
        });
    }

    private String readFile(String pathname) throws IOException {

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

    public static void main() {
        ATM_VerifyPassword atm_verifyPassword = new ATM_VerifyPassword() ;

        JFrame frame = new JFrame("Verify Password") ;
        frame.setContentPane(atm_verifyPassword.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;

        atm_verifyPassword.passField.setFocusable(false) ;

        if(atm_verifyPassword.correctPassword.equals(atm_verifyPassword.enteredPassword)) {
            atm_verifyPassword.passField.setText("Password entered matches the pattern.");
            atm_verifyPassword.flag = true ;
        } else
            atm_verifyPassword.passField.setText("Password entered is incorrect. Please proceed to enter again.") ;
    }
}