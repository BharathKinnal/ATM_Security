import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ATM_Password {
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
    private JPanel user_panel ;
    private JPanel tool_panel ;
    private JPanel text_panel ;
    private JTextField passField ;
    private JTextField ATMPasswordDisplayScreenTextField ;
    private JTextField enterYourPINTextField ;
    private JButton button0 ;
    private JButton button1 ;
    private JButton button2 ;
    private JButton button3 ;
    private JButton button4 ;
    private JButton button5 ;
    private JButton button6 ;
    private JButton button7 ;
    private JButton button8 ;
    private JButton button9 ;
    private JButton quitButton ;
    private JButton proceedButton ;

    public String password = "", enteredPass = "", correctPass = "" ;

    public ATM_Password() {
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "0" ;
                passField.setText(password);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "1" ;
                passField.setText(password);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "2" ;
                passField.setText(password);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "3" ;
                passField.setText(password);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "4" ;
                passField.setText(password);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "5" ;
                passField.setText(password);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "6" ;
                passField.setText(password);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "7" ;
                passField.setText(password);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "8" ;
                passField.setText(password);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                password += "9" ;
                passField.setText(password);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main_panel.setVisible(false) ;
            }
        });
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                enteredPass = passField.getText() ;
                passField.setText(enteredPass) ;
                correctPass = getPassword(enteredPass) ;
                passField.setText(correctPass) ;

                ATM_VerifyPassword atm_verifyPassword = new ATM_VerifyPassword() ;
                atm_verifyPassword.enteredPassword = correctPass ;

                atm_verifyPassword.main() ;
            }
        });
    }

    public String getPassword (String password) {
        String correctPass = "" ;
        for(int i = 0; i < password.length(); i++) {
            if (a1Button.getText().charAt(0) == password.charAt(i))
                correctPass += "1";
            else if (a2Button.getText().charAt(0) == password.charAt(i))
                correctPass += "2";
            else if (a3Button.getText().charAt(0) == password.charAt(i))
                correctPass += "3" ;
            else if (a4Button.getText().charAt(0) == password.charAt(i))
                correctPass += "4" ;
            else if (a5Button.getText().charAt(0) == password.charAt(i))
                correctPass += "5" ;
            else if (a6Button.getText().charAt(0) == password.charAt(i))
                correctPass += "6" ;
            else if (a7Button.getText().charAt(0) == password.charAt(i))
                correctPass += "7" ;
            else if (a8Button.getText().charAt(0) == password.charAt(i))
                correctPass += "8" ;
            else if (a9Button.getText().charAt(0) == password.charAt(i))
                correctPass += "9" ;
        }
        return correctPass ;
    }

    public static void main() {
        ATM_Password atm_password = new ATM_Password() ;
        ArrayList<Integer> list = new ArrayList<>() ;

        JFrame frame = new JFrame("Enter Password") ;
        frame.setContentPane(atm_password.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650);
        frame.setVisible(true);

        atm_password.passField.setFocusable(false) ;

        for (int i = 0; i < 10; i++)
            list.add(i) ;
        Collections.shuffle(list) ;

        atm_password.a1Button.setText(Integer.toString(list.get(0))) ;
        atm_password.a2Button.setText(Integer.toString(list.get(1))) ;
        atm_password.a3Button.setText(Integer.toString(list.get(2))) ;
        atm_password.a4Button.setText(Integer.toString(list.get(3))) ;
        atm_password.a5Button.setText(Integer.toString(list.get(4))) ;
        atm_password.a6Button.setText(Integer.toString(list.get(5))) ;
        atm_password.a7Button.setText(Integer.toString(list.get(6))) ;
        atm_password.a8Button.setText(Integer.toString(list.get(7))) ;
        atm_password.a9Button.setText(Integer.toString(list.get(8))) ;

        atm_password.a1Button.setEnabled(false) ;
        atm_password.a2Button.setEnabled(false) ;
        atm_password.a3Button.setEnabled(false) ;
        atm_password.a4Button.setEnabled(false) ;
        atm_password.a5Button.setEnabled(false) ;
        atm_password.a6Button.setEnabled(false) ;
        atm_password.a7Button.setEnabled(false) ;
        atm_password.a8Button.setEnabled(false) ;
        atm_password.a9Button.setEnabled(false) ;
    }
}