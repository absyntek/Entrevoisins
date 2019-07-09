package com.openclassrooms.entrevoisins.ui.neighbour_list;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends BaseFragmentTabs{

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    /**
     * Init the List of Favorite neighbours
     */
    protected void initList() {

        mNeighbours = mApiService.getNeighbours();
        List<Neighbour> mNeighboursFav = new ArrayList<>();
        if (!mFavoriteApiService.getFavoritNeighbours().isEmpty()){
            for (int mIdFavorite : mFavoriteApiService.getFavoritNeighbours()) {
                if (mApiService.findNeighbourByID(mIdFavorite) != null){
                    mNeighboursFav.add(mApiService.findNeighbourByID(mIdFavorite));
                }else {
                    mFavoriteApiService.deleteFavoritNeighbour(mIdFavorite);
                }
            }
        }
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighboursFav));
    }
}
