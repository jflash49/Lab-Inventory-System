package com.inventory.lab.compsci.services;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.LoginActivity;
import com.inventory.lab.compsci.activities.MainActivity;
import com.inventory.lab.compsci.models.TestPeriods;
import com.orm.SugarRecord;

import java.util.Calendar;
import java.util.List;

/**
 * Created by peoplesoft on 2/26/2016.
 */
public class TestPeriodService extends IntentService{
    private static final String TAG = "TestPeriodService";
    private static final int NOTIFICATION = 1;
    public static final int CLASS_INTERVAL = 1000 * 60 * 30;
    public boolean tested = false;
    public TestPeriodService (){super(TAG);}
    public TestPeriodService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Received intent:" + intent);
        //prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //malarm = prefs.getBoolean("timetable_notification",true);
       // mvibrate = prefs.getBoolean("vibrate_notification",true);
        PendingIntent pi = PendingIntent
                .getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notification = new Notification.Builder(this)
                    .setTicker(getResources().getText(R.string.to_main))
                    .setSmallIcon(R.drawable.abc_ic_search_api_mtrl_alpha)
                    .setContentTitle(getResources().getText(R.string.to_lab_check))
                    .setContentText(getResources().getText(R.string.to_lab_update))
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .build();
        if(newTestPeriod()==true){
            notificationManager.notify(NOTIFICATION, notification);
            }
        //}
        //vibrator.vibrate(1000);
    }

    protected boolean newTestPeriod(){
        Calendar calendar = Calendar.getInstance();
        boolean result = false;
        if (calendar.get(Calendar.DAY_OF_WEEK)==6) {
            if (tested ==false) {
                TestPeriods testPeriods = new TestPeriods();
                testPeriods.setStartdt(calendar.getTime());
                calendar.add(Calendar.DATE, 1);
                testPeriods.setEnddt(calendar.getTime());
                testPeriods.save();
            }
           result =  true;
        }
        return result;
    }
}
