package com.buidangnguyen.test;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.buidangnguyen.adapter.FoodAdapter;
import com.buidangnguyen.model.Food;
import com.buidangnguyen.test.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ListView lvFood;
    TextView txtCategoryTitle;
    ArrayList<Food> foodList;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lvFood = findViewById(R.id.lvFood);
        txtCategoryTitle = findViewById(R.id.txtCategoryTitle);

        String category = getIntent().getStringExtra("category");
        txtCategoryTitle.setText(category.replace("_", " "));

        foodList = loadDataFromJson(category);
        adapter = new FoodAdapter(this, R.layout.food_item, foodList);
        lvFood.setAdapter(adapter);
    }

    private ArrayList<Food> loadDataFromJson(String category) {
        ArrayList<Food> list = new ArrayList<>();
        try {
            InputStream is = getAssets().open("data.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String jsonStr = new String(buffer, "UTF-8");

            JSONArray root = new JSONArray(jsonStr);
            for (int i = 0; i < root.length(); i++) {
                JSONObject obj = root.getJSONObject(i);
                if (obj.has(category)) {
                    JSONArray items = obj.getJSONArray(category);
                    for (int j = 0; j < items.length(); j++) {
                        JSONObject item = items.getJSONObject(j);
                        String name = item.getString("placeName");
                        String desc = item.getString("dishName");
                        String photo = item.getString("photo");
                        float rating = (float) item.getDouble("ratingValue");
                        String review = item.getString("ratingCount");
                        String address = item.getString("address");

                        int resId = getResources().getIdentifier(photo, "drawable", getPackageName());
                        list.add(new Food(resId, name, desc, rating, review, address, true));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}