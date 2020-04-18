package com.quwaysim.popularmovies.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.quwaysim.popularmovies.R;
import com.quwaysim.popularmovies.model.MovieDetails;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    MovieDetails details;
    ImageView mMoviePoster;
    TextView mTitle, mReleaseDate, mVoteAvg, mSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mMoviePoster = findViewById(R.id.imageView);
        mTitle = findViewById(R.id.title_text);
        mReleaseDate = findViewById(R.id.release_date_text);
        mVoteAvg = findViewById(R.id.vote_avg_text);
        mSynopsis = findViewById(R.id.synopsis_text);

        if(getIntent().hasExtra("details")){
            details = getIntent().getParcelableExtra("details");
            Log.d(TAG, "onCreate: " + details);

            Picasso.get().load(details.getMoviePoster()).into(mMoviePoster);
            mTitle.setText(details.getMovieTitle());
            mReleaseDate.setText(details.getReleaseDate());
            mVoteAvg.setText(details.getVoteAverage());
            mSynopsis.setText(details.getSynopsis());
        } else {
            Toast.makeText(this, "Oops, Something went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
