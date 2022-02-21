package gameObjects;

import util.Coordinates;
import util.Mark;

public interface Cell {

    public Coordinates getCor();

    public void setCor(Coordinates cor);

    public Mark getMark();

    public void setMark(Mark mark);
}
