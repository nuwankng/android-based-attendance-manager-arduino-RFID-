package com.mcuhq.simplebluetooth;

import android.app.Application;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by kng on 3/20/18.
 */

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView = (ListView ) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data= myDB.getListContents();

        if(data.getCount() == 0 ){

            Toast.makeText(ViewListContents.this,"bad",Toast.LENGTH_LONG).show();
        }else{

            while (data.moveToNext()){

                theList.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}

