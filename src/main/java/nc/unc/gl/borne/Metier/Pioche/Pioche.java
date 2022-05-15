package nc.unc.gl.borne.Metier.Pioche;

import java.util.Collections;
import java.util.Stack;
import nc.unc.gl.borne.Metier.Carte.Carte;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.AttaqueEffet;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.BorneDistance;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.BotteEffet;
import nc.unc.gl.borne.Metier.Carte.Categorie.Effet.ParadeEffet;
import nc.unc.gl.borne.Metier.Carte.Categorie.Type.Attaque;
import nc.unc.gl.borne.Metier.Carte.Categorie.Type.Borne;
import nc.unc.gl.borne.Metier.Carte.Categorie.Type.Botte;
import nc.unc.gl.borne.Metier.Carte.Categorie.Type.Parade;
import nc.unc.gl.borne.Metier.Joueur.Joueur;

public class Pioche {
    private static Stack<Carte> pioche = new Stack<Carte>();

    public Pioche() {
        initialiserPioche();
    }

    public Stack<Carte> getPioche() {
        return pioche;
    }

    public void initialiserPioche() {
        initialiserCartesAttaques();
        initialiserCartesParades();
        initialiserCartesBottes();
        initialiserCartesBornes();
        melangerCartes();
    }

    /**
     * Initalise les cartes attaques et les ajoute dans la pioche
     * 
     */
    private static void initialiserCartesAttaques() {
        for (int i = 0; i < 5; i++) {
            Carte<Attaque> attaque_feu_rouge = new Carte<>(new Attaque(AttaqueEffet.FEU_ROUGE));
            pioche.push(attaque_feu_rouge);
        }
        for (int i = 0; i < 4; i++) {
            Carte<Attaque> attaque_limite_vitesse = new Carte<>(new Attaque(AttaqueEffet.LIMITE_VITESSE));
            pioche.push(attaque_limite_vitesse);
        }
        for (int i = 0; i < 3; i++) {
            Carte<Attaque> attaque_panne_essence = new Carte<>(new Attaque(AttaqueEffet.PANNE_ESSENCE));
            pioche.push(attaque_panne_essence);
        }
        for (int i = 0; i < 3; i++) {
            Carte<Attaque> attaque_crevaison = new Carte<>(new Attaque(AttaqueEffet.CREVAISON));
            pioche.push(attaque_crevaison);
        }
        for (int i = 0; i < 3; i++) {
            Carte<Attaque> attaque_accident = new Carte<>(new Attaque(AttaqueEffet.ACCIDENT));
            pioche.push(attaque_accident);
        }
    }

    /**
     * Initialise les cartes parades et les ajoute dans la pioche
     * 
     */
    private static void initialiserCartesParades() {
        for (int i = 0; i < 14; i++) {
            Carte<Parade> parade_feu_vert = new Carte<>(new Parade(ParadeEffet.FEU_VERT));
            pioche.push(parade_feu_vert);
        }
        for (int i = 0; i < 6; i++) {
            Carte<Parade> parade_fin_limite_de_vitesse = new Carte<>(new Parade(ParadeEffet.LIMITE_VITESSE));
            pioche.push(parade_fin_limite_de_vitesse);
        }
        for (int i = 0; i < 6; i++) {
            Carte<Parade> parade_essence = new Carte<>(new Parade(ParadeEffet.ESSENCE));
            pioche.push(parade_essence);
        }
        for (int i = 0; i < 6; i++) {
            Carte<Parade> roue_de_secours = new Carte<>(new Parade(ParadeEffet.ROUE_DE_SECOURS));
            pioche.push(roue_de_secours);
        }
        for (int i = 0; i < 6; i++) {
            Carte<Parade> parade_reparations = new Carte<>(new Parade(ParadeEffet.REPARATIONS));
            pioche.push(parade_reparations);
        }
    }

    /**
     * Initialise les cartes bottes et les ajoute dans la pioche
     * 
     */
    private static void initialiserCartesBottes() {
        Carte<Botte> botte_vehicule_prioritaire = new Carte<>(new Botte(BotteEffet.VEHICULE_PRIORITAIRE));
        Carte<Botte> botte_citerne_essence = new Carte<>(new Botte(BotteEffet.CITERNE_ESSENCE));
        Carte<Botte> botte_increvable = new Carte<>(new Botte(BotteEffet.INCREVABLE));
        Carte<Botte> botte_as_du_volant = new Carte<>(new Botte(BotteEffet.AS_DU_VOLANT));

        pioche.push(botte_vehicule_prioritaire);
        pioche.push(botte_citerne_essence);
        pioche.push(botte_increvable);
        pioche.push(botte_as_du_volant);
    }

    /**
     * Initialise les cartes bornes et les ajoute dans la pioche
     * 
     */
    private static void initialiserCartesBornes() {
        for (int i = 0; i < 10; i++) {
            Carte<Borne> borne_ving_cinq = new Carte<>(new Borne(BorneDistance.VINGT_CINQ));
            pioche.push(borne_ving_cinq);
        }
        for (int i = 0; i < 10; i++) {
            Carte<Borne> borne_cinquante = new Carte<>(new Borne(BorneDistance.CINQUANTE));
            pioche.push(borne_cinquante);
        }
        for (int i = 0; i < 10; i++) {
            Carte<Borne> borne_soixante_quinze = new Carte<>(new Borne(BorneDistance.SOIXANTE_QUINZE));
            pioche.push(borne_soixante_quinze);
        }
        for (int i = 0; i < 12; i++) {
            Carte<Borne> borne_cent = new Carte<>(new Borne(BorneDistance.CENT));
            pioche.push(borne_cent);
        }
        for (int i = 0; i < 4; i++) {
            Carte<Borne> borne_deux_cent = new Carte<>(new Borne(BorneDistance.DEUX_CENTS));
            pioche.push(borne_deux_cent);
        }
    }

    private static void melangerCartes() {
        Collections.shuffle(pioche);
    }

    public void distribuer(Joueur joueur1, Joueur joueur2){
        for (int i = 0; i < 6; i++) {
            joueur1.getDeckJoueur().ajouterCarte(this.getPioche().pop());
            joueur2.getDeckJoueur().ajouterCarte(this.getPioche().pop());
        }
    }
}
