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

    public TweetList() {

    }

    public void add(Tweet tweet) {
        if(tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        }
        else {tweets.add(tweet);}
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }


    public ArrayList<Tweet> getTweets() {
        // ArrayList<Tweet> returnTweetList = new ArrayList<Tweet>();
        // returnTweetList = tweets.clone();

        // sorting from here:
        // http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.getDate().compareTo(t2.getDate());
                //return t2.getDate().compareTo(t1.getDate());
            }
        });

        return tweets;
    }


    public int getCount() {
        return tweets.size();
    }
}
