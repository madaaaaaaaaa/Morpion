package gameObjects;

import util.Coordinates;
import util.Mark;


public class ChangeCell {

    private Coordinates mediumCellCoordinates;
    private Coordinates leafCellCoordinates;
    private Mark mark;

    public Coordinates getMediumCellCoordinates() {
        return mediumCellCoordinates;
    }

    public void setMediumCellCoordinates(Coordinates mediumCellCoordinates) {
        this.mediumCellCoordinates = mediumCellCoordinates;
    }

    public Coordinates getLeafCellCoordinates() {
        return leafCellCoordinates;
    }

    public void setLeafCellCoordinates(Coordinates leafCellCoordinates) {
        this.leafCellCoordinates = leafCellCoordinates;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "ChangeCell{" +
                "mediumCellCoordinates=" + mediumCellCoordinates +
                ", leafCellCoordinates=" + leafCellCoordinates +
                ", mark=" + mark +
                '}';
    }
}
