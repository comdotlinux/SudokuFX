package com.linux.sudoku.fx;

import java.util.HashSet;
import java.util.Set;

/**
 * This is copied verbatim from http://stackoverflow.com/questions/15690254/how-to-generate-a-complete-sudoku-board-algorithm-error
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class SudokuCell {
    private int value;
    private boolean filled;
    private Set<Integer> tried;

    public SudokuCell() {
        filled = false;
        tried = new HashSet<>();
    }
    
    public boolean isFilled() {
        return filled;
    }

    public void set(final int number) {
        tried.add(number);
        filled = true;
        value = number;
    }
    
    public void clear() {
        value = 0;
        filled = false;
    }
    
    public void reset() {
        clear();
        tried.clear();
    }
    
    public void show() {
        filled = true;
    }
    
    public void hide() {
        filled = false;
    }
    
    public boolean isTried(final int number) {
        return tried.contains(number);
    }
    
    public void tryNumber(final int number) {
        tried.add(number);
    }
    
    public int numberOfTries() {
        return tried.size();
    }
    
    public int get() {
        return value;
    }
}
