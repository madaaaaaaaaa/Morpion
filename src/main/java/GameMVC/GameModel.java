package GameMVC;

import expertPattern.*;
import gameObjects.Cell;
import gameObjects.ParentCell;
import gameObjects.ChangeCell;
import util.Coordinates;
import util.Mark;
import java.beans.PropertyChangeSupport;

import java.util.Random;

public class GameModel {

    private ParentCell rootCell;

    private Expert chainOfResponsibility;

    private Mark turn;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public GameModel(){
       initializeRootCell();
        chainOfResponsibility = new CheckDiagonalUpperLeft();
        chainOfResponsibility.setNext(new CheckDiagonalUpperRight());
        chainOfResponsibility.setNext(new CheckFirstColumn());
        chainOfResponsibility.setNext(new CheckSecondColumn());
        chainOfResponsibility.setNext(new CheckThirdColumn());
        chainOfResponsibility.setNext(new CheckFirstRow());
        chainOfResponsibility.setNext(new CheckSecondRow());
        chainOfResponsibility.setNext(new CheckThirdRow());


    }

    public ParentCell getRootCell() {
        return rootCell;
    }

    public void setRootCell(ParentCell rootCell) {
        this.rootCell = rootCell;
    }


    private void initializeRootCell(){
        this.setRootCell(new ParentCell(new Coordinates(0,0)));
        this.getRootCell().initializeEmptyParents();
        for(Cell c: this.getRootCell().getChildCells()){
            ParentCell p = (ParentCell) c;
            p.initializeEmptyLeaves();
        }
    }

    public Expert getChainOfResponsibility() {
        return chainOfResponsibility;
    }

    public Mark getTurn() {
        return turn;
    }

    public void setTurn(Mark turn) {

        this.turn = turn;

    }

    public void initializeRandomTurn(){
        Random r = new Random();
        if(r.nextInt()%2 == 0)
            turn = Mark.CIRCLE;
        else
            turn = Mark.CROSS;
    }

    public void changeCellValue(ChangeCell c){
        ParentCell pp = (ParentCell) this.getRootCell().getChild(c.getMediumCellCoordinates());
        pp.getChild(c.getLeafCellCoordinates()).setMark(c.getMark());


    }
}
