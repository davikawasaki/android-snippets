package kawasaki.utfpr.com.android.snippets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckboxRadioButtonToastActivity01 extends AppCompatActivity {

    private CheckBox checkBoxTeacher, checkBoxStudent, checkBoxStudentHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);
        getSupportActionBar().setTitle(R.string.title_checkbox_page);

        checkBoxTeacher = (CheckBox) findViewById(R.id.checkBoxTeacher);
        checkBoxStudent = (CheckBox) findViewById(R.id.checkBoxStudent);
        checkBoxStudentHelper = (CheckBox) findViewById(R.id.checkBoxStudentHelper);
    }

    public void showSelected(View view) {
        // Setting array list of checkbox checked
        List<String> userTypeSelected = new ArrayList<>();
        // Setting string message for checkboxes checked
        String selectedMessage = "Usuário(s) selecionado(s): ";

        if(checkBoxStudent.isChecked()) {
            userTypeSelected.add(getString(R.string.toast_student_checked_main));
        }
        if(checkBoxTeacher.isChecked()) {
            userTypeSelected.add(getString(R.string.toast_teacher_checked_main));
        }
        if(checkBoxStudentHelper.isChecked()) {
            userTypeSelected.add(getString(R.string.toast_student_helper_checked_main));
        }

        if(userTypeSelected.size() == 0) selectedMessage = "Nenhum usuário selecionado!";
        else {
            // Iterate to construct message with all userType selected
            for (String s : userTypeSelected) {
                if(userTypeSelected.indexOf(s) == (userTypeSelected.size() - 1))
                    selectedMessage = selectedMessage.concat(" " + s);
                else
                    selectedMessage = selectedMessage.concat(" " + s + ",");
            }
        }

        Toast.makeText(this, selectedMessage, Toast.LENGTH_SHORT).show();
    }

    public void goToRadioButtonPage(View view) {
        Intent i = new Intent(view.getContext(), CheckboxRadioButtonToastActivity02.class);
        startActivity(i);
    }
}
