import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminControlPanelGUI {
    private static AdminControlPanelGUI instance;

    private JFrame frame;
    private JTextField userIdTextField;
    private JTextField groupIdTextField;
    private JTextArea textArea;
    private JTree tree;
    private DefaultMutableTreeNode root;
    
    
    //private GroupandUserStats groupandUserStats;

    //public AdminControlPanelGUI() {
      //  this.root = new DefaultMutableTreeNode("Root");
     //   this.groupandUserStats = new GroupandUserStats();
   //     addObserverToTree();
    

  //  private void addObserverToTree() {
   //     if (root instanceof Observable) {
  //          ((Observable) root).attach(groupandUserStats);
   //     }
 //   }

    public DefaultMutableTreeNode getRootNode() {
        return root;
    }

    public static AdminControlPanelGUI getInstance() {
        if (instance == null) {
            instance = new AdminControlPanelGUI();
        }
        return instance;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            getInstance().initialize();
        });
    }

    private void initialize() {
        frame = new JFrame("Admin Control Panel");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel leftPanel = new JPanel();
        frame.getContentPane().add(leftPanel, BorderLayout.WEST);

        root = new DefaultMutableTreeNode("Root");
        tree = new JTree(root);
        leftPanel.add(new JScrollPane(tree));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        frame.getContentPane().add(rightPanel, BorderLayout.EAST);

        userIdTextField = new JTextField();
        addComponent(rightPanel, new JLabel("User ID:"), 0, 0, GridBagConstraints.EAST);
        addComponent(rightPanel, userIdTextField, 1, 0, GridBagConstraints.WEST);

        JButton btnAddUser = new JButton("Add User");
        addComponent(rightPanel, btnAddUser, 2, 0, GridBagConstraints.CENTER);

        groupIdTextField = new JTextField();
        addComponent(rightPanel, new JLabel("Group ID:"), 0, 1, GridBagConstraints.EAST);
        addComponent(rightPanel, groupIdTextField, 1, 1, GridBagConstraints.WEST);

        JButton btnAddGroup = new JButton("Add Group");
        addComponent(rightPanel, btnAddGroup, 2, 1, GridBagConstraints.CENTER);

        JButton btnOpenUserView = new JButton("Open User View");
        addComponent(rightPanel, btnOpenUserView, 0, 2, 3, 1, GridBagConstraints.EAST);
        btnOpenUserView.setPreferredSize(new Dimension(150, btnOpenUserView.getPreferredSize().height));

        JButton btnShowUserTotal = new JButton("Show User Total");
        addComponent(rightPanel, btnShowUserTotal, 0, 3, 1, 1, GridBagConstraints.CENTER);

        JButton btnShowGroupTotal = new JButton("Show Group Total");
        addComponent(rightPanel, btnShowGroupTotal, 1, 3, 1, 1, GridBagConstraints.CENTER);

        JButton btnShowMessagesTotal = new JButton("Show Messages Total");
        addComponent(rightPanel, btnShowMessagesTotal, 2, 3, GridBagConstraints.CENTER);

        JButton btnShowPositivePercentage = new JButton("Show Positive Percentage");
        addComponent(rightPanel, btnShowPositivePercentage, 0, 4, 3, 1, GridBagConstraints.CENTER);

        textArea = new JTextArea();
        addComponent(rightPanel, new JScrollPane(textArea), 0, 4, 3, 1, GridBagConstraints.CENTER);

        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        btnAddGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addGroup();
            }
        });

        btnOpenUserView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUserView();
            }
        });

        frame.setVisible(true);
    }

    private void addComponent(JPanel panel, JComponent component, int gridx, int gridy, int anchor) {
        addComponent(panel, component, gridx, gridy, 1, 1, anchor);
    }

    private void addComponent(JPanel panel, JComponent component, int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.anchor = anchor;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }

    private void addUser() {
        String userName = userIdTextField.getText().trim();
        if (!userName.isEmpty()) {
            DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(userName);
            root.add(userNode);
            refreshTree();
        } else {
            JOptionPane.showMessageDialog(frame, "Enter a valid user ID.");
        }
    }


    private void addGroup() {
        String groupName = groupIdTextField.getText().trim();
        if (!groupName.isEmpty()) {
            DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(groupName);
            root.add(groupNode);
            refreshTree();
        } else {
            JOptionPane.showMessageDialog(frame, "Enter a valid group ID.");
        }
    }

    private void openUserView() {
        TreePath selectedPath = tree.getSelectionPath();
        if (selectedPath != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
            String userName = selectedNode.toString();
            new UserViewGUI(userName);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a user.");
        }
    }

    private void refreshTree() {
        tree.updateUI();
    }

    private void notifyObservers() {
        if (root instanceof Observable) {
            ((Observable) root).notifyObservers();
        }
    }

}
