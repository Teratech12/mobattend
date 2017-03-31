package com.example.sky_phase.mobattend;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    TextView help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      SpannableStringBuilder builder = new SpannableStringBuilder();
        String add = "ADD NEW CLASS";

        String manually = "INSERT MANUALLY";
        String students = "ADDING STUDENSTS";
        String attendance = "TAKING ATTENDANCE";
        String reminding = "SETTING A REMINDER";

        String text =  " <u><b><font color =#020202>ADD MANUALLY</></b></u> <br /> <br /> Add a new class by choosing the add new class image in the toolbar. Choose whether to <u>insert class manually</u> or to export from your phone.<br /> <br />" +
                "<br /> <u><b><font color =#020202>INSERT MANUALLY</></b></u><br /> <br /> First provide the name of class and class id respectively, and choose add students to add student(s) to " +
                "the class<br /> <br /> <br /> <u><b><font color =#020202>ADDING STUDENTS</></b></u><br /> Provide the name of student and id of student. Choose submit and add another student to add another " +
                "student to that same class. You can add as many students as you wish. Choose submit and finish if you img src = <img src=\\\"%s\\\"/>\" are done adding students<br /> <br /> <br />" +
                "<u><b><font color =#020202>TAKING ATTENDANCE</></b></u><br /> <br />The class tab contains all the names of the classes. Choose the class you want to take attendance. Select the week and Day " +
                "from the pop up and choose take attendance. You will be given all the names of the students in that class. Pick red radiobutton when student is present" +
                ", blue when student is absent with permission and red when student is absent. <br /> <br /> <br />" +
                "<u><b><font color =#020202>SETTING A REMINDER</></b></u><br />Inside the reminder tab choose new reminder. Also available in the menu";

        setContentView(R.layout.activity_help);
        final String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"\\\\userplus.jpg";

        SpannableString blackspannable = new SpannableString(add);
        blackspannable.setSpan(new ForegroundColorSpan(Color.RED),0, add.length(), 0);
        final SpannableStringBuilder sb = new SpannableStringBuilder(text);
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLACK);
        final StyleSpan bss = new StyleSpan(Typeface.BOLD);
        sb.setSpan(bss, 1,10 ,SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
        help = (TextView)findViewById(R.id.helptext);
        help.setText(Html.fromHtml(text));
        help = (TextView)findViewById(R.id.helptext);



    }

}
