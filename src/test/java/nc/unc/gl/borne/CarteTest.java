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
        Assertions.assertEquals(deck_type, deck_classe.getDeck(), "Echec creation de deck");

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
}
