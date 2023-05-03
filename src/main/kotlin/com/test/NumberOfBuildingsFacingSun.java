package com.test;

import java.util.ArrayList;
import java.util.List;

public class NumberOfBuildingsFacingSun {

    public List<Integer> getBuildingsWithAView(int[] buildings) {
        List<Integer> buildingWithView = new ArrayList<Integer>();

        int maxHeightBuilding =0;
        for (int item:buildings) {
            if(maxHeightBuilding < item){
                maxHeightBuilding = item;
                buildingWithView.add(item);
            }
        }

        return buildingWithView;
    }
    public static void main(String[] args) {
        int arr[] = {7, 4, 8, 2, 9,8,14};
        NumberOfBuildingsFacingSun nbfc = new NumberOfBuildingsFacingSun();
        nbfc.getBuildingsWithAView(arr);
    }
}
