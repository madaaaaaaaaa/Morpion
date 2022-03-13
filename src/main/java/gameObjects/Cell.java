package gameObjects;

import util.Coordinates;
import util.Mark;

public abstract class Cell {

    public abstract Coordinates getCor();

    public abstract void setCor(Coordinates cor);

    public abstract Mark getMark();

    public abstract void setMark(Mark mark);

    public abstract String toString();
}
