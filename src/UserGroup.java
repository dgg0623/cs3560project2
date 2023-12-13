/* 
import java.util.ArrayList;
import java.util.List;

public class UserGroup extends Entity {
    private String groupName;
    private List<UserGroup> subgroups;
    private List<userName> members;
    private long creationTime;



    
    public UserGroup(String id, String groupName) {
        super(id);
        this.groupName = groupName;
        this.subgroups = new ArrayList<>();
        this.members = new ArrayList<>();
        this.creationTime = System.currentTimeMillis()
    }
    public String getGroupName() {
        return groupName;
    }
    public List<UserGroup> getSubgroups() {
        return subgroups;
    }
    public List<userName> getMembers() {
        return members;
    }
    public void addUser(userName user) {
        members.add(user);
    }
    public void addSubgroup(UserGroup subgroup) {
        subgroups.add(subgroup);
    }
}
*/
