import java.util.ArrayList;

public class Feed implements Observer, Observable {

    private ArrayList<String> messages;
    private ArrayList<Observer> observerList = new ArrayList<>();

    public Feed() {
        this.messages = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        messages.add(message);
        // notifyFollowers();
    }

    
    public ArrayList<String> getTweets() {
        return messages;
    }

    public int countTweets() {
        return messages.size();
    }

    
    public int countPositiveTweets() {
        int posTweets = 0;
        String[] posWords = {"good", "great", "nice", "happy"};
        for (String message : messages) {
            for (String posWord : posWords) {
            if (message.contains(posWord)) {
                posTweets++;
                break; 
                }
            }
        }
        return posTweets;
    }

    @Override
    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyFollowers(String message) {
        for (Observer follower : observerList) {
            follower.update(message);
        }
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
    }
}
    
