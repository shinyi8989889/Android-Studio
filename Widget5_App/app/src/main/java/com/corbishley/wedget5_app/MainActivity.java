package com.corbishley.wedget5_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText nameEdit,dateEdit,inputEdit;
    private TextView textViewResult;
    private Button okButton,cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = (EditText) findViewById(R.id.editText_name);
        dateEdit = (EditText) findViewById(R.id.editText_date);
        inputEdit = (EditText) findViewById(R.id.editText_input);
        textViewResult = (TextView) findViewById(R.id.textView_result);
        textViewResult.setText(" ");

        okButton = (Button) findViewById(R.id.button_ok);
        cancelButton = (Button) findViewById(R.id.button_cancel);

        okButton.setOnClickListener(new myButtonClick());
        cancelButton.setOnClickListener(new myButtonClick());
    }

    private class myButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){

                case R.id.button_ok:

                    String name = nameEdit.getText().toString();
                    String date = dateEdit.getText().toString();
                    String content = inputEdit.getText().toString();

                    textViewResult.setText("");
                    textViewResult.append(content+ "\n\n");
                    textViewResult.append(name+"\n");
                    textViewResult.append(date);

                    break;

                case R.id.button_cancel:
                    nameEdit.setText("");
                    dateEdit.setText("");
                    inputEdit.setText("");
                    textViewResult.setText("");
                    break;
            }
        }
    }
}
