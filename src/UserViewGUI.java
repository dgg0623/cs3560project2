import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

public class UserViewGUI {
    private JFrame frame;
    private JTextArea feedTextArea;
    private JTextField tweetTextField;
    private JButton btnFollow;
    private JList<String> followersList;
    private List<String> followers;

    public UserViewGUI(String userName) {
        initialize(userName);
    }

    private void initialize(String userName) {
        frame = new JFrame(userName + "'s User View");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

    
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weighty = 2.0;
        feedTextArea = new JTextArea();
        feedTextArea.setBorder(BorderFactory.createTitledBorder("Live Feed:"));
        panel.add(new JScrollPane(feedTextArea), gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weighty = 0.5;
        tweetTextField = new JTextField();
        tweetTextField.setBorder(BorderFactory.createTitledBorder("Tweet message here:"));
        tweetTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tweetTextField.getText().equals("Tweet message here:")) {
                    tweetTextField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tweetTextField.getText().isEmpty()) {
                    tweetTextField.setText("Tweet message here");
                }
            }
        });
        panel.add(tweetTextField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.0;
        btnFollow = new JButton("Follow");
        btnFollow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                followUser(userName);
            }
        });
        panel.add(btnFollow, gbc);

        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        followers = new ArrayList<>();
        followersList = new JList<>(followers.toArray(new String[0]));
        followersList.setBorder(BorderFactory.createTitledBorder("Followers"));
        JScrollPane followersScrollPane = new JScrollPane(followersList);
        panel.add(followersScrollPane, gbc);

    
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        JButton btnPostTweet = new JButton("Post Tweet");
        btnPostTweet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                postTweet(userName);
            }
        });
        panel.add(btnPostTweet, gbc);

        frame.setVisible(true);
    }

    private void followUser(String userName) {
        followers.add(userName);  
        updateFollowersList();
    }

    private void postTweet(String userName) {
        String tweet = tweetTextField.getText().trim();
        if (!tweet.isEmpty() && !tweet.equals("Tweet message here")) {
        
            feedTextArea.append(userName + ": " + tweet + "\n");
            tweetTextField.setText("Tweet message here");
        }
    }

    private void updateFollowersList() {
        followersList.setListData(followers.toArray(new String[0]));
    }
}
