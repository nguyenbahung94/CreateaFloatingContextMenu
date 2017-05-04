package com.example.adam.createafloatingcontextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] android_versions;
    ArrayList<String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list_view);
        android_versions=getResources().getStringArray(R.array.android_version);
        for (String items:android_versions){
                 arrayList.add(items);
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
       // getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch(item.getItemId()){
            case R.id.id_delete:
                arrayList.remove(info.position);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Edit : " + android_versions[info.position]  , Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_help:
                Toast.makeText(this, "Delete : " + android_versions[info.position]  , Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_share:
                Toast.makeText(this, "Share : " + android_versions[info.position]  , Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }


}
