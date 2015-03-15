package net.speakerdocks.mehtification;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class DealInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_info);
        Log.i(getPackageName() + "." + getLocalClassName(), "User is a monkey:" + ActivityManager.isUserAMonkey());
    }
}
