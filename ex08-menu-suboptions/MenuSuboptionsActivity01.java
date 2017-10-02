package kawasaki.utfpr.com.android.snippets;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuSuboptionsActivity01 extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        layout = (ConstraintLayout) findViewById(R.id.layoutPrincipal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainMenu, menu);
        return true;
    }

    public void save(MenuItem item){
        Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show();
    }

    public void useData(MenuItem item){
        item.setChecked(!item.isChecked());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        item.setChecked(true);

        switch(item.getItemId()){
            case R.id.menuItemAzul:
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menuItemVermelho:
                layout.setBackgroundColor(Color.RED);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
