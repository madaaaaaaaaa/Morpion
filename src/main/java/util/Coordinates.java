package util;

public class Coordinates {
    private int row;
    private int column;

    public Coordinates(int column, int row) {
        this.row = row;
        this.column = column;
    }

    public Coordinates() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean equals(Coordinates cor){
        return (cor.getRow() == this.getRow() && cor.getColumn() == this.getColumn());
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
