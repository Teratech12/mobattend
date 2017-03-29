package com.example.sky_phase.mobattend;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReminderActivity extends AppCompatActivity {
   // ReminderDatabase reminderDatabase = new ReminderDatabase(g);
    Button submit;
    TimePicker timePicker;
    DatePicker datePicker;
    NotificationManager notificationManager;
    EditText myedit1;
    EditText myedit2;
    String date;


    int timehour;
    int timeminute;


    int system_day;
    int system_month;
    int system_year;

    int system_hour;
    int system_minute;
    int system_second;

    int user_day;
    int user_month;
    int user_year;

    int user_hour;
    int user_minute;
    int user_second;

    int nofifyID = 33;
    boolean isNotificActive = false;
    ReminderDatabaseOriginal db = new ReminderDatabaseOriginal(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        submit = (Button)findViewById(R.id.submitAns);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        myedit1 = (EditText)findViewById(R.id.editText2);
        myedit2 = (EditText)findViewById(R.id.editText3);
        Calendar now = Calendar.getInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        datePicker.init(now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH),null);

        timePicker.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(now.get(Calendar.MINUTE));



        submit.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                date = new SimpleDateFormat("mm dd,yyyy").format(new Date());
                String remindername = myedit1.getText().toString();
                String reminderdescription = myedit2.getText().toString();
                String date = "correct";

                db.getWritableDatabase();
                boolean isInserted =   db.insertReminder(remindername,reminderdescription, date);
                if(isInserted== true){
                    Toast.makeText(ReminderActivity.this, "inserted", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(ReminderActivity.this, "not inserted", Toast.LENGTH_LONG).show();
                }
                Calendar current = Calendar.getInstance();
                Calendar cal = Calendar.getInstance();
             cal.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth(),timePicker.getCurrentHour(),timePicker.getCurrentMinute(),00);
       Calendar Alarm = cal;
                if (cal.compareTo(current) <=0){
                    Toast.makeText(getApplicationContext(),"Invalid Date/Time",Toast.LENGTH_LONG).show();
                }
                else {  Toast.makeText(getApplicationContext(),"Reminder is set to " + cal.getTime(),Toast.LENGTH_LONG).show();

                    setAlarm(cal);}




                user_day = datePicker.getDayOfMonth();
                user_month = datePicker.getMonth() +1;
                user_year = datePicker.getYear();
                system_hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                system_minute = Calendar.getInstance().get(Calendar.MINUTE);
                system_day =Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                system_month = Calendar.getInstance().get(Calendar.MONTH)+1;
                system_year = Calendar.getInstance().get(Calendar.YEAR);
                user_hour = timePicker.getCurrentHour();
                user_minute = timePicker.getCurrentMinute();
               // myedit1.setText(Integer.toString(user_day)+""+ Integer.toString(user_month)+""+ Integer.toString(user_year)+"   "+Integer.toString(system_day)+""+Integer.toString(system_month)+""+Integer.toString(system_year));
               // myedit2.setText(Integer.toString(user_hour)+""+Integer.toString(user_minute)+"      "+ Integer.toString(system_hour)+""+Integer.toString(system_minute));
                 //ed.setText(Integer.toString(x));
          /*  if (system_day==user_day && system_month==user_month && system_year==user_year && system_hour==user_hour && system_minute==user_minute){

                NotificationCompat.Builder notificatinonBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(getBaseContext()).setContentTitle("Mobattend").
                        setContentText("New message").
                        setTicker("Alert New Message").
                        setSmallIcon(R.drawable.user);
                Intent intent = new Intent(getBaseContext(),ReminderActivity.class);
                TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getBaseContext());
                taskStackBuilder.addParentStack(MainActivity.class);
                taskStackBuilder.addNextIntent(intent);

                PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                notificatinonBuilder.setContentIntent(pendingIntent);

                notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(nofifyID, notificatinonBuilder.build());
                isNotificActive = true;

                final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.arise);
                mediaPlayer.start();

                Vibrator vibrator = (Vibrator)getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(2000);// vibrate for 2 seconds

            }*/

                /*
                NotificationCompat.Builder notificatinonBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(getBaseContext()).setContentTitle("Mobattend").
                        setContentText("New message").
                        setTicker("Alert New Message").
                        setSmallIcon(R.drawable.user);
                Intent intent = new Intent(getBaseContext(),ReminderActivity.class);
                TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getBaseContext());
                taskStackBuilder.addParentStack(MainActivity.class);
                taskStackBuilder.addNextIntent(intent);

                PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                notificatinonBuilder.setContentIntent(pendingIntent);

                notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(nofifyID, notificatinonBuilder.build());
                isNotificActive = true;

                final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.arise);
                mediaPlayer.start();

                Vibrator vibrator = (Vibrator)getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(2000);// vibrate for 2 seconds


                /* timehour = timePicker.getHour();
                 timeminute = timePicker.getMinute();
                 day = datePicker.getDayOfMonth();
                 month = datePicker.getMonth();
                 year = datePicker.getYear();*/


            }

        });
         system_hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
         system_minute = Calendar.getInstance().get(Calendar.MINUTE);
         system_second = Calendar.getInstance().get(Calendar.SECOND);


     /*      if(timehour == system_hour){
               NotificationCompat.Builder notificatinonBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this).setContentTitle("Mobattend").
                       setContentText("Mobattend  ").
                       setTicker("Mobattend Reminder").
                       setSmallIcon(R.drawable.user);
               Intent intent = new Intent(this,ReminderActivity.class);
               TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
               taskStackBuilder.addParentStack(MainActivity.class);
               taskStackBuilder.addNextIntent(intent);

               PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
               notificatinonBuilder.setContentIntent(pendingIntent);

               notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
               notificationManager.notify(nofifyID, notificatinonBuilder.build());
               isNotificActive = true;

               final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.arise);
               mediaPlayer.start();

               Vibrator vibrator = (Vibrator)getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
               vibrator.vibrate(2000);// vibrate for 2 seconds



           }*/








    }

    private  void setAlarm(Calendar targetCal){

        Intent intent = new Intent(getBaseContext(),AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 1,intent,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),pendingIntent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final Context context = this;
        // Inflate the menu; this adds items to the action bar if it is present.







        return true;
    }


    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }
}
