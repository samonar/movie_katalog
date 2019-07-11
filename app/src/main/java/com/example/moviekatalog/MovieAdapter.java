package com.example.moviekatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    Context context;
    ArrayList<Movie> movie;

    public void setMovie(ArrayList<Movie> movie) {
        this.movie = movie;
    }
    public MovieAdapter(Context context) {
        this.context = context;
        movie = new ArrayList<> ();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movie.size ();
    }

    @Override
    public Object getItem(int position) {
        return movie.get (position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);

        return convertView;
    }

    private class ViewHolder{
        private TextView  txtTitle,txtRelease,txtRating;
        private ImageView poster;

        ViewHolder(View view){
            txtTitle=view.findViewById (R.id.tv_title);
            txtRelease=view.findViewById (R.id.tv_release);
            txtRating=view.findViewById (R.id.tv_rating);
            poster=view.findViewById (R.id.img_poster);
        }

        public void bind(Movie movie) {
            txtTitle.setText (movie.getTitle ());
            txtRelease.setText (movie.getRelease ());
            txtRating.setText (movie.getRating ());
            Picasso.with (context)
                    .load (movie.getPoster ())
                    .fit ()
                    .centerCrop ()
                    .into (poster);
//            poster.setImageResource (movie.getPoster ());
        }
    }
}
