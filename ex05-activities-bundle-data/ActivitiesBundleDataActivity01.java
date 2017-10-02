package kawasaki.utfpr.com.android.snippets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ActivitiesBundleDataActivity01 extends AppCompatActivity {

    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        editTextName = (EditText) findViewById(R.id.editTextName);
    }

    public void goToSecondScreen(View view) {
        Intent intent = new Intent(this, ActivitiesBundleDataActivity02.class);
        intent.putExtra("name", editTextName.getText().toString());
        startActivity(intent);
    }
}
