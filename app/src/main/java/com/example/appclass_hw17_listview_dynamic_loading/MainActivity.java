package com.example.appclass_hw17_listview_dynamic_loading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private ListAdapter listAdapter;
    private TextView textView;
    ArrayList<String> myList ;
    private Button btnAdd;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = new ArrayList<String>(); //指定是String的型態
        arraylistInitial();
        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.listView);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listViewOnClickListener);
    }
    private AdapterView.OnItemClickListener listViewOnClickListener
            = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            // TODO Auto-generated method stub

            textView.setText("你選擇了: " + ((TextView) view).getText().toString());
        }
    };
    private void arraylistInitial(){
        myList.add("d(d＇∀＇)");
        myList.add("d(`･∀･)b");
        myList.add("ε٩(๑> ₃ <)۶з");
        myList.add("(*´∀`)~♥");
    }
    public void btnAddOnClick(View view){
        try {
            if("".equals(editText.getText().toString().trim())){
                Toast.makeText(MainActivity.this,"請不要空白", Toast.LENGTH_SHORT).show();
            }else {
                myList.add("" + editText.getText().toString());
            }
        }catch (Exception e){
            Log.d("Rui", e.toString());
            return;
        }

    }
}
