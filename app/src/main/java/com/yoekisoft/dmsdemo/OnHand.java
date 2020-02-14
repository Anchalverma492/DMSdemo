package com.yoekisoft.dmsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OnHand extends AppCompatActivity implements View.OnClickListener {
    CardView linearlayout;
    String searcedcode;
    EditText onhandsearchitem;
    ImageButton onhandsearchbutton;
    TextView itemcodedisplay, itemqtydisplay, itemnamedisplay;
    List<RequisitionDetailModel> itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_hand);
        onhandsearchitem = findViewById(R.id.onhandsearchitem);
        onhandsearchbutton = findViewById(R.id.onhandsearchbutton);
        onhandsearchbutton.setOnClickListener(this);
        itemcodedisplay = findViewById(R.id.itemcodedisplay);
        itemnamedisplay = findViewById(R.id.itemnamedisplay);
        itemqtydisplay = findViewById(R.id.itemqtydisplay);
        linearlayout = findViewById(R.id.cardview);
        linearlayout.setVisibility(View.INVISIBLE);

        itemlist = new ArrayList<>();
        RequisitionDetailModel item = new RequisitionDetailModel("Item Name1", "13022020", "87612");
        RequisitionDetailModel item1 = new RequisitionDetailModel("Item Name2", "14022020", "12512");
        RequisitionDetailModel item2 = new RequisitionDetailModel("Item Name3", "15022020", "14125");
        itemlist.add(item);
        itemlist.add(item1);
        itemlist.add(item2);

    }

    @Override
    public void onClick(View v) {
        searcedcode = onhandsearchitem.getText().toString();
        for (int i = 0; i < itemlist.size(); i++) {
            if (itemlist.get(i).getItemNo().equals(searcedcode)) {
                linearlayout.setVisibility(View.VISIBLE);
                itemcodedisplay.setText(itemlist.get(i).getItemNo());
                itemnamedisplay.setText(itemlist.get(i).getItemName());
                itemqtydisplay.setText(itemlist.get(i).getRequestQty());
                onhandsearchitem.setText("");
            }
        }
    }
}
