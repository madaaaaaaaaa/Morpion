package Ultimate;

import expertPattern.Expert;

public class UltimateComposant implements Gagnable, Composite<UltimateComposant>{

    private UltimateComposant[][] composants = null;
    private final Expert chainOfResponsibility;

    private final UltimateComposant parent;
    private final int x;
    private final int y;
    private Joueur jouerPar = Joueur.VIDE;

    public UltimateComposant(UltimateComposant parent, int x, int y, int compteurRecursion){
        this.parent = parent;
        this.x = x;
        this.y = y;

        if(compteurRecursion != 0) {
            this.composants = new UltimateComposant[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.composants[i][j] = new UltimateComposant(this, i, j, compteurRecursion - 1);
                }
            }
        }
        else{
            this.composants = null;
        }
    }
    @Override
    public UltimateComposant getComposant(int x, int y) {
        if(hasComposant()){
            return this.composants[x][y];
        }
        else
            return this;
    }

    public void determinerGagnant(){
        Joueur gagnant = Joueur.VIDE;
        for(ConditionVictoire cond: this.conditionVictoire){
            joueur = joueur.ou(cond.nouvelleConditionVictoire());
        }
        this.jouerPar = gagnant;
    }
    public boolean estGagner(){
        return jouerPar != Joueur.VIDE;
    }
    @Override
    public boolean hasComposant() {
        return false;
    }
}
