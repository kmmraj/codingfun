package com.test.divideandconquer;

public class MinCost2ReachLastCell {

    public static int findMinCost(int[][] cost, int row, int col) {

//        return cost[0][0] + cost[cost.length - 1][cost.length - 1] + findMinCost(cost, row, col, 0);
        return findMinCost(cost, row, col, 0);
    }

    /**
     * {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}}
     * <p>
     * 1   2   3
     * 4   8   2
     * 1   5   3
     */
    public static int findMinCost(int[][] cost, int row, int col, int minCost) {
        // BC
        if (row == cost.length || col == cost[row].length) {
            return Integer.MAX_VALUE;
        }

        if (row == cost.length - 1 && col == cost[row].length - 1) {
            return cost[cost.length - 1][cost[row].length - 1];
        }


        // Induction
        int includeRowAndSkipColumn = findMinCost(cost, row, col + 1, minCost);
        int skipRowAndIncludeColumn = findMinCost(cost, row + 1, col, minCost);

        // Hypo
        minCost = cost[row][col] + Math.min(includeRowAndSkipColumn, skipRowAndIncludeColumn);
        return minCost;
    }

    /**
     * {{1, 2, 4}, {4, 8, 2}, {3, 1, 3}}
     * <p>
     * 1   2   4
     * 4   8   2
     * 3   1   3
     */
    private static int numberOfWays(int[][] cost, int row, int column, int expectedCost) {
        // BC
        if (expectedCost < 0) {
            return 0;
        }

        if (row > cost.length - 1 && column > cost[row].length - 1) {
            return 0;
        }

        if (row == cost.length - 1 && column == cost[row].length - 1) {
            if (expectedCost - cost[row][column] == 0) {
                return 1;
            }
            return 0;
        }

        // Induction
        if (row == cost.length - 1 && column < cost[row].length - 1) {
            return numberOfWays(cost, row, column + 1, expectedCost - cost[row][column]);
        }

        if (row < cost.length - 1 && column == cost[row].length - 1) {
            return numberOfWays(cost, row + 1, column, expectedCost - cost[row][column]);
        }

        // Hypothesis

        int includeRowAndSkipColumn = numberOfWays(cost, row, column + 1, expectedCost - cost[row][column]);
        int skipRowAndIncludeColumn = numberOfWays(cost, row + 1, column, expectedCost - cost[row][column]);

        return includeRowAndSkipColumn + skipRowAndIncludeColumn;


    }

    public static void main(String[] args) {
        int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        System.out.println("Min cost : " + MinCost2ReachLastCell.findMinCost(cost, 0, 0));
        cost = new int[][]{{1, 2, 3}, {4, 8, 2}, {1, 5, 3}, {1, 5, 3}};

        /**
         * {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}, {1, 5, 3}}
         * <p>
         * 1   2   3
         * 4   8   2
         * 1   5   3
         * 1   5   3
         */
        System.out.println("Min cost : " + MinCost2ReachLastCell.findMinCost(cost, 0, 0));

        /**
         * {{1, 2, 4}, {4, 8, 2}, {3, 1, 3}}
         * <p>
         * 1   2   4
         * 4   8   2
         * 3   1   3
         */

        cost = new int[][]{{1, 2, 4}, {4, 8, 2}, {3, 1, 3}};
        System.out.println("Number of ways with the cost 12 is: "
                + MinCost2ReachLastCell.numberOfWays(cost, 0, 0, 12));

        /**
         * expected = 15
         * {{1, 2, 4,1}, {4, 8, 2,2}, {3, 1, 3, 3},{1, 1, 1, 2} }
         * <p>
         * 1   2   4   1
         * 4   8   2   2
         * 3   1   3   3
         * 1   3   1   2
         */

        cost = new int[][]{{1, 2, 4, 1}, {4, 8, 2, 2}, {3, 1, 3, 3}, {1, 1, 1, 2}};
        System.out.println("Number of ways with the cost 15 is: "
                + MinCost2ReachLastCell.numberOfWays(cost, 0, 0, 15));
    }


}
