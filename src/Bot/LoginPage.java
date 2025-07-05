//Login Page

package Bot;

import javax.swing.*;
import java.awt.*;

public class LoginPage {
    static String[] user =new String[5];
    String[] pass =new String[5];

    String use;
    String pas;


    JFrame frame ;
    JPanel panel ;
    JTextField usernameFeild ;
    JPasswordField passwordField;
    JLabel usernameLabel ;
    JLabel passwordLabel ;
    JLabel iconLabel ;
    JLabel wellcomeback;
    JButton loginButton ;
    JLabel signupLabel;
    JButton signUpButton;
    ImageIcon header = new ImageIcon("src\\Bot\\icons\\icon image.png");
    ImageIcon wc_icon = new ImageIcon("src\\Bot\\icons\\30.png");
    Image wc_image = wc_icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    ImageIcon Scaledwc_icon = new ImageIcon(wc_image);
    LoginPage() {


        // Setting Up variables
        frame = new JFrame();
        panel = new JPanel();
        usernameFeild = new JTextField();
        passwordField = new JPasswordField();
        usernameLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");
        loginButton = new JButton( "Login");
        signupLabel = new JLabel("Create new Account");
        signUpButton = new JButton("Sign up");

        // Setting up WELLCOM ICON
        iconLabel = new JLabel(Scaledwc_icon);
        iconLabel.setBounds(275,90,60,60);

        //Setting up WelcomeLabel
        wellcomeback = new JLabel("WellComeBack!");
        wellcomeback.setForeground(Color.WHITE);
        wellcomeback.setBounds(340,108,200,30);
        wellcomeback.setFont(new Font("Times New Roman",Font.PLAIN,25));


        //SEtting up Username LAnel And Feild
        usernameLabel.setBounds(275,198,70,10);
        usernameLabel.setForeground(Color.WHITE);
        usernameFeild.setBounds(275,215,250,30);
        usernameFeild.setBackground(new Color(52,53,65,255));
        usernameFeild.setForeground(Color.WHITE);
        //  usernameFeild.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        usernameFeild.setCaretColor(Color.WHITE);

        //Setting up password Label and Feild
        passwordLabel.setBounds(275,258,70,10);
        passwordLabel.setForeground(Color.WHITE);
        passwordField.setBounds(275,275,250,30);
        passwordField.setBackground(new Color(52,53,65,255));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        passwordField.setCaretColor(Color.WHITE);


        //Setting up Login Button
        loginButton.setBounds(275,335,250,30);
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(112,191,255,255));

        //Action Listener For Login Button
        loginButton.addActionListener(e -> {

                    use = usernameFeild.getText();
                    pas = passwordField.getText();

                    Conn jdbc = new Conn();
            try {
                if (jdbc.search_Login(use,pas)) {
                    frame.dispose();
                    new ChatInterface(use);
                  }

                else{
                    JOptionPane.showMessageDialog(panel, "Invalid, Username or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
                    usernameFeild.setText(null);
                    passwordField.setText(null);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        });


        //setting up Signup button and lebel
        signupLabel.setBounds(320,415,200,20);
        signupLabel.setForeground(Color.WHITE);
        signupLabel.setFont(new Font(null,Font.PLAIN,10));

        signUpButton.setBounds(410,415,60,20);
        signUpButton.setFont(new Font(null,Font.PLAIN,10));
        signUpButton.setFocusable(false);
        signUpButton.setForeground(new Color(112,191,255,255));
        signUpButton.setBorder(BorderFactory.createLineBorder(new Color(52,53,65,255)));
        signUpButton.setBackground(new Color(52,53,65,255));

        signUpButton.addActionListener(e ->{

            if(e.getSource() == signUpButton)
            {
                frame.dispose();
                new SignUpPage();


            }

        });



        //Adding everyThing in panel
        panel.setLayout(null);
        panel.add(iconLabel);
        panel.add(wellcomeback);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(usernameFeild);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);
        panel.add(signupLabel);
        panel.setBackground(new Color(52,53,65,255));
        frame.add(panel,BorderLayout.CENTER);

        //Setting Up Frame
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setTitle("Chatbot");
        frame.setIconImage(header.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

