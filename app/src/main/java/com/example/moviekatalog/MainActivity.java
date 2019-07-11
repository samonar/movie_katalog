package com.example.moviekatalog;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle;
    private  String[] dataRelease;
    private  String[] dataRating;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

//    private String[] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patimura","R A Kartini","Sukarno"};
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        adapter= new MovieAdapter (this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText (MainActivity.this, movies.get (position).getTitle (), Toast.LENGTH_SHORT).show ();
            }
        });
    }

    private void addItem(){
        movies=new ArrayList<> ();

        for (int i=0; i< dataTitle.length;i++){
            Movie movie=new Movie ();
            movie.setPoster (dataPoster.getResourceId (i,-1));
            movie.setTitle (dataTitle[i]);
            movie.setRating (dataRating[i]);
            movie.setRelease (dataRelease[i]);
            movies.add(movie);
        }
        adapter.setMovie (movies);
    }

    private void prepare(){
        dataTitle=getResources ().getStringArray (R.array.title);
        dataRelease=getResources ().getStringArray (R.array.release);
        dataRating=getResources ().getStringArray (R.array.rating);
        dataPoster=getResources ().obtainTypedArray (R.array.poster);
    }
}
