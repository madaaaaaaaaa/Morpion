package expertPattern;

import gameObjects.ParentCell;
import util.Mark;

public class CheckSecondColumn extends Expert{

    @Override
    boolean canSolve(ParentCell p) {
        if(p.getMark() == Mark.EMPTY) {
            Mark m = p.getChild(0, 1).getMark();
            if (m == Mark.EMPTY) return false;
            else {
                if (p.getChild(1, 1).getMark() == m && p.getChild(2, 1).getMark() == m) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    void Solve(ParentCell p) {
        p.setMark(p.getChild(0, 1).getMark());
        System.out.println("Victory for " + p.getChild(0,1).getMark());
    }
}
