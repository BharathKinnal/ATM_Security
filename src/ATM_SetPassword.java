import javax.swing.* ;
import java.awt.*;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ATM_SetPassword {

    private JButton a1Button ;
    private JButton a2Button ;
    private JButton a3Button ;
    private JButton a4Button ;
    private JButton a5Button ;
    private JButton a6Button ;
    private JButton a7Button ;
    private JButton a8Button ;
    private JButton a9Button ;
    private JPanel main_panel ;
    private JPanel pass_panel ;
    private JPanel tool_panel ;
    private JTextField passField ;
    private JButton quitButton ;
    private JButton proceedButton ;
    private JTextField enterYourPatternTextField ;
    private JTextField accountNumberTextField;

    public String password = "" ;
    public String account_number ;

    public ATM_SetPassword() {
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "1" ;
                passField.setText(password) ;
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "2" ;
                passField.setText(password) ;
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "3" ;
                passField.setText(password) ;
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "4" ;
                passField.setText(password) ;
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "5" ;
                passField.setText(password) ;
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "6" ;
                passField.setText(password) ;
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "7" ;
                passField.setText(password) ;
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "8" ;
                passField.setText(password) ;
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "9" ;
                passField.setText(password) ;
            }
        });
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final String finalPass  = passField.getText() ;

                String fname = account_number + "_password.txt" ;
                try {
                    FileWriter fstream = new FileWriter(fname) ;
                    BufferedWriter out = new BufferedWriter(fstream) ;
                    out.write(finalPass) ;
                    out.close() ;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                // ATM_Password atm_password = new ATM_Password() ;
                // atm_password.main() ;
                if(new AddCustomer().add_customer) {
                    new AddCustomer().add_customer = false;
                    new Bank().main();
                } else if(new ChangePassword().change_pass) {
                    new ChangePassword().change_pass = false ;
                    new ChangePassword().main_print() ;
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

    public static void main() {
        ATM_SetPassword atm_setPassword = new ATM_SetPassword();

        JFrame frame = new JFrame("Set Password");
        frame.setContentPane(atm_setPassword.main_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setVisible(true);

        atm_setPassword.passField.setFocusable(false);

        if (new AddCustomer().add_customer) {
            atm_setPassword.account_number = Long.toString(new AddCustomer().account_number) ;
            atm_setPassword.accountNumberTextField.setText("Account Number: " + atm_setPassword.account_number) ;
        } else if(new ChangePassword().change_pass) {
            atm_setPassword.account_number = new ChangePassword().account_number ;
            atm_setPassword.accountNumberTextField.setText("Account Number: " + atm_setPassword.account_number) ;
        }
    }
}