package ardier.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ConvertNumbers(View v) {
        try {
            Converter conv = new Converter();
            RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);
            RadioButton rb8 = (RadioButton) findViewById(R.id.rb8);
            RadioButton rb16 = (RadioButton) findViewById(R.id.rb16);

            TextView text2 = (TextView) findViewById(R.id.text2);
            TextView text8 = (TextView) findViewById(R.id.text8);
            TextView text10 = (TextView) findViewById(R.id.text10);
            TextView text16 = (TextView) findViewById(R.id.text16);
            EditText edit1 = (EditText) findViewById(R.id.edit1);


            int i = 10;

            if (rb2.isChecked())
                i = 2;
            else if (rb8.isChecked())
                i = 8;
            else if (rb16.isChecked())
                i = 16;

            String dec = conv.ConvertToDec(edit1.getText().toString(), i);

            text2.setText("2: " + conv.ConvertFromDec(dec, 2));
            text8.setText("8: " + conv.ConvertFromDec(dec, 8));
            text10.setText("10: " + conv.ConvertFromDec(dec, 10));
            text16.setText("16: " + conv.ConvertFromDec(dec, 16));


        }
        catch (Exception e) {
            ((TextView) findViewById(R.id.text2)).setText(e.getMessage().toString());
        }

    }
}
