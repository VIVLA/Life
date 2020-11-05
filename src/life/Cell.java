package life;

import java.util.ArrayList;

public class Cell {
    
    public Rules status;
    private ArrayList<Cell> near;
    
    public Cell() {
        status = Rules.NONE;
        near = new ArrayList<>();
    }
    
    public void addNear(Cell cell) {
        near.add(cell);
    }
    
    public void step1() {
        int around = getCellsAmount();
        status = status.generation1(around);
    }
    
    public void step2() {
        status = status.generation2();
    }

    private int getCellsAmount() {
        int amount = 0;
        for (Cell cell : near) {
            if (cell.status.isCell())
                amount++;
        }
        return amount;
    }
    
    public void modify() {
        for (Cell cell : near)
            cell.status = cell.status.isCell() ? Rules.NONE : Rules.LIFE; 
    }
    
}
