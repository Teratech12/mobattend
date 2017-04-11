package com.example.sky_phase.mobattend;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by SKY-PHASE on 2/26/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    ReminderFragment theclass = new ReminderFragment();


    @Override
    public void onReceive(Context context, Intent intent) {

        ReminderDatabaseOriginal db = new ReminderDatabaseOriginal(context);
        Cursor datareminder = db.getReminder();
        if (datareminder.getCount() == 0){

        }

        else{
            datareminder.moveToLast();



        }
        Toast.makeText(context,"Mobattend Reminder",Toast.LENGTH_LONG).show();
        CreateNotification(context,"Mobattend",datareminder.getString(1),"Mobattend Reminder");
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.remindersound);
        mediaPlayer.start();

        Vibrator vibrator = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);// vibrate for 2 seconds

    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public  void CreateNotification(Context context, String msg, String msgText, String msgAlert){
        PendingIntent notificIntent = PendingIntent.getActivity(context,0,
                new Intent(context,ReminderFragment.class),0);

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setPriority(Notification.PRIORITY_HIGH)

                .setDefaults(Notification.DEFAULT_ALL)
                .setContentText(msgText);

                  mBuilder.setContentIntent(notificIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
       mNotificationManager.notify(1,mBuilder.build());


    }
}
