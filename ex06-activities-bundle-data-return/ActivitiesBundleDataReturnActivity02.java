package kawasaki.utfpr.com.android.snippets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ActivitiesBundleDataReturnActivity02 extends AppCompatActivity {

    public static final String GRADE = "NOTA";

    public static final int ASK_GRADE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivitySecond);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String  name   = bundle.getString(ActivitiesBundleDataReturnActivity01.NAME);
        boolean hasCar = bundle.getBoolean(ActivitiesBundleDataReturnActivity01.HAS_CAR);
        String  type   = bundle.getString(ActivitiesBundleDataReturnActivity01.TYPE);


        TextView textViewData = (TextView) findViewById(R.id.textViewData);

        String output = "Nome: " + name + "\n";

        output += (hasCar ? "Possui carro" : "Não possui carro") + "\n";

        outputu += "Tipo: " + type;

        textViewData.setText(output);
    }

    public void back(View View){

        Intent intent = new Intent();

        intent.putExtra(GRADE,1000);

        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}
