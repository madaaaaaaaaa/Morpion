package GameMVC;

import gameObjects.Cell;
import gameObjects.ParentCell;
import util.Coordinates;

public class GameModel {

    private ParentCell rootCell;

    public GameModel(){
       initializeRootCell();

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
}
