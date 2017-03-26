package com.example.sky_phase.mobattend;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by SKY-PHASE on 2/26/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm Received",Toast.LENGTH_LONG).show();
        CreateNotification(context,"Mobattend","Time is up","ALERT");

    }

    public  void CreateNotification(Context context, String msg, String msgText, String msgAlert){
        PendingIntent notificIntent = PendingIntent.getActivity(context,0,
                new Intent(context,ReminderActivity.class),0);

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.user)
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setContentText(msgText);

                  mBuilder.setContentIntent(notificIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
       mNotificationManager.notify(1,mBuilder.build());
    }
}
