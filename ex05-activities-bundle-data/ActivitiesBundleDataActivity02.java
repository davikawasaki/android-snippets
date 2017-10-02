package kawasaki.utfpr.com.android.snippets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ActivitiesBundleDataActivity02 extends AppCompatActivity {

    private EditText sentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivitySecond);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_action_name);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        sentName = (EditText) findViewById(R.id.editTextSentName);
        sentName.setText(name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home) {
            finish();
        }
        return true;
    }

    public void goBack(View view) {
        this.finish();
    }
}
