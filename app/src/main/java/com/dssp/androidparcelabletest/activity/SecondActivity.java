package com.dssp.androidparcelabletest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dssp.androidparcelabletest.R;
import com.dssp.androidparcelabletest.model.Movie;
import com.dssp.androidparcelabletest.util.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dhanrajnaik522 on 7/16/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private static String LOG_TAG = SecondActivity.class.getSimpleName();
    private Context context = SecondActivity.this;
    private TextView moviename,moviegenre,movietheme,movie_date;
    private ImageView movie_image;
    private Picasso picasso ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        moviename = (TextView) findViewById(R.id.tv_moviename);
        moviegenre = (TextView) findViewById(R.id.tv_genere);
        movietheme = (TextView) findViewById(R.id.tv_description);
        movie_date = (TextView) findViewById(R.id.tv_year);
        movie_image = (ImageView) findViewById(R.id.iv_simpleimage);
        picasso = Picasso.with(context);


        Intent intent = getIntent();
        if(intent != null){

            //get parcel object
            Movie singleMovieObject = intent.getExtras().getParcelable(Constant.singleMovie);

            moviename.setText(singleMovieObject.getName());
            moviegenre.setText(singleMovieObject.getGenre());
            movie_date.setText(singleMovieObject.getYear());
            movietheme.setText(singleMovieObject.getDescription());
            picasso.load(singleMovieObject.getImageUrl()).into(movie_image);

        /*    //get parcel list
            List<Movie> movieListParcel = intent.getParcelableArrayListExtra(Constant.singleMovie);
            if(movieListParcel.size()>0){
                for(int i=0;i<movieListParcel.size();i++){
                    Log.e(LOG_TAG,"mOVIE NAME : "+movieListParcel.get(i).getName());
                }

            }*/

        }
    }
}
