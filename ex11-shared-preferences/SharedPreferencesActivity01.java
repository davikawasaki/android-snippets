package kawasaki.utfpr.com.android.snippets;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SharedPreferencesActivity01 extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private int option = Color.BLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);
        constraintLayout = (ConstraintLayout) findViewById(R.id.layout_main);
        readColorPreference();
        changeBackgroundColor();
    }

    private void changeBackgroundColor() {
        constraintLayout.setBackgroundColor(option);
    }

    private void readColorPreference() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.color_preferences), Context.MODE_PRIVATE);
        option = sharedPref.getInt(getString(R.string.color_background), option);
    }

    private void saveColorPreference(int newValue) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.color_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.color_background), newValue);
        editor.commit();
        option = newValue;
        changeBackgroundColor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainMenu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch(option) {
            case Color.BLUE:
                menu.getItem(0).setChecked(true);
                return true;
            case Color.RED:
                menu.getItem(1).setChecked(true);
                return true;
            case Color.YELLOW:
                menu.getItem(2).setChecked(true);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(true);
        switch(item.getItemId()) {
            case R.id.menu_item_blue:
                saveColorPreference(Color.BLUE);
                return true;
            case R.id.menu_item_red:
                saveColorPreference(Color.RED);
                return true;
            case R.id.menu_item_yellow:
                saveColorPreference(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
