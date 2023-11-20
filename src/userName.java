/* 
import java.util.ArrayList;
import java.util.List;

public class userName extends Entity {

    public UserName(String id, String UserName) {
        super(id);
    }

    private String userName;
    private List<userName> followers;
    private List<userName> following;
    private List<String> tweets;

    public userName(String userName) {
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.tweets = new ArrayList<>();
    }
    public String getUserName() {
        return userName;
    }
    public List<userName> getFollowers() {
        return followers;
    }
    public List<userName> getFollowing() {
        return following;
    }
    public List<String> getTweets() {
        return tweets;
    }

    public void addFollower(userName follower) {
        followers.add(follower);
    }

    public void addFollowing(userName followee) {
        following.add(followee);
    }

    public void postTweet(String tweet) {
        tweets.add(tweet);
    }
}
*/