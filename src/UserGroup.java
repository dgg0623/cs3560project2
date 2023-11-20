/* 
import java.util.ArrayList;
import java.util.List;

public class UserGroup extends Entity {
    private String groupName;
    private List<UserGroup> subgroups;
    private List<userName> members;

    public UserGroup(String id, String groupName) {
        super(id);
        this.groupName = groupName;
        this.subgroups = new ArrayList<>();
        this.members = new ArrayList<>();
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
