package expertPattern;

import gameObjects.ParentCell;
import util.Mark;

public class CheckSecondRow extends Expert{

    @Override
    boolean canSolve(ParentCell p) {
        if(p.getMark() == Mark.EMPTY) {
            Mark m = p.getChild(1, 0).getMark();
            if (m == Mark.EMPTY) return false;
            else {
                if (p.getChild(1, 1).getMark() == m && p.getChild(1, 2).getMark() == m) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    void Solve(ParentCell p) {
        p.setMark(p.getChild(1, 0).getMark());
        System.out.println("Victory for " + p.getChild(1,0).getMark());
    }
}
