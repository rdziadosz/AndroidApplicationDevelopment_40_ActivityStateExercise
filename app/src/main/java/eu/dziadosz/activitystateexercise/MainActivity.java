package eu.dziadosz.activitystateexercise;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        TextEntryDialogFragment.TextEntryDialogListener {
    private final String TEXTVIEW_STATEKEY = "TEXTVIEW_STATEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Comment below to test
        TextView textView = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(TEXTVIEW_STATEKEY)) {
                String text = savedInstanceState.getString(TEXTVIEW_STATEKEY);
                textView.setText(text);
            }
        }
    }

    public void buttonClicked(View view) {
        TextEntryDialogFragment textentryDialogFragment = new TextEntryDialogFragment();
        textentryDialogFragment.show(getFragmentManager(), "Input text");
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        // Toast.makeText(getBaseContext(), "onSaveInstanceState",Toast.LENGTH_SHORT).show();
        // get text view
        TextView textView = (TextView) findViewById(R.id.textView);
        // save text view state
        saveInstanceState.putString(TEXTVIEW_STATEKEY, textView.getText().toString());
    }
    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), "Cancel",
                Toast.LENGTH_SHORT).show();
    }
}