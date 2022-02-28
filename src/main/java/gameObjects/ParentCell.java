package gameObjects;

import util.Coordinates;
import util.Mark;

import java.util.ArrayList;

public class ParentCell {

    private Coordinates cor;
    private Mark mark;

    private ArrayList<Cell> childCells;

    public ParentCell(Coordinates cor) {
        this.cor = cor;
        this.setMark(Mark.EMPTY);
        this.childCells = new ArrayList<Cell>();
    }

    public Coordinates getCor() {
        return cor;
    }

    public void setCor(Coordinates cor) {
        this.cor = cor;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public ArrayList<Cell> getChildCells() {
        return childCells;
    }

    public void initializeEmptyParents(){
        if(this.getChildCells().isEmpty()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.getChildCells().add((Cell) new ParentCell(new Coordinates(i,j)));
                }
            }
        }
    }

    public void initializeEmptyLeaves(){
        if(this.getChildCells().isEmpty()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.getChildCells().add((Cell) new LeafCell(new Coordinates(i,j)));
                }
            }
        }
    }
}
