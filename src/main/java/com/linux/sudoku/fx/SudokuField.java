package com.linux.sudoku.fx;

/**
 *
 * @author Guruprasad Kulkarni <guru@linux.com>
 */
public class SudokuField {

    private final int blockSize;

    private final int fieldSize;

    private final SudokuCell[][] field;

    public SudokuField(final int blocks) {
        blockSize = blocks;
        fieldSize = blockSize * blockSize;
        field = new SudokuCell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = new SudokuCell();
            }
        }
    }

    public int blockSize() {
        return blockSize;
    }

    public int fieldSize() {
        return fieldSize;
    }

    public int variantsPerCell() {
        return fieldSize;
    }

    public int numberOfCells() {
        return fieldSize * fieldSize;
    }

    public void clear(final int row, final int column) {
        field[row - 1][column - 1].clear();
    }

    public void clearAllCells() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                clear(i, j);
            }
        }
    }

    public void reset(final int row, final int column) {
        field[row - 1][column - 1].reset();
    }

    public void resetAllCells() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                reset(i, j);
            }
        }
    }

    public boolean isFilled(final int row, final int column) {
        return field[row - 1][column - 1].isFilled();
    }

    public boolean allCellsFilled() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (!isFilled(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numberOfFilledCells() {
        int numberFilled = 0;
        for (SudokuCell[] row : field) {
            for (SudokuCell cell : row) {
                if(cell.isFilled()) {
                    numberFilled++;
                }
            }
        }
        
        return numberFilled;
    }
    
    public int numberOfHiddenCells() {
        return numberOfCells() - numberOfFilledCells();
    }
    
    public int get(final int row, final int column) {
        return field[row - 1][column - 1].get();
    }
    
    public void set(final int row, final int column, final int number) {
        field[row - 1][column - 1].set(number);
    }
    
    public void hide(final int row, final int column) {
        field[row - 1][column - 1].hide();
    }
    
    public void show(final int row, final int column) {
        field[row - 1][column - 1].show();
    }
    
    public void tryNumber(final int row, final int column, final int number) {
        field[row - 1][column - 1].tryNumber(number);
    }
    
    public boolean numberHasBeenTried(final int row, final int column, final int number) {
        return field[row - 1][column - 1].isTried(number);
    }
    
    public int countOfTriedNumber(final int row, final int column, final int number) {
        return field[row - 1][column - 1].numberOfTries();
    }
    
    public boolean checkNumberBox(final int row, final int column, final int number) {
        int r = row, c = column;
        
        if(r % blockSize == 0) {
            r -= blockSize - 1;
        } else {
            r = (r / blockSize) * (blockSize + 1);
        }
        
        
        
        return true;
    }
    
    
    
}
