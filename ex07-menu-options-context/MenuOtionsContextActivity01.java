package kawasaki.utfpr.com.android.snippets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuOptionsContextActivity01 extends AppCompatActivity {

    private ListView listViewLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        listView = (ListView) findViewById(R.id.listView);

        fillList();

        registerForContextMenu(listView);
    }

    private void fillList(){
        ArrayList<String> list = new ArrayList<String>();

        list.add("João");
        list.add("Maria");
        list.add("Jose");

        ArrayAdapter<String> adapter =
            new ArrayAdapter<String>(this,
                               android.R.layout.simple_list_item_1,
                                     list);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainMenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.menuItemChange:
                Toast.makeText(this,
                               "Alterar",
                               Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItemDelete:
                Toast.makeText(this,
                        "Excluir",
                        Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);

        getMenuInflater().inflate(R.menu.contextMenu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info;

        info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        String name = listView.getItemAtPosition(info.position).toString();

        switch(item.getItemId()){

            case R.id.menuItemOpen:
                Toast.makeText(this,
                               "Abrir: " + info.id + " - " + name,
                               Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menuItemDelete:
                Toast.makeText(this,
                               "Excluir: " + info.id + " - " + name,
                               Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
