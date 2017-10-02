package kawasaki.utfpr.com.android.snippets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewToastActivity01 extends AppCompatActivity {

    private ListView listViewPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        listViewPeople = (ListView) findViewById(R.id.listViewPeople);

        loadItens();
        listViewPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();

                // Anonymous class
                Toast.makeText(PrincipalActivity.this, name + " foi selecionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadItens() {
        ArrayList<String> peopleList = new ArrayList<String>();

        peopleList.add("Pedro");
        peopleList.add("Zeca");
        peopleList.add("Maria");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peopleList);

        listViewPeople.setAdapter(adapter);
    }
}
