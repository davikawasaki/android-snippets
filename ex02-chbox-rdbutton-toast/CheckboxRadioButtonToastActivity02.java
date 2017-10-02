package kawasaki.utfpr.com.android.snippets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckboxRadioButtonToastActivity02 extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivitySecond);
        getSupportActionBar().setTitle(R.string.title_radio_button_page);
    }

    public void showSelected(View view) {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radioBtnPage);
        String message = getString(R.string.radio_btn_none_option_radio_btn_page);

        switch(radio.getCheckedRadioButtonId()) {
            case R.id.radioButtonJava:
                message = getString(R.string.radio_btn_java_option_radio_btn_page);
                break;
            case R.id.radioButtonPascal:
                message = getString(R.string.radio_btn_pascal_option_radio_btn_page);
                break;
            case R.id.radioButtonCobol:
                message = getString(R.string.radio_btn_cobol_option_radio_btn_page);
                break;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
