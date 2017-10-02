package com.utfpr.kawasaki.android.snippets;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonToastActivity01 extends AppCompatActivity {

    private EditText edtFirstName;
    private EditText edtLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ActivityMain);

        // Get name and lastName fields
        edtFirstName = (EditText) findViewById(R.id.mainActivityFirstName);
        edtLastName = (EditText) findViewById(R.id.mainActivityLastName);
    }

    /**
     * Button call to clear fields
     * @param view
     */
    public void clearFields(View view) {
        // Clear fields
        edtFirstName.setText(null);
        edtLastName.setText(null);

        // Show a toast message
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, R.string.toast_clear_fields, duration);
        toast.show();
    }

    /**
     * Button call to show full name
     * @param view
     */
    public void showFullName(View view) {

        // Show a toast message
        int duration = Toast.LENGTH_SHORT;
        String fullName = "Nome completo: " + edtFirstName.getText() + " " + edtLastName.getText();

        Toast toast = Toast.makeText(this, fullName, duration);
        toast.show();
    }
}
