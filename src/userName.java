/* 
import java.util.ArrayList;
import java.util.List;

public class userName extends Entity {


    private String userName;
    private List<userName> followers;
    private List<userName> following;
    private List<String> tweets;
    private long creationTime

    public userName(String userName) {
        super(id);
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.tweets = new ArrayList<>();
        this.creationTime = System.currentTimeMillis()
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