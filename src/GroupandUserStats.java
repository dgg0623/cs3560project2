 /* 
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class GroupandUserStats implements Observer {
    private int totalUsers;
    private int totalGroups;

    public GroupandUserStats() {
        this.totalUsers = 0;
        this.totalGroups = 0;
    }

    public void displayGroupStats() {
        String countMessage = "Total Groups: " + totalGroups;
        JOptionPane.showMessageDialog(null, countMessage, "Count Groups", JOptionPane.INFORMATION_MESSAGE);
    }
    public void displayUserStats() {
        String countMessage = "Total Users: " + totalUsers;
        JOptionPane.showMessageDialog(null, countMessage, "Count Users", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void update(message) {
        countUsersAndGroups();
    }

    private void countUsersAndGroups() {
        totalUsers = 0;
        totalGroups = 0;
        traverseTree(AdminControlPanelGUI.getInstance().getRootNode());
        displayGroupStats();
        displayUserStats();
    }

    private void traverseTree(DefaultMutableTreeNode parentNode) {
        for (int i = 0; i < parentNode.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) parentNode.getChildAt(i);
            if (node.getUserObject() instanceof UserName) {
                totalUsers++;
            } else if (node.getUserObject() instanceof UserGroup) {
                totalGroups++;
                traverseTree(node); 
            }
        }
    }

    @Override
    public void update(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
*/