package com.corbishley.listview2app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private Context context;
    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        listView1 = (ListView) findViewById(R.id.listView_id);

        Map<String, Object> hamburger = new HashMap<>();
        hamburger.put("name","Hamburger");
        hamburger.put("price",120);
        hamburger.put("image",R.drawable.hamburger);

        Map<String, Object> frenchFries = new HashMap<>();
        frenchFries.put("name","French Fries");
        frenchFries.put("price",60);
        frenchFries.put("image",R.drawable.french_fries);

        Map<String, Object> coca = new HashMap<>();
        coca.put("name","Coca");
        coca.put("price",40);
        coca.put("image",R.drawable.coca_cola);

        Map<String, Object> cocaLight = new HashMap<>();
        cocaLight.put("name","Coca Light");
        cocaLight.put("price",35);
        cocaLight.put("image",R.drawable.coca_cola_light);

        Map<String, Object> cocaZero = new HashMap<>();
        cocaZero.put("name","Coca Zero");
        cocaZero.put("price",40);
        cocaZero.put("image",R.drawable.coca_cola_zero);

        Map<String, Object> kfc = new HashMap<>();
        kfc.put("name","KFC");
        kfc.put("price",150);
        kfc.put("image",R.drawable.kfc);


        List<Map<String,Object>> itemList = new ArrayList<>();
        itemList.add(hamburger);
        itemList.add(frenchFries);
        itemList.add(coca);
        itemList.add(cocaLight);
        itemList.add(cocaZero);
        itemList.add(kfc);

        SimpleAdapter adapter = new SimpleAdapter(context, itemList, R.layout.item_layout,
                new String[]{"name", "price", "image"},
                new int[]{R.id.textView_name, R.id.textView_price, R.id.imageView_image});

        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> item = (HashMap<String,Object>)parent.getItemAtPosition(position);
                String msg = item.get("name")+":"+item.get("price");
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
