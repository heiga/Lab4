package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void setUp() throws Exception {
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testTweet() {
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));
    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clearEditText((EditText) solo.getView(R.id.body));

        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),
                "I recommend Mcdonalds for when you are sick");
        solo.clickOnButton("Save");

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong Activity!", EditTweetActivity.class);
        assertTrue(solo.waitForText(
                "I recommend Mcdonalds for when you are sick"));

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity!",
                LonelyTwitterActivity.class);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}