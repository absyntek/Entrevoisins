package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoNeighbourActivity extends AppCompatActivity {

    @BindView(R.id.tvNeighbourInformations)
    TextView mtvNeighbourInformations;

    @BindView(R.id.tvNeighbourName)
    TextView mtvNeighbourName;

    @BindView(R.id.imgProfilePic)
    ImageView mImageViewProfil;

    @BindView(R.id.fab_favorite)
    FloatingActionButton fab;

    CollapsingToolbarLayout mToolbarLayout;
    FavoriteApiService mFavoriteApiService;
    NeighbourApiService mNeighbourApiService;
    Neighbour neighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_neighbour);
        ButterKnife.bind(this);
        mFavoriteApiService = DI.getServiceFav();
        mNeighbourApiService = DI.getNeighbourApiService();

        mToolbarLayout = findViewById(R.id.toolbar_layout_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null){
            int neighbourID = intent.getIntExtra("neighbourID",-1);
            if (neighbourID != -1){ this.neighbour = mNeighbourApiService.findNeighbourByID(neighbourID); }
            if (neighbour != null){
                mToolbarLayout.setTitle(neighbour.getName());
                mtvNeighbourName.setText(neighbour.getName());
                Glide.with(this).load(neighbour.getAvatarUrl()).into(mImageViewProfil);

                if (isFavorite()){ fab.setImageResource(R.drawable.ic_star_24dp); }
                else{fab.setImageResource(R.drawable.ic_star_border_24dp);}
            }
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFavorite()){
                    changeStatuFavorite(false);
                    Snackbar.make(view, neighbour.getName() + " n'est plus dans vos favoris", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    changeStatuFavorite(true);
                    Snackbar.make(view, neighbour.getName() + " à bien été ajouté à vos favoris", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    private Boolean isFavorite(){
        return mFavoriteApiService.getFavoritNeighbours().contains(neighbour.getId());
    }

    private void changeStatuFavorite (boolean addOrRemove){
        if (addOrRemove){
            fab.setImageResource(R.drawable.ic_star_24dp);
            mFavoriteApiService.addFavoritNeighbour(this.neighbour.getId());

        }else {
            fab.setImageResource(R.drawable.ic_star_border_24dp);
            mFavoriteApiService.deleteFavoritNeighbour(this.neighbour.getId());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}