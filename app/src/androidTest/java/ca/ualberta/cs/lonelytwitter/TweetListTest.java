package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by phillip2 on 9/29/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    /**
     * Instantiates a new Tweet list test.
     */
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Tests adding a tweet to tweetlist.
     */
    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    /**
     * Tests the hasTweet method which checks if the tweetlist contains a
     * specified tweet.
     */
    // tests always have to start with lowercase 'test'
    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * Tests deletion of tweets from the TweetList.
     */
    public void testDelete(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("delet this");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    /**
     * Tests the getTweet method.
     */
    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        Tweet returnTweet = tweets.getTweet(0);
        assertEquals(returnTweet.getMessage(), tweet.getMessage());
    }

    /**
     *  Tests whether the TweetList rejects duplicate tweets.
     */
    public void testDuplicateTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("i am kool");
        try {
            tweets.add(tweet);
            tweets.add(tweet);
            fail("Should throw IllegalArgumentException");
        }
        catch(Exception e) {
        }
    }


    /**
     * Tests the chronological sorting method of TweetList
     */
    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Date date1 = new Date(5668);
        Tweet tweet1 = new NormalTweet("oldest", date1);
        Date date2 = new Date(7777);
        Tweet tweet2 = new NormalTweet("middle", date2);
        Date date3 = new Date(8888);
        Tweet tweet3 = new NormalTweet("newest", date3);
        // not inserted chronologically
        tweets.add(tweet3);
        tweets.add(tweet2);
        tweets.add(tweet1);
        ArrayList<Tweet> getTest = new ArrayList<Tweet>();
        getTest = tweets.getTweets();
        assertEquals(getTest.get(0).getMessage(), "oldest");
    }


    /**
     * Tests the getCount method
     */
    public void testCount() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("1");
        Tweet tweet2 = new NormalTweet("2");
        Tweet tweet3 = new NormalTweet("3");
        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);
        assertEquals(tweets.getCount(), 3);
    }
}
