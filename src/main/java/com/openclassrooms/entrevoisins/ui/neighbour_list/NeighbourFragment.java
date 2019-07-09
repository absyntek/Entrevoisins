package com.openclassrooms.entrevoisins.ui.neighbour_list;

public class NeighbourFragment extends BaseFragmentTabs{

    public static NeighbourFragment newInstance() {
        NeighbourFragment fragment = new NeighbourFragment();
        return fragment;
    }

    @Override
    protected void initList() {
        mNeighbours = mApiService.getNeighbours();
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours));
    }
}