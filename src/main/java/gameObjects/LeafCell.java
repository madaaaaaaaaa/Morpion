package gameObjects;

import util.Coordinates;
import util.Mark;

public class LeafCell implements Cell{

    private Coordinates cor;
    private Mark mark;

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
