package personnages;

public class Musee {
	private int nbTrophee=0;
	private Equipement[] tropheesMusee = new Equipement[200];
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		tropheesMusee[nbTrophee] = equipement;
		nbTrophee+=1;
	}
	
	public void extraireInstructionsCaml(Gaulois gaulois) {
		String texte= "let musee [\n";
		for(int i=0;i<nbTrophee;i++) {
			if(i==nbTrophee-1) {
				texte += "    «" + gaulois.getNom() + "»" + ", " + "«" + tropheesMusee[i] + "»" +"\n";
			}else {
				texte += "    «" + gaulois.getNom() + "»" + ", " + "«" + tropheesMusee[i] + "»;" +"\n";
			}
		}
		texte += "]";
		System.out.println(texte);
	}

}
