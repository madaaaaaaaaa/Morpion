package Ultimate;

public class UltimateController {
    protected final UltimateComposant game;
    protected Joueur currentPlayer = Joueur.X;
    private UltimateListener  moveListener;
    private StringBuilder history;
}
