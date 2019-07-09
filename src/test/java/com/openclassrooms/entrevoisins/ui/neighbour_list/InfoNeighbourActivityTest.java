package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.FavoriteApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.Instant;

public class InfoNeighbourActivityTest {

    private Context mContext;
    private FavoriteApiService service;


    @Before
    public void setup() { service = DI.getServiceFav();}

    @Test
    public void addNeigbourToFavorite(){

    }
}

