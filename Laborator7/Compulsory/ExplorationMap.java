package compulsory;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix ;
    private int rows, columns;
    //Cell should be a wrapper or alias for List<Token>

    public ExplorationMap( int rows, int columns) {
        matrix = new Cell[rows][columns];
        List<Token> initialList = new ArrayList<>();
        initialList.add(new Token(0));

        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++)
            {
                matrix[i][j] = new Cell(initialList);
            }
        }

        this.rows = rows;
        this.columns = columns;
    }
    //public ExplorationMap(){}

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (verifyMatrix()) {
                if (matrix[row][col].getTokens().size() == 1 && matrix[row][col].getTokens().get(0).getNumber() == 0) {
                    Cell list = new Cell(robot.getExplore().getMem().extractTokens(2));
                    if (list.getTokens().size() == 0) {
                        robot.setRunning(false);
                    } else {
                        this.matrix[row][col] = list;
                        System.out.println("Robot " + robot.getName() + " visited successfully the cell and put this tokens: " + list.getTokens() + "on this position: row " + row + " column " + col );
                        return true;
                    }
                }
            }
            else{
                robot.setRunning(false);
                System.out.println("All of cells was visited!");
            }
        }
        return false;
    }

    private boolean verifyMatrix(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j].getTokens().size() == 1 && matrix[i][j].getTokens().get(0).getNumber() == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
