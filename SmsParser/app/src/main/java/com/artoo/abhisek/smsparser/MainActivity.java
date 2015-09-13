package com.artoo.abhisek.smsparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pattern money = Pattern.compile("(([Ii][Nn][Rr])|([Rr][Ss]))\\s*[\\d\\.,]*\\d+");
        Pattern accountNumber = Pattern.compile("[A-Z]+\\d{4}");

        final TextView regex = (TextView) findViewById(R.id.editText2);
        final TextView data = (TextView) findViewById(R.id.textView3);
        final TextView result = (TextView) findViewById(R.id.textView2);
        Button button = (Button) findViewById(R.id.button);
        Button btntext1 = (Button) findViewById(R.id.button2);
        Button btntext2 = (Button) findViewById(R.id.button3);
        Button btntext3 = (Button) findViewById(R.id.button4);
        Button btntext4 = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern pattern = Pattern.compile(regex.getText().toString());
                Matcher matcher = pattern.matcher(data.getText());

                StringBuilder sb = new StringBuilder();

                while (matcher.find()) {
                    sb.append("Start: ");
                    sb.append(matcher.start());
                    sb.append(" End: ");
                    sb.append(matcher.end());
                    sb.append("\n");
                    sb.append(matcher.group());
                    sb.append("\n");
                }

                result.setText(sb.toString());
            }
        });

        btntext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText("Dear Customer, your Account Number XXXXXX6377 has been credited " +
                        "by Rs 215.000 being DBT/DBTL funds transfer on 19/05/2015 - " +
                        "CENTRAL BANK OF INDIA");
            }
        });

        btntext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText("A/c NN5715 debited for Rs 2000; ATM WDL. A/c Bal(sub to " +
                        "chq realisatn) Rs13286.23 on 24APR 21:19hr. Call 1800226999 to block " +
                        "your card if not used by you.");
            }
        });

        btntext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText("Dear Customer, Your Ac XXXXXXXX5666 is credited with INR8,922.00 " +
                        "on 16 Feb. Info. INF*000080483346*SALARY. Your Net Available Bal is " +
                        "INR 8,922.00.");
            }
        });

        btntext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText("Dear Customer, Your Ac XXXXXXXX5666 is credited with INR18,922.00 " +
                        "on 16 Feb. Info. INF*000080483346*SALARY. Your Net Available Bal is " +
                        "INR 1,38,922.00.");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
