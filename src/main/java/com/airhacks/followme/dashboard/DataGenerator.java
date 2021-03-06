package com.airhacks.followme.dashboard;

/*
 * #%L
 * igniter
 * %%
 * Copyright (C) 2013 - 2016 Adam Bien
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;

/**
 *
 * @author guru.a.kulkarni
 */
public class DataGenerator {

    @PostConstruct
    public void init() {
        System.out.println("Tower.init()");
    }

    private static final Set<Integer> ONE_TO_NINE = new HashSet<>();

    static {
        for (int i = 1; i < 10; i++) {
            ONE_TO_NINE.add(Integer.valueOf(i));
        }
    }

    public int[][] generateArrayOfRandomNumbers() {
        int[][] arr = new int[9][9];
        for(int columnToCheck = 0; columnToCheck < 9; columnToCheck++) {
            while(!isValidColumn(arr, columnToCheck) && !isValidRow(arr[columnToCheck])) {
                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        final int randomNumberForBoard = getRandomNumberForBoard();
                        arr[row][col] = randomNumberForBoard;
                        // System.out.println("generateArrayOfRandomNumbers :: row : " + row + " | col : " + col + " | value : " + randomNumberForBoard);
                    }
        //                System.out.println("isValidRow? " + Arrays.toString(arr[row]));
                }
                System.out.println("Generated matrix Before column check :: ");
                for (int[] row : arr) {
                    System.out.println(Arrays.toString(row));
                }
            }
        }

        System.out.println("Generated matrix :: ");
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        return arr;
    }

    /**
     *
     * @param _3x3Box
     * @return
     */
    public boolean isValid3x3Box(int[][] _3x3Box) {
        Set<Integer> boxSet = new TreeSet<>();
        if (_3x3Box.length == 3) {
            for (int[] eachRow : _3x3Box) {
                if (eachRow.length == 3) {
                    for (int colVal : eachRow) {
                        boxSet.add(colVal);
                    }
                }
            }
        }

        return boxSet.containsAll(ONE_TO_NINE);
    }

    public boolean isValidColumn(int[][] input, int columnToCheck) {
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            column.add(input[i][columnToCheck]);
        }
        
//        System.out.println("isValidColumn() :: " + column.toString());
        return column.containsAll(ONE_TO_NINE);
    }
    
    public boolean isValidRow(int[] rowOrColumns) {
        Set<Integer> rowOrColumnValues = new HashSet<>();
        for (int rowOrColumnValue : rowOrColumns) {
            rowOrColumnValues.add(rowOrColumnValue);
        }
        return rowOrColumnValues.containsAll(ONE_TO_NINE);
    }

    public static int getRandomNumberForBoard() {
        return new Random().nextInt(9) + 1;
    }
}
