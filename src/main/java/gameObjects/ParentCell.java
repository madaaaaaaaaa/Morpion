package gameObjects;

import util.Coordinates;
import util.Mark;

import java.util.ArrayList;

public class ParentCell extends Cell {

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

    public boolean isChildless(){
        return this.getChildCells().isEmpty();
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

    public Cell getChild(int row, int col){
        if(!this.isChildless()){
            return this.getChildCells().get(col*3 + row);
        }
        return null;
    }

    public Cell getChild(Coordinates cor){
        if(!this.isChildless()){
            return this.getChildCells().get(cor.getColumn()*3 + cor.getRow());
        }
        return null;
    }

    public void initializeEmptyLeaves(){
        if(this.getChildCells().isEmpty()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.getChildCells().add((new LeafCell(new Coordinates(i,j))));
                }
            }
        }
    }

    public String toString() {
        if (this.isChildless()) {
            return "Childless parent cell=" + this.getCor();
        } else {
            String tmp = "Parent cell=" + this.getCor() + " with children{\n";
            for(Cell c: this.getChildCells()){
                tmp += ("\t" + c.toString() + "\n");
            }
            tmp += "}\n";
            return tmp;
        }
    }
}
