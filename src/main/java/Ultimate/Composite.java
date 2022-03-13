package Ultimate;

public interface Composite<T> extends Gagnable{
    T getComposant(int x, int y);
    boolean hasComposant();
}
