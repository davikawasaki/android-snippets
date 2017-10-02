package kawasaki.utfpr.com.android.snippets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnersActivity01 extends AppCompatActivity {

    private Spinner spinnerLabels, spinnerModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        spinnerLabels = (Spinner) findViewById(R.id.spinnerLabels);
        spinnerModels = (Spinner) findViewById(R.id.spinnerModels);

        // overriding an anonymous class
        spinnerLabels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fillModelsByLabel(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fillModelsByLabel(String label) {
        ArrayList<String> labelModels = new ArrayList<String>();

        switch (label) {
            case "Ford":
                for (String s : getResources().getStringArray(R.array.models_ford)) {
                    labelModels.add(s);
                }
                break;
            case "Fiat":
                for (String s : getResources().getStringArray(R.array.models_fiat)) {
                    labelModels.add(s);
                }
                break;
            default:
                break;
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, labelModels);

        spinnerModels.setAdapter(adapter);
    }


}
