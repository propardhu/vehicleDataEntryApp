package com.example.dbms2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);

    }
    public void addRecords(View view)
    {
        DbManager db=new DbManager(this);
        int res=db.addRecord(t1.getText().toString(),t2.getText().toString(),t3.getText().toString());
        if(res== 1)
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Not Inserted" , Toast.LENGTH_SHORT).show();
        t1.setText("");
        t2.setText("");
        t3.setText("");
    }
}
