package Ultimate;

public enum Joueur {
    VIDE, X, O, DUO;

    public Joueur suivant(){
        if(this == X)
            return O;
        else
            return X;
    }

    public Joueur et(Joueur o){
        if(this == VIDE || o == VIDE || o == null){
            return VIDE;
        }
        if(estUnique() && o.estUnique()){
            return this == o ? this : VIDE;
        }
        if(this == DUO)
            return o;
        return o.et(this);
    }
    public boolean est(Joueur o){
        return this.et(o) == o;
    }

    public static boolean estUnique(Joueur gagnant){
        return gagnant != null && gagnant.estUnique();
    }

    public boolean estUnique(){
        return this == O || this == X;
    }

    public Joueur ou(Joueur o){
        if(this == VIDE || other == null)
            
    }
}
