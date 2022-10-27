package personnages;

//import villagegaulois.Musee;

public class Gaulois {
   private String nom;
   private int force;
   private int effetPotion = 1;
   private Equipement[] trophees = new Equipement[100];
   private int nbTrophees;

   public Gaulois(String nom, int force) {
      this.nom = nom;
      this.force = force;
   }

   public String getNom() {
      return nom;
   }

   public void parler(String texte) {
      System.out.println(prendreParole() + "« " + texte + "»");
   }

   private String prendreParole() {
      return "Le gaulois " + nom + " : ";
   }

   public void frapper(Romain romain) {
      System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
      Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
      for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++, nbTrophees++) {
         trophees[nbTrophees] = tropheesBataille[i];
      }
   }

   public void boirePotion(int forcePotion) {
      this.effetPotion = forcePotion;
      parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
   }

   //public void faireUneDonnation(Musee musee) {
     // if (nbTrophees != 0) {
       //  String texte = "Je donne au musee tous mes trophees : ";
         //for (int i = 0; i < nbTrophees; i++) {
           // texte += "\n- " + trophees[i];
            //musee.donnerTrophees(this, trophees[i]);
            //trophees[i] = null;
      //   }
        // nbTrophees = 0;
        // parler(texte);
     // }
   //}

// @Override
// public String toString() {
//    return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
// }

   public static void main(String[] args) {
      Gaulois asterix = new Gaulois("Astérix", 8);
      System.out.println("Test méthode getNom");
      System.out.println(asterix.getNom());
      System.out.println("\nTest méthode prendreParole");
      asterix.prendreParole();
      System.out.println("\nTest méthode parler");
      asterix.parler("Bonjour");
      System.out.println("\nTest méthode frapper");
      asterix.frapper(new Romain("Minus", 6));
      asterix.boirePotion(5);
   }
}