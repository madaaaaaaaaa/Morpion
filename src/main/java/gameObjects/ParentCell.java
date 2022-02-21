package gameObjects;

import util.Coordinates;
import util.Mark;

import java.util.ArrayList;

public class ParentCell {

    private Coordinates cor;
    private Mark mark;

    private ArrayList<Cell> childCells;

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
}
