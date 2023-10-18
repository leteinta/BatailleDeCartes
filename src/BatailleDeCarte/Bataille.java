package BatailleDeCarte;

import BatailleDeCarte.Entites.Carte;
import BatailleDeCarte.Entites.Joueur;

import java.util.Scanner;

public class Bataille {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jeu de la Bataille");
        // Etape 1 : Création du paquet :
        Carte[] paquet = Carte.initPaquet();

        // Etape 2 : Mélanger paquet :
        Carte.shuffle(paquet);

        // Etape 3 : Création des 2 joueurs :
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        // Etape 4 : Distribuer carte :
        Carte.distribuer(paquet, joueur1, joueur2);
        System.out.println("--------------------------------------------------");
        System.out.println("Distribution Carte terminée");
        System.out.println("--------------------------------------------------");

        /*
        Afficher paquet joueur1
        System.out.println("Cartes du joueur1 :");
        joueur1.voirCartes();
        Afficher paquet joueur2
         System.out.println("Cartes du joueur2 :");
        joueur2.voirCartes();
        */

        // Etape 5 : La partie commence :
        System.out.println("la partie commence : ");
        for(int i = 0; i < paquet.length/2; i++){
            System.out.println("--------------------------------------------------");
            System.out.println("Manche:"+(i+1));
            //Chaque joueur tire une carte :
            Carte carte1 = joueur1.TireUneCarte(i);
            Carte carte2 = joueur2.TireUneCarte(i);
            System.out.println("Carte joueur1--->"+ carte1.getNom()+" "+carte1.getCouleur());
            System.out.println("Carte joueur2--->"+ carte2.getNom()+" "+carte2.getCouleur());
            //Compare les cartes et le vainqueur gagne un point :
            if (Carte.isGreater(carte1,carte2)){
                System.out.println("Le joueur 1 gagne un point.");
                joueur1.setPoints(joueur1.getPoints() + 1);
            }else if (Carte.isGreater(carte2, carte1)) {
                System.out.println("Le joueur 2 gagne un point.");
                joueur2.setPoints(joueur2.getPoints() + 1);
            }else {
                System.out.println("Egalité : personne ne gagne de point.");
            }
            //Affichage du score :
            System.out.println("Score: Joueur1:"+ joueur1.getPoints()+" Score: Joueur2:"+joueur2.getPoints());
            System.out.println("--------------------------------------------------");
            System.out.println("Appuyer sur la touche entrer pour passer a la manche suivante......");
            scanner.nextLine();
        }
        //Affichage du vainqueur :
        if (joueur1.getPaquet().length > joueur2.getPaquet().length){
            System.out.println("Le joueur 1 possède le plus de carte, il gagne la partie.");
        } else if (joueur1.getPaquet().length < joueur2.getPaquet().length){
            System.out.println("Le joueur 1 possède le plus de carte, il gagne la partie.");
        } else {
            System.out.println("Les deux joueurs possèdent le même nombre de carte, le score va les départager");
            if (joueur1.getPoints() > joueur2.getPoints()){
                System.out.println("Le joueur 1 à le plus de point, il gagne la partie.");
            } else if (joueur1.getPoints() < joueur2.getPoints()){
                System.out.println("Le joueur 2 à le plus de point, il gagne la partie.");
            } else {
                System.out.println("Egalité parfaite, personne ne gagne la partie");
            }
        }




    }
}
