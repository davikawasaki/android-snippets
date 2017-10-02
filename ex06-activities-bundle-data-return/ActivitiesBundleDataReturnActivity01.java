package kawasaki.utfpr.com.android.snippets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivitiesBundleDataReturnActivity01 extends AppCompatActivity {

    public static final String NAME    = "NOME";
    public static final String HAS_CAR = "POSSUI_CARRO";
    public static final String TYPE    = "TIPO";

    private EditText   editTextName;
    private CheckBox   checkBoxHasCar;
    private RadioGroup radioGroupType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        editTextName   = (EditText)   findViewById(R.id.editTextName);
        checkBoxHasCar = (CheckBox)   findViewById(R.id.checkBoxHasCar);
        radioGroupType = (RadioGroup) findViewById(R.id.radioGroupType);
    }

    public void send(View view){

        Intent intent = new Intent(this, ActivitiesBundleDataReturnActivity02.class);
        intent.putExtra(NAME,
                        editTextName.getText().toString());
        intent.putExtra(HAS_CAR,
                        checkBoxHasCar.isChecked());

        switch(radioGroupType.getCheckedRadioButtonId()){

            case R.id.radioButtonStudent:
                intent.putExtra(TYPE, "Aluno");
                break;
            case R.id.radioButtonProfessor:
                intent.putExtra(TYPE, "Professor");
                break;
        }

        startActivityForResult(intent, ActivitiesBundleDataReturnActivity02.ASK_GRADE);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data){
        super.onActivityResult(requestCode,
                               resultCode,
                               data);

        if (requestCode == ActivitiesBundleDataReturnActivity02.ASK_GRADE &&
            resultCode  == Activity.RESULT_OK){

            Bundle bundle = data.getExtras();

            int grade = bundle.getInt(ActivitiesBundleDataReturnActivity02.GRADE);

            Toast.makeText(this,
                           "Nota " + grade,
                           Toast.LENGTH_SHORT).show();
        }

    }
}
