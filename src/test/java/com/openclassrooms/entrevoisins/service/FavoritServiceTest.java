package com.openclassrooms.entrevoisins.service;


import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class FavoritServiceTest {

    private FavoriteApiService service;


    @Before
    public void setup() { service = DI.getServiceFav();}


    @Test
    public void addNeigbourToFavorite(){
        service.addFavoritNeighbour(1);
        assertTrue(service.getFavoritNeighbours().contains(1));
    }
    @Test
    public void deleteFavoriteTest (){
        service.addFavoritNeighbour(1);
        assertTrue(service.getFavoritNeighbours().contains(1));
        service.deleteFavoritNeighbour(1);
        assertFalse(service.getFavoritNeighbours().contains(1));
    }
}

