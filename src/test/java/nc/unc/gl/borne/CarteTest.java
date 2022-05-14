package nc.unc.gl.borne;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nc.unc.gl.borne.Carte.Carte;
import nc.unc.gl.borne.Carte.Categorie.Effet.AttaqueEffet;
import nc.unc.gl.borne.Carte.Categorie.Effet.BorneDistance;
import nc.unc.gl.borne.Carte.Categorie.Effet.ParadeEffet;
import nc.unc.gl.borne.Carte.Categorie.Type.Attaque;
import nc.unc.gl.borne.Carte.Categorie.Type.Borne;
import nc.unc.gl.borne.Carte.Categorie.Type.Parade;
import nc.unc.gl.borne.Deck.Deck;
import nc.unc.gl.borne.Joueur.Joueur;
import nc.unc.gl.borne.Pioche.Pioche;

public class CarteTest {
    @Test
    public void carteAttaque() {
        Carte<Attaque> attaque_accident_from_carte = new Carte<Attaque>(new Attaque(AttaqueEffet.ACCIDENT));
        Attaque attaque_accident_from_class = new Attaque(AttaqueEffet.ACCIDENT);
        Assertions.assertEquals(attaque_accident_from_class.getClass(),
                attaque_accident_from_carte.getCategorie().getClass(),
                "Echec carte attaque");

    }

    @Test
    public void testDeck() {
        // Cartes
        Carte<Attaque> attaque_feu_rouge = new Carte<>(new Attaque(AttaqueEffet.FEU_ROUGE));
        Carte<Parade> parade_feu_vert = new Carte<>(new Parade(ParadeEffet.FEU_VERT));

        // Création du deck à partir des méthodes de la classe Deck
        Deck deck_classe = new Deck();
        deck_classe.ajouterCarte(attaque_feu_rouge);
        deck_classe.ajouterCarte(parade_feu_vert);

        // Création manuelle et insertion des cartes dans le deck
        ArrayList<Carte> deck_type = new ArrayList<>();
        deck_type.add(attaque_feu_rouge);
        deck_type.add(parade_feu_vert);

        // Test
        Assertions.assertEquals(deck_type, deck_classe.getCartes(), "Echec creation de deck");

        // Test des cartes disponibles
        System.out.println("Cartes disponibles : \n" + deck_classe.getDeckEffets());
    }

    @Test
    public void testPoserCarte() {
        // Cartes
        Carte<Attaque> attaque_feu_rouge = new Carte<>(new Attaque(AttaqueEffet.FEU_ROUGE));
        Carte<Parade> parade_feu_vert = new Carte<>(new Parade(ParadeEffet.FEU_VERT));
        Carte<Borne> borne_cinquante = new Carte<>(new Borne(BorneDistance.CINQUANTE));

        // Log , cible = null car joueur n'est pas encore implémenté
        System.out.println("Carte attaque feu rouge : " + attaque_feu_rouge.poserCarte(null));
        System.out.println("Carte parade feu vert   : " + parade_feu_vert.poserCarte(null));
        System.out.println("Carte borne cinquante   : " + borne_cinquante.poserCarte(null));

    }

    @Test
    public void testInitaliserPioche() {
        Pioche pioche = new Pioche();
        pioche.initialiserPioche();
        System.out.print("Pioche \n");
        for (Carte carte : pioche.getPioche()) {
            System.out.println(carte.getEffet());
        }
        System.out.print("--------------- \n");
        System.out.println(pioche.getPioche().firstElement().getEffet());
    }

    @Test
    public void testPilesCartes() {
        Joueur joueur = new Joueur("Jean");
        Carte<Attaque> attaque_feu_rouge = new Carte<>(new Attaque(AttaqueEffet.FEU_ROUGE));
        joueur.getListePiles().ajouterCarte(attaque_feu_rouge);

    }

    @Test
    public void testGetDeckCartesImages() {
        Pioche pioche = new Pioche();
        pioche.initialiserPioche();
        Joueur joueur = new Joueur("Jean");
        for(int i = 0; i < 4 ; i++ ){
            joueur.getDeckJoueur().ajouterCarte(pioche.getPioche().pop());
        }

        System.out.println(joueur.getDeckJoueur().getDeckCartesImages());
    }

    @Test
    public void testPilesAttackParade() {
        Joueur joueur1 = new Joueur("Jean");
        Joueur joueur2 = new Joueur("René");

        // Carte du joueur1
        Carte<Attaque> attaque_feu_rouge = new Carte<>(new Attaque(AttaqueEffet.FEU_ROUGE));

        joueur1.getDeckJoueur().ajouterCarte(attaque_feu_rouge);

        // Carte du joueur 2
        Carte<Parade> parade_feu_vert = new Carte<>(new Parade(ParadeEffet.FEU_VERT));
        joueur2.getDeckJoueur().ajouterCarte(parade_feu_vert);

        // Joueur 1 pose une la carte attaque feu rouge au joueur 2
        System.out.println(joueur2.getListePiles().ajouterCarte(attaque_feu_rouge));

        // Vérifie que la carte attaque feu a bien été passée dans la pile du joueur2
        System.out.println("Oh non joueur1 à placée une carte attaque sur joueur 2 : " +
                joueur2.getListePiles().getPileBataille().getDeck().getDeckEffets());

        // Joueur 2 contre l'attaque en posant dans sa pile bataille une carte parade
        // feu vert
        System.out.println(joueur2.getListePiles().ajouterCarte(parade_feu_vert));

    }
}
