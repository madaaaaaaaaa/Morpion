package expertPattern;

import gameObjects.ParentCell;

/**
 * Expert is the abstract class of the chain-of-responsibility design pattern.
 * An expert is an object that "Solve" a situation, if the expert detect that
 * it is not able to solve this situation, it calls the next expert recursively.
 * This means that the chain-of-responsiblity has a structure similar to a linked list.
 */
public abstract class Expert {

    private Expert next;

    public Expert() {
        setNext(null);
    }

    /**
     * Set next expert of this expert
     *
     * @param next expert
     */
    public void setNext(Expert next) {
        this.next = next;
    }


    /**
     * Recursive method that will go through the chain-of-responsibility,
     * analyzing for each expert if the expert can solve the situation and solve it
     * if it is the case.
     *
     * @param p the ParentCell which will be analyzed
     */
    public void detect(ParentCell p)  {
        if (this.canSolve(p)) {
            this.Solve(p);
        } else {
            if (next != null) {
                next.detect(p);
            }
        }
    }

    /**
     * This method analyze if the situation can be solved
     *
     * @param p the ParentCell which bill be analyzed
     * @return a boolean, true if the expert can solve this situation, false if not
     */
    abstract boolean canSolve(ParentCell p);


    /**
     * @param p the ParentCell where a win/loose/draw situation has occurred
     */
    abstract void Solve(ParentCell p);

    @Override
    public String toString() {
        return "Expert{" + getClass().getName() + "," +
                "next=" + next +
                '}';
    }
}

