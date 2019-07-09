package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public interface FavoriteApiService {

    /**
     * Get all Favorit Neighbours
     * @return {@link List}
     */
    List<Integer> getFavoritNeighbours();

    /**
     *
     * @param neighbourID
     */
    void addFavoritNeighbour(int neighbourID);

    /**
     * Deletes a neighbour
     * @param neighbourID
     */
    void deleteFavoritNeighbour(Object neighbourID);
}
