package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    /*
  Input: numRows = 5
  Output: [.  [1],
             [1,1],
            [1,2,1],
           [1,3,3,1],
          [1,4,6,4,1]]
*/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangleList = new ArrayList<>();


        if(numRows >= 1){
            pascalTriangleList.add(List.of(1));
        }
        if(numRows >= 2){
           // pascalTriangleList.add(Arrays.asList(1,1));
            pascalTriangleList.add(List.of(1,1));
        }


        if(numRows == 1 || numRows == 2){
            return pascalTriangleList;
        }
        for(int idx=2;idx<numRows;++idx){
            List<Integer> tempRow = new ArrayList<>();
            //  for(List<Integer> innerLs : pascalTriangleList) {
            //              System.out.println(innerLs);
            // }
            tempRow.add(1);
            for(int jdx=1;jdx<idx;++jdx){
                // System.out.println("num of rows is "+numRows+ " idx is "+idx + " jdx is "+ jdx);
                // if(jdx>0 && jdx<idx){
                int sum = pascalTriangleList.get(idx-1).get(jdx-1) + pascalTriangleList.get(idx-1).get(jdx);
                tempRow.add(sum);
                // }
                // else {
                //     tempRow.add(1);
                // }
            }
            tempRow.add(1);
            pascalTriangleList.add(tempRow);
        }
        return pascalTriangleList;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println("pascalTriangle.generate(5) = " + pascalTriangle.generate(5));
        System.out.println("pascalTriangle.generate(6) = " + pascalTriangle.generate(6));
        System.out.println("pascalTriangle.generate(7) = " + pascalTriangle.generate(7));
        System.out.println("pascalTriangle.generate(8) = " + pascalTriangle.generate(8));
        System.out.println("pascalTriangle.generate(9) = " + pascalTriangle.generate(9));

    }
}
