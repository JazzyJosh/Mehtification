package net.speakerdocks.mehtification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DealInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_info);
        startService(new Intent(this, RetrieveDealService.class));
    }
}
