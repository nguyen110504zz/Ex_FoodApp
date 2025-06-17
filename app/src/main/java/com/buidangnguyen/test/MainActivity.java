package com.buidangnguyen.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.buidangnguyen.test.R;

public class MainActivity extends AppCompatActivity {
    //helo babi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.lunchBox).setOnClickListener(v -> openCategory("LUNCH_BOX"));
        findViewById(R.id.noodle).setOnClickListener(v -> openCategory("NOODLE"));
        findViewById(R.id.milkTea).setOnClickListener(v -> openCategory("MILK_TEA"));
        findViewById(R.id.snack).setOnClickListener(v -> openCategory("SNACK"));
        findViewById(R.id.korean).setOnClickListener(v -> openCategory("KOREAN"));
        findViewById(R.id.healthy).setOnClickListener(v -> openCategory("HEALTHY"));
    }

    private void openCategory(String category) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}