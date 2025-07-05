//SignUp page

package Bot;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpPage {



    JFrame frame ;
    JPanel panel ;
    JTextField usernameFeild ;
    JTextField emailFeild;
    JPasswordField passwordField;
    JPasswordField passwordField2;
    JLabel usernameLabel ;
    JLabel emailLabel;
    JLabel passwordLabel ;
    JLabel CpasswordLabel;
    JLabel signupLabel;

    JButton signUpButton;
    JButton backButton;
    ImageIcon header = new ImageIcon("src\\Bot\\icons\\icon image.png");

    SignUpPage() {


        // Setting Up variables
        frame = new JFrame();
        panel = new JPanel();
        usernameFeild = new JTextField();
        emailFeild = new JTextField();
        passwordField = new JPasswordField();
        passwordField2 = new JPasswordField();
        usernameLabel = new JLabel("Username");
        emailLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");
        CpasswordLabel = new JLabel("Confirm Password");
        signUpButton = new JButton("Sign up");
        backButton = new JButton("<");



        //Setting  Sign up
        signupLabel = new JLabel("Sign Up");
        signupLabel.setForeground(Color.WHITE);
        signupLabel.setBounds(340,108,200,30);
        signupLabel.setFont(new Font("Times New Roman",Font.PLAIN,25));


        //SEtting up Username LAbel And Feild
        usernameLabel.setBounds(275,163,70,12);
        usernameLabel.setForeground(Color.WHITE);
        usernameFeild.setBounds(275,180,250,30);
        usernameFeild.setBackground(new Color(52,53,65,255));
        usernameFeild.setForeground(Color.WHITE);
        usernameFeild.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        usernameFeild.setCaretColor(Color.WHITE);



        //setting Up email Label and Feild
        emailLabel.setBounds(275,223,70,12);
        emailLabel.setForeground(Color.WHITE);
        emailFeild.setBounds(275,240,250,30);
        emailFeild.setBackground(new Color(52,53,65,255));
        emailFeild.setForeground(Color.WHITE);
        emailFeild.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        emailFeild.setCaretColor(Color.WHITE);



        //Setting up password Label and Feild
        passwordLabel.setBounds(275,283,70,12);
        passwordLabel.setForeground(Color.WHITE);
        passwordField.setBounds(275,300,250,30);
        passwordField.setBackground(new Color(52,53,65,255));
        passwordField.setForeground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        passwordField.setCaretColor(Color.WHITE);

        CpasswordLabel.setBounds(275,343,130,12);
        CpasswordLabel.setForeground(Color.WHITE);
        passwordField2.setBounds(275,360,250,30);
        passwordField2.setBackground(new Color(52,53,65,255));
        passwordField2.setForeground(Color.WHITE);
        passwordField2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        passwordField2.setCaretColor(Color.WHITE);

        backButton.setBounds(1,1,40,30);
        backButton.setFocusable(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font(null,Font.PLAIN,8));
        backButton.setBackground(new Color(52,53,65,255));
        backButton.addActionListener(e ->{
            if(e.getSource()==backButton){
                frame.dispose();
                new LoginPage();
            }
        });



        //Setting up Login Button
        signUpButton.setBounds(275,420,250,30);
        signUpButton.setFocusable(false);
        signUpButton.setBackground(new Color(112,191,255,255));



        signUpButton.addActionListener(e ->{
            Conn jdbc = new Conn();
            try {
                String email = emailFeild.getText();
                String uname= usernameFeild.getText();
                String pass = String.valueOf(passwordField.getPassword());
                String confirmpass = String.valueOf(passwordField2.getPassword());
                if (jdbc.search(email)){
                    JOptionPane.showMessageDialog(panel, "Account already exixt", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(confirmpass.equals(pass)){
                        jdbc.insert(uname, email, pass);
                        System.out.println("Account created...!");
                    }else{
                        JOptionPane.showMessageDialog(panel, "Password does not Match", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } catch (Exception ex) {
                Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(e.getSource().equals(signUpButton))
            {
                frame.dispose();
                new LoginPage();
            }


        });


        //Adding everyThing in panel
        panel.setLayout(null);
        panel.add(signupLabel);
        panel.add(usernameLabel);
        panel.add(emailLabel);
        panel.add(passwordLabel);
        panel.add(usernameFeild);
        panel.add(emailFeild);
        panel.add(passwordField);
        panel.add(CpasswordLabel);
        panel.add(passwordField2);
        panel.add(signUpButton);
        panel.add(backButton);
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

