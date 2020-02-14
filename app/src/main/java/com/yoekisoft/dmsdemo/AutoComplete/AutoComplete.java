package com.yoekisoft.dmsdemo.AutoComplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.yoekisoft.dmsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete extends AppCompatActivity {
    AutoCompleteTextView txtid,txtname;
    List<AutoModel> mList;
    AutoAdapter adapter;
    private AutoModel selectedPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        mList = retrievePeople();




   /*     txtid =findViewById(R.id.auto_id);
        adapter = new AutoAdapter(this, R.layout.activity_auto_complete, 0, mList);
        txtid.setAdapter(adapter);
        txtid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                selectedPerson = (AutoModel) adapterView.getItemAtPosition(pos);
            }
        });
*/




        txtname =findViewById(R.id.auto_name);
        adapter = new AutoAdapter(this, R.layout.activity_auto_complete, R.id.lbl_name, mList);
        txtname.setAdapter(adapter);
        txtname.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                selectedPerson = (AutoModel) adapterView.getItemAtPosition(pos);
                Toast.makeText(AutoComplete.this, ""+selectedPerson.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<AutoModel> retrievePeople() {
        List<AutoModel> list = new ArrayList<AutoModel>();
        list.add(new AutoModel("James",  "1"));
        list.add(new AutoModel("Jason",  "11"));
        list.add(new AutoModel("Ethan",  "12"));
        list.add(new AutoModel("Eherlock",  "123"));
        return list;
    }
}