package BatailleDeCarte.Entites;
public class Joueur {

    // ATTRIBUTS/PROPRIETES
    private Carte[] paquet;
    private int points;

    // CONSTRUCTEUR
    public Joueur() {
        // Initialisation du compteur de point à 0
        this.setPoints(0);
        // Définition de la taille maximal du paquet de carte
        this.setPaquet(new Carte[26]);
    }

    // METHODE
    // --Getters
    //Récupérer le paquet du joueur:
    public Carte[] getPaquet() {
        return this.paquet;
    }
    //Récupérer le nombre de point du joueur:
    public int getPoints() {
        return this.points;
    }
    // --Setters
    //Définir le paquet du joueur:
    public void setPaquet(Carte[] paquet) {
        this.paquet = paquet;
    }
    //Définir le nombre de points du joueur:
    public void setPoints(int points) {
        this.points = points;
    }

    // --Tirer carte
    public Carte TireUneCarte(int x){
        return paquet[x];
    }

    // --Afficher cartes du joueur
    public void voirCartes(){
        for (int i = 0; i < this.getPaquet().length; i++){
            System.out.println(this.getPaquet()[i].getNom() +
                    " de " + this.getPaquet()[i].getCouleur() +
                    " (Valeur: " + this.getPaquet()[i].getValeur() + ")");
        }
    }

}
