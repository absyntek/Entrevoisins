package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import junit.framework.TestCase;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;
    private Neighbour mNeighbour;
    private FavoriteApiService serviceFav;

    @Before
    public void setup() {
        serviceFav = DI.getServiceFav();
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void getNeighbourBydTest (){
        mNeighbour = service.getNeighbours().get(1);
        int neighbourId = mNeighbour.getId();
        assertEquals(mNeighbour,service.findNeighbourByID(neighbourId));
    }

    @Test
    public void addNeigbourToFavorite(){
        serviceFav.addFavoritNeighbour(1);
        assertTrue(serviceFav.getFavoritNeighbours().contains(1));
    }
    @Test
    public void deleteFavoriteTest (){
        serviceFav.addFavoritNeighbour(1);
        assertTrue(serviceFav.getFavoritNeighbours().contains(1));
        serviceFav.deleteFavoritNeighbour(1);
        TestCase.assertFalse(serviceFav.getFavoritNeighbours().contains(1));
    }
}
