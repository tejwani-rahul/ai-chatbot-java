//interface or area where we are going to ask questions from bot

package Bot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static Bot.ChatGPT.chatGPTResponse;


public class ChatInterface extends JFrame {
    JFrame frame;
    JPanel sidePanel;
    JButton searchButton;
    JTextField textField;
    JTextArea textArea;
    JScrollPane scrollPane;


    ImageIcon header = new ImageIcon("src\\Bot\\icons\\30.png");

    public ChatInterface(String emailID) {

        frame = new JFrame();
        textField = new JTextField();
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        //Setting up ScrollPane in TextArea
        scrollPane.setBounds(150, 2, 635, 526);
        scrollPane.setFocusable(false);
        scrollPane.setBackground(new Color(32,33,35,255));

        //Setting up TextArea
        textArea.setBackground(new Color(68,70,84,255));
        textArea.setBorder(BorderFactory.createLineBorder(new Color(68,70,84,255)));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(5,10,10,5));

        //Setting up TextFeild
        textField.setBounds(152, 530, 545, 30);
        textField.setBackground(new Color(32,33,35,255));
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(new Color(68,70,84,255)));
        textField.setCaretColor(Color.WHITE);




        //Setting up Search Buttion
     //   Searchicon = new ImageIcon("src\\Bot\\icons\\icon3.png");
        searchButton = new JButton("Search");
        searchButton.setBounds(700, 530, 85, 30);
        searchButton.setFocusable(false);
        searchButton.setBackground(new Color(32,33,35,255));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(BorderFactory.createLineBorder(new Color(68,70,84,255)));

        // Action Listener for search button
        searchButton.addActionListener(e -> {

            String input = textField.getText();
            textArea.setForeground(Color.white);

            if (input.equals("")) {
                textField.setText(null);
            }
            else if (e.getSource().equals(searchButton))
            {
                textArea.setText(textArea.getText() + "\nYou ->  " + input + "\n");
                textField.setText("");

                try {
                    String response = chatGPTResponse(input);
                    textArea.setText(textArea.getText() + "\nGPT ->  " + (response) + "\n");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            else{
                textArea.setText("there was some problem");
            }
        });



        //SidePanel
        sidePanel = new JPanel();
        sidePanel.setBounds(2,2,147,558);
        sidePanel.setBackground(new Color(32,33,35,255));
        sidePanel.setBorder(BorderFactory.createLineBorder(new Color(32,33,35,255)));

        ImageIcon sideIcon = new ImageIcon("src\\Bot\\icons\\icon image.png");
        Image img = sideIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setBounds(7,2,40,40);

        JLabel chatbot_Label = new JLabel("Chatbot");
        chatbot_Label.setBounds(57,5,100,40);
        chatbot_Label.setFont(new Font("Times New Roman",Font.PLAIN,22));
        chatbot_Label.setForeground(Color.WHITE);

        // Username Label and profile photo
        ImageIcon profileIcon = new ImageIcon("src\\Bot\\icons\\profile.png");
        JLabel profileLabel = new JLabel(profileIcon);
        profileLabel.setBounds(5,80,25,25);

        JLabel username = new JLabel(emailID);
        username.setBounds(40,80,106,30);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Bodoni MT",Font.PLAIN,14));

        //setting up Button for clear chat
        JButton clearchat = new JButton("Clearchat");
        clearchat.setBounds(4,130,139,30);
        clearchat.setFocusable(false);
        clearchat.setBackground(new Color(32,33,35,255));
        clearchat.setForeground(Color.WHITE);
        clearchat.setBorder(BorderFactory.createLineBorder(new Color(68,70,84,255)));

        //setting up Button for Logout
        JButton logout = new JButton("Logout");
        logout.setBounds(4,170,139,30);
        logout.setFocusable(false);
        logout.setBackground(new Color(32,33,35,255));
        logout.setForeground(Color.WHITE);
        logout.setBorder(BorderFactory.createLineBorder(new Color(68,70,84,255)));


        //ActionListener for Clearchat Button
        clearchat.addActionListener(e -> {
            textArea.setText("");
            textField.setText("");  });

        //ActionListener for Logout Button
        logout.addActionListener(e -> {
            frame.dispose();
            new LoginPage();  });

        //Lible for my credit
        JLabel intro = new JLabel("Made by : Rahul Tejwani");
        intro.setForeground(Color.WHITE);
        intro.setFont(new Font(null,Font.PLAIN,10));
        intro.setBounds(35,545,120,11);


       
        //Putting everything in panel
        sidePanel.setLayout(null);
        sidePanel.add(iconLabel);
        sidePanel.add(chatbot_Label);
        sidePanel.add(username);
        sidePanel.add(profileLabel);
        sidePanel.add(clearchat);
        sidePanel.add(logout);
        sidePanel.add(intro);






        //adding Every thing in Frame
        frame.add(sidePanel);
        frame.add(scrollPane);
        frame.add(textField);
        frame.add(searchButton);


        //setting up the Frame
        frame.setSize(803, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("ChatBot");
        //frame.setResizable(false);
        frame.setIconImage(header.getImage());
        frame.getRootPane().setBackground(Color.BLACK);
        frame.getContentPane().setBackground(new Color(68,70,84,255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
