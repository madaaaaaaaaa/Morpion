package gameObjects;

import util.Coordinates;
import util.Mark;

public class LeafCell extends Cell{

    private Coordinates cor;
    private Mark mark;

    public LeafCell(Coordinates cor) {
        this.setCor(cor);
        this.setMark(Mark.EMPTY);
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


    @Override
    public String toString(){
        return "LeafCell=("+ this.cor + ")" + "[" + this.getMark() + "]";
    }
}
