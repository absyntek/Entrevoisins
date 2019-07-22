package com.openclassrooms.entrevoisins.service;

import java.util.List;

public interface FavoriteApiService {

    /**
     * Get all Favorit Neighbours
     * @return {@link List}
     */
    List<Integer> getFavoritNeighbours();

    /**
     * Add a neighbour ID to the favorite list
     * @param neighbourID
     */
    void addFavoritNeighbour(int neighbourID);

    /**
     * Deletes a neighbour
     * @param neighbourID
     */
    void deleteFavoritNeighbour(Object neighbourID);
}
