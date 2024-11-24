package com.example.recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androiData;
    SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return false;
            }
        });
        GridLayoutManager gridLayoutManager= new GridLayoutManager(MainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList= new ArrayList<>();
        androiData = new DataClass("Potato Bread", R.string.Potato_Bread, "9 cubes",R.drawable.potato_bread);
        dataList.add(androiData);

        androiData = new DataClass("Ciabatta Bread", R.string.Ciabatta_Bread, "110 gm",R.drawable.ciabatta_bread);
        dataList.add(androiData);

        androiData = new DataClass("Croissant", R.string.Croissant, "45 gm",R.drawable.croissant);
        dataList.add(androiData);

        androiData = new DataClass("Nutty Almond Tiles", R.string.Nutty_Almond_Tiles, "150 gm",R.drawable.nutty_almond_tiles);
        dataList.add(androiData);

        androiData = new DataClass("Dry Cake", R.string.Dry_Cake, "300 gm",R.drawable.dry_cake);
        dataList.add(androiData);

        adapter= new MyAdapter(MainActivity.this, dataList);
        recyclerView.setAdapter(adapter);

    }
    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for(DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if(dataSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.setSearchList(dataSearchList);
        }

    }
}