package com.example.sqlitedemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, age;
    Button add, viewAll;
    Switch isActive;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.bu_add);
        viewAll = (Button) findViewById(R.id.bu_viewall);
        name = (EditText) findViewById(R.id.ed_name);
        age = (EditText) findViewById(R.id.ed_age);
        isActive = (Switch) findViewById(R.id.sw_active);
        listView = (ListView) findViewById(R.id.listview);
        //ADD buttons listener
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerModel customerModel;
                try {

                    customerModel = new CustomerModel(-1, name.getText().toString(), Integer.parseInt(age.getText().toString()), isActive.isChecked());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error in customer model", Toast.LENGTH_SHORT).show();
                    //this is default values
                    customerModel = new CustomerModel(-1, "error", 0, false);

                }
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                dataBaseHelper.addOne(customerModel);
            }
        });

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "this is viewAll button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}