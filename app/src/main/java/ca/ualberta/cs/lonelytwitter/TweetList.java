package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by phillip2 on 9/29/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Instantiates a new Tweet list.
     */
    public TweetList() {
    }

    /**
     * Adds a tweet to the TweetList
     *
     * @param tweet the tweet to add
     */
    public void add(Tweet tweet) {
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }
        else {tweets.add(tweet);}
    }

    /**
     * Returns whether the TweetList contains the input tweet or not
     *
     * @param tweet the tweet to check if is in TweetList
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Deletes the inputted tweet from the TweetList
     *
     * @param tweet the tweet
     */
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Returns the tweet at the inputted index
     *
     * @param index the index
     * @return the tweet
     */
    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    /**
     * Gets the TweetList sorted chronologically
     *
     * @return chronologically sorted TweetList
     */
    public ArrayList<Tweet> getTweets() {
        // sorting from here:
        // http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
            }
        });
        return tweets;
    }

    /**
     * Returns the size of the TweetList
     *
     * @return TweeList size
     */
    public int getCount() {
        return tweets.size();
    }
}
