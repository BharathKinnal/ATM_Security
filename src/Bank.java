import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank {
    private JButton addCustomerButton;
    private JButton viewCustomerDetailsButton;
    private JButton withdrawAmountButton;
    private JButton printBalanceButton;
    private JButton depositAmountButton;
    private JButton transferAmountButton;
    private JPanel main_panel;
    private JPanel options_panel;
    private JButton quitButton;
    private JTextField welcomeToAMoreTextField;
    private JButton changePasswordButton;

    public Bank() {
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddCustomer().main() ;
            }
        });

        viewCustomerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ViewCustomer().main() ;
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ChangePassword().main() ;
            }
        });

        withdrawAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WithdrawAmount().main() ;
            }
        });

        depositAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new DepositAmount().main() ;
            }
        });

        printBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PrintReceipt().main() ;
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main_panel.setVisible(false) ;
            }
        });
    }

    public static void main(String[] args) {
        Bank bank = new Bank() ;
        JFrame frame = new JFrame("Bank") ;
        frame.setContentPane(bank.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }

    public static void main() {
        Bank bank = new Bank() ;
        JFrame frame = new JFrame("Bank") ;
        frame.setContentPane(bank.main_panel) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(650, 650) ;
        frame.setVisible(true) ;
    }
}
