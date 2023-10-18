package BatailleDeCarte.Entites;
public class Carte {
    // ATTRIBUTS/PROPRIETES
    private String couleur;
    private String nom;
    private int valeur;

    // CONSTRUCTEUR
    public Carte(String varCouleur,String varNom, int varValeur ){
        this.setCouleur(varCouleur);
        this.setNom(varNom);
        this.setValeur(varValeur);

    }

    // METHODES
    // --Getters
    //Récupérer la couleur de la carte:
    public String getCouleur() {
        return this.couleur;
    }

    //Récupérer le nom de la carte:
    public String getNom() {
        return this.nom;
    }

    //Récupérer la valeur de la carte:
    public int getValeur() {
        return this.valeur;
    }

    // --Setters
    // Définir la couleur de la carte:
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    //Définir le nom de la carte
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Définir la valeur de la carte
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    // --Comparateur
    public static boolean isGreater(Carte carte1, Carte carte2){
        return (carte1.getValeur() > carte2.getValeur());
    }

    // --Initialisation du paquet de carte
    public static Carte[] initPaquet() {
        // Créer un jeu de 52 cartes
        Carte[] cartes = new Carte[52];
        // Définir les couleurs possible
        String[] couleurs = {"Coeur", "Carreau", "Trèfle", "Pic"};
        // Définir les noms possible
        String[] nom = {"As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"};
        // Définir les valeurs possible
        int[] valeurs = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // Création des cartes
        int numCarte = 0;
        for (int i = 0; i < couleurs.length; i++) {
            for (int j = 0; j < valeurs.length; j++) {
                cartes[numCarte] = new Carte(couleurs[i], nom[j], valeurs[j]);
                numCarte++;
            }
        }
        return cartes;
    }

    // Voir un paquet de cartes
    public static void voirPaquet(Carte[] paquet) {
        System.out.println("Taille du paquet : " + paquet.length);
        // Afficher les cartes du paquet
        for (int i = 0; i < paquet.length; i++) {
            System.out.println("Index actuel : " + i);
            System.out.println(paquet[i].getNom() + " de " + paquet[i].getCouleur() + " (Valeur: "
                    + paquet[i].getValeur() + ")");
        }
    }
    // Mélanger les cartes
    public static void shuffle(Carte[] paquet){
        //Mélanger le tableau de cartes
        // ! Mémo: vérifier que tout les index sont diférents
        for (int i = 0; i < paquet.length; i++) {
            //Choisir un slot au hasard dans le paquet
            int randomIndex = (int) (Math.random() * paquet.length);
            //Copier la carte dans la var temp
            Carte temp = paquet[i];
            //Ecraser la carte au slot actuel avec la carte du slot aléatoire
            paquet[i] = paquet[randomIndex];
            //Déplacer la carte sauvegardee au slot aléatoire pour finalisée
            paquet[randomIndex] = temp;
        }
    }
    // Distribuer les cartes d'un paquet à deux joueurs
    public static void distribuer(Carte[] paquet, Joueur joueur1, Joueur joueur2){
        //Distribution ??
        for (int i = 0; i < paquet.length; i++){
            if (i % 2 == 0){
                joueur1.getPaquet()[ i/2 ] = paquet[i];
            }else {
                joueur2.getPaquet()[ i/2 ] = paquet[i];
            }
        }
    }
}
