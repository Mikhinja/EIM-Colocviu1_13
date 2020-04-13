package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    private class ScriePunctCardinalButtonListener implements View.OnClickListener {
        private Colocviu1_13MainActivity parinte = null;

        public ScriePunctCardinalButtonListener(Colocviu1_13MainActivity tata){
            parinte = tata;
        }

        @Override
        public void onClick(View v) {
            if (v != null && textViewLogPuncteCardinale != null) {
                String text = ((Button)v).getText().toString();
                if (!textViewLogPuncteCardinale.getText().toString().isEmpty()) {
                    text = ", " + text;
                }
                textViewLogPuncteCardinale.setText(
                        textViewLogPuncteCardinale.getText() + text);
                parinte.numarPuncteCardinale++;
            }
        }
    }

    private TextView textViewLogPuncteCardinale = null;
    protected int numarPuncteCardinale = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_main);

        textViewLogPuncteCardinale = (TextView)findViewById(R.id.textView2);
        Button buttonPunctCardinal = (Button)findViewById(R.id.button);
        buttonPunctCardinal.setOnClickListener(new ScriePunctCardinalButtonListener(this));

        buttonPunctCardinal = (Button)findViewById(R.id.button2);
        buttonPunctCardinal.setOnClickListener(new ScriePunctCardinalButtonListener(this));

        buttonPunctCardinal = (Button)findViewById(R.id.button3);
        buttonPunctCardinal.setOnClickListener(new ScriePunctCardinalButtonListener(this));

        buttonPunctCardinal = (Button)findViewById(R.id.button4);
        buttonPunctCardinal.setOnClickListener(new ScriePunctCardinalButtonListener(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(Constants.STATE_KEY_NUM_PCT_CARD, numarPuncteCardinale);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            numarPuncteCardinale = savedInstanceState.getInt(Constants.STATE_KEY_NUM_PCT_CARD);
        }
    }
}
