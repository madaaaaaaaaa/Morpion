package Ultimate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ConditionVictoire implements Iterable<Gagnable>{

    private final List<Gagnable> gagnables;

    public ConditionVictoire(List<? extends Gagnable> gagnables){
       this.gagnables = (List<Gagnable>) gagnables;
    }

    public int requiertPourVictoire(Joueur joueur){
        return 3 - possede(joueur);
    }

    public boolean estGagnable(Joueur joueur){
        return possede(joueur.suivant()) == 0;

    }

    public int possede(Joueur joueur){
        int i = 0;
        for(Gagnable gagnable: gagnables){
            if(gagnable.estGagnerPar().et(joueur) == joueur)
                i++;
        }
        return i;
    }

    public ConditionVictoire determinerNouvelleVictoire(){
        Joueur gagnant = Joueur.VIDE;
        int[] consecutivePlayers = new int[Joueur.values().length];
        for(Gagnable gagnable: gagnables){
            Joueur actuel = gagnable.
        }
    }
    @Override
    public Iterator<Gagnable> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Gagnable> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Gagnable> spliterator() {
        return Iterable.super.spliterator();
    }
}
