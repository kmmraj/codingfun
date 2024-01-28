package com.test.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BuildingWithSunSetView {

    class BuildingWithSunSet {
        Integer buildingHeight;
        Integer buildingIndex;

        BuildingWithSunSet(Integer buildingHeight, Integer buildingIndex) {
            this.buildingHeight = buildingHeight;
            this.buildingIndex = buildingIndex;
        }
    }

    //Specifically, we use a stack to record buildings that have a view.
    // Each time a building b is processed, if it is taller than the building at the top of the stack,
    // we pop the stack until the top of the stack is taller than building all
    // the buildings thus removed lie to the east of a taller building.
    private List<Integer> examineBuildingWithSunset(List<Integer> buildingHeights) {
        Deque<BuildingWithSunSet> buildingWithSunSetStack = new java.util.LinkedList<>();
        int buildingIndex = 0;
        for (Integer buildingHeight : buildingHeights) {
            while (!buildingWithSunSetStack.isEmpty() &&
                    buildingHeight >= buildingWithSunSetStack.peekLast().buildingHeight) {
                buildingWithSunSetStack.removeLast();
            }
            buildingWithSunSetStack.addLast(new BuildingWithSunSet(buildingHeight, buildingIndex++));
        }
        return Arrays.asList(buildingWithSunSetStack.stream()
                .map(buildingWithSunSet -> buildingWithSunSet.buildingIndex).toArray(Integer[]::new));

    }


    public static void main(String[] argv) {
        BuildingWithSunSetView buildingWithSunset = new BuildingWithSunSetView();


        System.out.println("buildingWithSunset.examineBuildingWithSunset(Arrays.asList(4, 2, 3, 1))" +
                " should be [0, 2, 3] and the result is "
                + buildingWithSunset.examineBuildingWithSunset(Arrays.asList(4, 2, 3, 1)));

        System.out.println("buildingWithSunset.examineBuildingWithSunset(Arrays.asList(8, 4, 5, 3, 1, 7, 2))" +
                " should be [0, 5, 6] and the result is "
                + buildingWithSunset.examineBuildingWithSunset(Arrays.asList(8, 4, 5, 3, 1, 7, 2)));

    }


}
