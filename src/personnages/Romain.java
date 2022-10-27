package personnages;

public class Romain {
   private String nom;
   private int force;
   private Equipement[] equipements = new Equipement[2];
   private int nbEquipement = 0;

   public Romain(String nom, int force) {
      this.nom = nom;
      this.force = force;
      // Invariant
      assert force > 0;
   }

   public int getForce() {
      return force;
   }

   public String getNom() {
      return nom;
   }

   public void parler(String texte) {
      System.out.println(prendreParole() + "« " + texte + "»");
   }

   private String prendreParole() {
      return "Le romain " + nom + " : ";
   }

   public Equipement[] recevoirCoup(int forceCoup) {
      Equipement[] equipementEjecte = null;
      // précondition
      assert force > 0;
      int oldForce = force;

      forceCoup = calculResistanceEquipement(forceCoup);

      force -= forceCoup;
      if (force > 0) {
         parler("Aïe");
      } else {
         equipementEjecte = ejecterEquipement();
         parler("J'abandonne...");
      }
      // post condition la force à diminuer
      assert force < oldForce;
      return equipementEjecte;
   }

   private int calculResistanceEquipement(int forceCoup) {
      String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
      int resistanceEquipement = 0;
      if (nbEquipement != 0) {
         texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
         for (int i = 0; i < nbEquipement; i++) {
            if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))==true) {
               resistanceEquipement += 8;
            } else {
               System.out.println("Equipement casque");
               resistanceEquipement += 5;
            }
         }
         texte += resistanceEquipement + "!";
      }
      parler(texte);
      forceCoup =- resistanceEquipement;
      if (forceCoup < 0) {
         forceCoup = 0;
      }
      return forceCoup;
   }

   public void sEquiper(Equipement equipement) {
      switch (nbEquipement) {
      case 2:
         System.out.println("Le soldat " + nom + " est déjà bien protégé !");
         break;
      case 1:
         if (equipements[0].equals(equipement)) {
            System.out.println("Le soldat " + nom + " possède déjà un " + equipement + ".");
         } else {
            ajouterEquipement(equipement);
         }
         break;

      default:
         ajouterEquipement(equipement);
         break;
      }
   }

   private void ajouterEquipement(Equipement equipement) {
      equipements[nbEquipement] = equipement;
      nbEquipement++;
      System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
   }

   private Equipement[] ejecterEquipement() {
      Equipement[] equipementEjecte = new Equipement[nbEquipement];
      int nbEquipementEjecte = 0;
      for (int i = 0; i < nbEquipement; i++) {
         if (equipements[i] != null) {
            equipementEjecte[nbEquipementEjecte] = equipements[i];
            nbEquipementEjecte++;
            equipements[i] = null;
         }
      }
      return equipementEjecte;
   }

   public static void main(String[] args) {
      Romain romain = new Romain("Minus", -6);
      System.out.println("\nTest méthode prendreParole");
      System.out.println(romain.prendreParole());
      System.out.println("\nTest méthode parler");
      romain.parler("Bonjour");
      System.out.println("\nTest méthode recevoirCoup");
      romain.recevoirCoup(2);
      System.out.println(Equipement.CASQUE);
      System.out.println(Equipement.BOUCLIER);
   }
}
