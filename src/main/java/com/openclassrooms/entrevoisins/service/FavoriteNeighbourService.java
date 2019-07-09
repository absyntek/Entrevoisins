package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class FavoriteNeighbourService implements FavoriteApiService{

    private List<Integer> neighboursFavorite = new ArrayList<>();

    /**
     *
     * @return
     */
    @Override
    public List<Integer> getFavoritNeighbours() {
        return neighboursFavorite;
    }

    /**
     *
     * @param neighbour
     */
    @Override
    public void addFavoritNeighbour(int neighbour) {
        neighboursFavorite.add(neighbour);
    }

    /**
     *
     * @param neighbour
     */
    @Override
    public void deleteFavoritNeighbour(Object neighbour) {
        neighboursFavorite.remove(neighbour);
    }
}
