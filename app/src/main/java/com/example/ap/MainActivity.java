package com.example.ap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get beijing time by using id China/Beijing
        Calendar bjTime = Calendar.getInstance();
        bjTime.setTimeZone(TimeZone.getTimeZone("China/Beijing"));

        // convert to standard time by UTC plus 8
        int actualBJHour = bjTime.get(Calendar.HOUR_OF_DAY)+8;
        int actualBJMinute = bjTime.get(Calendar.MINUTE);
        String bjT = "";
        String bjM = "";

        bjT = checkTime(actualBJHour,actualBJMinute,bjM,bjT,bjTime);
        // target to text view and set its text to the time
        TextView tv1 = findViewById(R.id.tV1);
        tv1.setText(bjT);



        // get tokyo time by using id Japan/Tokyo
        Calendar toyTime = Calendar.getInstance();
        toyTime.setTimeZone(TimeZone.getTimeZone("Japan/Tokyo"));

        // convert to standard time by UTC plus 9
        int actualTOYHour = toyTime.get(Calendar.HOUR_OF_DAY)+9;
        int actualTOYMinute = toyTime.get(Calendar.MINUTE);
        String toyT = "";
        String toyM = "";

        toyT = checkTime(actualTOYHour,actualTOYMinute,toyM,toyT,toyTime);

        TextView tv2 = findViewById(R.id.tV2);
        tv2.setText(toyT);




        // get london time by using id England/London
        Calendar lonTime = Calendar.getInstance();
        lonTime.setTimeZone(TimeZone.getTimeZone("England/London"));

        // convert to standard time by UTC plus 1
        int actualLonHour = lonTime.get(Calendar.HOUR_OF_DAY)+1;
        int actualLonMinute = lonTime.get(Calendar.MINUTE);
        String lonT = "";
        String lonM = "";

        lonT = checkTime(actualLonHour,actualLonMinute,lonM,lonT,lonTime);
        // target to text view and set its text to the time
        TextView tv3 = findViewById(R.id.tV3);
        tv3.setText(lonT);



        // get paris time by using id France/Paris
        Calendar prTime = Calendar.getInstance();
        prTime.setTimeZone(TimeZone.getTimeZone("France/Paris"));

        // convert to standard time by UTC plus 2
        int actualPrHour = prTime.get(Calendar.HOUR_OF_DAY)+2;
        int actualPrMinute = prTime.get(Calendar.MINUTE);
        String prT = "";
        String prM = "";

        prT = checkTime(actualPrHour,actualPrMinute,prM,prT,prTime);
        // target to text view and set its text to the time
        TextView tv4 = findViewById(R.id.tV4);
        tv4.setText(prT);



        // get new york time by using id America/New_York
        Calendar nyTime = Calendar.getInstance();
        nyTime.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        // convert to standard time
        int actualNyHour = nyTime.get(Calendar.HOUR_OF_DAY);
        int actualNyMinute = nyTime.get(Calendar.MINUTE);
        String nyT = "";
        String nyM = "";

        nyT = checkTime(actualNyHour,actualNyMinute,nyM,nyT,nyTime);
        // target to text view and set its text to the time
        TextView tv5 = findViewById(R.id.tV5);
        tv5.setText(nyT);

    }

    public String checkTime(int actualHour, int actualMinute, String M, String T, Calendar Time){
        // check if the actual time exceeds 12pm
        if (actualHour>12){
            // when actual hour > 24
            if (actualHour>24){
                actualHour = actualHour - 24;
                // check the minutes, format it
                if (actualMinute<10){
                    M = M+"0"+actualMinute;
                    T = T+actualHour+":"+M+" am";
                    return T;
                }
                else{
                    T = T+actualHour+":"+Time.get(Calendar.MINUTE)+" am";
                    return T;
                }
            }
            // when actual hour is 24
            else if(actualHour == 24){
                actualHour = 0;
                // check the minutes, format it
                if (actualMinute<10){
                    M = M+"0"+actualMinute;
                    T = T+actualHour+":"+M+" am";
                    return T;
                }
                else{
                    T = T+actualHour+":"+Time.get(Calendar.MINUTE)+" am";
                    return T;
                }
            }
            // when actual hour < 24
            else{
                actualHour = actualHour - 12;
                // check the minutes, format it
                if (actualMinute<10){
                    M = M+"0"+actualMinute;
                    T = T+actualHour+":"+M+" pm";
                    return T;
                }
                else{
                    T = T+actualHour+":"+Time.get(Calendar.MINUTE)+" pm";
                    return T;
                }
            }

        }
        // when actual hour is 12
        else if(actualHour == 12){
            if (actualMinute<10){
                M = M+"0"+actualMinute;
                T = T+actualHour+":"+M+" pm";
                return T;
            }
            else{
                T = T+actualHour+":"+Time.get(Calendar.MINUTE)+" pm";
                return T;
            }
        }
        else{
            if (actualMinute<10){
                M = M+"0"+actualMinute;
                T = T+actualHour+":"+M+" am";
                return T;
            }
            else{
                T = T+actualHour+":"+Time.get(Calendar.MINUTE)+" am";
                return T;
            }
        }

    }

    public void onClick12Hours(View view){
        // for display time on 12 hours mode
        TextView tv1 = findViewById(R.id.tV1);
        TextView tv2 = findViewById(R.id.tV2);
        TextView tv3 = findViewById(R.id.tV3);
        TextView tv4 = findViewById(R.id.tV4);
        TextView tv5 = findViewById(R.id.tV5);

        String time;
        time = displayTime12(tv1);
        tv1.setText(time);

        time = displayTime12(tv2);
        tv2.setText(time);

        time = displayTime12(tv3);
        tv3.setText(time);

        time = displayTime12(tv4);
        tv4.setText(time);

        time = displayTime12(tv5);
        tv5.setText(time);

    }

    public String displayTime12(TextView tv){
        String time = tv.getText().toString();
        String hour = "";
        String minute = "";

        int actualHour;

        // only the time with pm needs to be converted
        if (time.substring(time.length()-2).equals("pm")){
            // go through each char
            for (int i = 0;i<time.length();i++){
                // get hour
                if (!time.substring(i,i+1).equals(":")){
                    hour = hour + time.substring(i,i+1);
                }
                else{
                    // get minute
                    minute=minute+time.substring(i);
                    break;

                }
            }
            // parse to int
            actualHour = Integer.parseInt(hour);
            if (actualHour==12){
                return time;
            }
            else{
                if (actualHour<12){
                    return time;
                }
                else{
                    // convert to 12 hours
                    actualHour = actualHour -12;
                    hour = actualHour+minute;
                    return hour;
                }
            }

        }
        else{
            return time;
        }
    }

    public void onClick24Hours(View view){
        TextView tv1 = findViewById(R.id.tV1);
        TextView tv2 = findViewById(R.id.tV2);
        TextView tv3 = findViewById(R.id.tV3);
        TextView tv4 = findViewById(R.id.tV4);
        TextView tv5 = findViewById(R.id.tV5);

        String time;
        time = displayTime24(tv1);
        tv1.setText(time);

        time = displayTime24(tv2);
        tv2.setText(time);

        time = displayTime24(tv3);
        tv3.setText(time);

        time = displayTime24(tv4);
        tv4.setText(time);

        time = displayTime24(tv5);
        tv5.setText(time);


    }

    public String displayTime24(TextView tv){

        String time = tv.getText().toString();
        String hour = "";
        String minute = "";

        int actualHour;

        // only the time with pm needs to be converted
        if (time.substring(time.length()-2).equals("pm")){
            // go through each char
            for (int i = 0;i<time.length();i++){
                // get hour
                if (!time.substring(i,i+1).equals(":")){
                    hour = hour + time.substring(i,i+1);
                }
                else{
                    // get minute
                    minute=minute+time.substring(i);
                    break;

                }
            }
            // parse to int
            actualHour = Integer.parseInt(hour);
            if (actualHour==12){
                return time;
            }
            else{
                if (actualHour>12){
                    return time;
                }
                else{
                    // convert to 24 hours
                    actualHour = actualHour +12;
                    hour = actualHour+minute;
                    return hour;
                }
            }

        }
        else{
            return time;
        }

    }



}
