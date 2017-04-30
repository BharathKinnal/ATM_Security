import javax.swing.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddCustomer {
    private JTextField enterYourNameTextField ;
    private JTextField textField1 ;
    private JTextField enterYourMobileNumberTextField ;
    private JTextField textField3 ;
    private JTextField enterYourEmailIDTextField ;
    private JButton proceedToSetPasswordButton ;
    private JTextField textField2 ;
    private JTextField enterYourCurrentAddressTextField ;
    private JTextArea textArea1 ;
    private JTextField enterYourPermanentAddressTextField ;
    private JTextArea textArea2 ;
    private JTextField createANewAccountTextField ;
    private JPanel main_panel;
    private JTextField textField4;
    private JTextField yourAccountNumberTextField;

    public String name ;
    public String mobile ;
    public String email ;
    public String current ;
    public String permanent ;
    public long balance = 0 ;
    public static long account_number ;
    public static boolean add_customer = false ;

    public AddCustomer() {
        proceedToSetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                add_customer = true ;
                name = textField1.getText() ;
                mobile = textField3.getText() ;
                email = textField2.getText() ;
                current = textArea1.getText() ;
                permanent = textArea2.getText() ;

                if(!name.equals("") && !mobile.equals("") && !email.equals("") && !current.equals("") && !permanent.equals("")) {
                    String fname = account_number + ".txt" ;
                    String fbalance = account_number + "_balance.txt" ;
                    try {
                        FileWriter fstream = new FileWriter(fname) ;
                        BufferedWriter out = new BufferedWriter(fstream) ;
                        out.write("Account Number: " + account_number + "\n\n");
                        out.write("Name: " + name + "\n") ;
                        out.write("Mobile Number: " + mobile + "\n") ;
                        out.write("Email-id: " + email + "\n\n") ;
                        out.write("Current Address:\n" + current + "\n\n") ;
                        out.write("Permanent Address:\n" + permanent + "\n\n") ;

                        out.close() ;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage()) ;
                        System.exit(1) ;
                    }

                    try {
                        FileWriter fstream = new FileWriter(fbalance) ;
                        BufferedWriter out = new BufferedWriter(fstream) ;
                        out.write(Long.toString(balance)) ;
                        out.close() ;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage()) ;
                        System.exit(1) ;
                    }

                    new ATM_SetPassword().main() ;
                }
            }
        });
    }

    public static void main() {
        AddCustomer addCustomer = new AddCustomer() ;
        JFrame frame = new JFrame("Add Customer") ;
        frame.setContentPane(addCustomer.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;

        addCustomer.account_number = System.currentTimeMillis() ;
        addCustomer.textField4.setText(Long.toString(addCustomer.account_number)) ;
    }
}