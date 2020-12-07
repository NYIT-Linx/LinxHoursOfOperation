package com.example.linxhoursofoperation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnNoteListener {

    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();


    }

    private void initImageBitmaps(){

        mNames.add("Ed Hall Café");
        mImageUrls.add("https://i.imgur.com/cAjql07.jpg");

        mNames.add("Old Westbury Bookstore");
        mImageUrls.add("https://i.imgur.com/FNg79r8.png");

        mNames.add("Recreation Hall");
        mImageUrls.add("https://i.imgur.com/TGizkVT.jpg");

        mNames.add("Riland Café");
        mImageUrls.add("https://i.imgur.com/sTZfsWd.jpg");

        mNames.add("SAC Dining Hall");
        mImageUrls.add("https://i.imgur.com/20xu5B3.jpg");

        mNames.add("Salten Café");
        mImageUrls.add("https://i.imgur.com/qolnBu4.jpg");

        mNames.add("Wisser Library");
        mImageUrls.add("https://i.imgur.com/njc78b6.jpg");


        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick:clicked.");
        mNames.get(position);
        Intent intent = new Intent(this, WisserLibrary.class);
        startActivity(intent);
    }
}