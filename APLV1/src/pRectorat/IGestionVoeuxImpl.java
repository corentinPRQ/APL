package pRectorat;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class IGestionVoeuxImpl extends IGestionVoeuxPOA{
	
	private Hashtable<String, Diplome[]> listeAccreditation;
	private Hashtable<String, Voeu[]> listeVoeux;
	
	//constructeur par d�faut
	public IGestionVoeuxImpl(){
		//Liste d'accr�ditation � charger avec un fichier
		listeAccreditation = new Hashtable<String, Diplome[]>();
		listeVoeux = new Hashtable<String, Voeu[]>();
	}

	@Override
	public Universite[] getCatalogueUniversite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accred[] getListeAccreditations() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Renvoie tous les voeux
	 * le return est un tableau de voeux qui peut contenir des valeurs null � la fin
	 */
	@Override
	public Voeu[] getVoeux() {
		Collection<Voeu[]> colV = this.listeVoeux.values();
		int taille = colV.size();
		//on cr�e un tableau de voeux en fonction de la taille max potentielle
		Voeu[]tabV = new Voeu [5*taille];
		int i=0;
		Iterator <Voeu[]> itV = colV.iterator();
		//On parcourt la collection de Voeu[5] de la HM
		while(itV.hasNext()){
			Voeu[] tabVTmp= new Voeu[5];
			tabVTmp = itV.next();
			// on parcourt les 5 voeux potentiel
			for(int j=0; tabVTmp[j] != null && j<tabVTmp.length; j++){
				tabV[i]= tabVTmp[j];
				i++;
			}
			
		}
		
		return tabV;
	}
	
	/**
	 * Permet de modifier la d�cision de l'�tudiant sur un voeu
	 * @param pDecision
	 * @param v
	 * @throws VoeuNonTrouve
	 */
	@Override
	public void repondreVoeu(DecisionEtudiant pDecision, Voeu v)
			throws VoeuNonTrouve {
		v.decEtudiant=pDecision;
		
	}

	
	@Override
	public void validerVoeu(Voeu v) throws VoeuNonTrouve {
		
		boolean prerequisOK=false;
		String dipV = v.acreditation.noD;
		String[]PR = {""}; //TODO appel � la m�thode getPr�requis de universit� avec en param l'intitul� de la formation 
		String formaEtu = ""; //TODO r�cup�rer la formation du mec
		for(int i=0; i<PR.length; i++){
			if(PR[i].equals(formaEtu)){
				prerequisOK=true;
			}
			break;
		}
		
		if(prerequisOK){
			this.setEtatVoeu(v, Etat.valide_encours);
		}else{
			this.setEtatVoeu(v, Etat.non_valide);
		}
		
	}

	@Override
	@Deprecated
	public void relayerVoeu(Voeu voeu) throws VoeuNonTrouve {
		// TODO Auto-generated method stub
		
	}

	@Override
	//Change l'�tat d'un voeu
	public void setEtatVoeu(Voeu v, Etat e) {
		
		switch(v.etatVoeu.value()){
		//Le voeu est cr�e il peut passer "Valide en cours" ou "Non Valide"
		case Etat._cree:
			if(e==Etat.valide_encours || e==Etat.non_valide)
				v.etatVoeu=e;
			break;
		//Le voeu est "Valide en cours" il peut passer "liste principale" "liste secondaire" "refus"
		case Etat._valide_encours:
			if(e==Etat.liste_principale || e==Etat.liste_secondaire|| e==Etat.refus)
				v.etatVoeu=e;
			break;
		//Le voeu est en liste secondaire il peut passer en refus
		case Etat._liste_secondaire:
			if(e==Etat.refus)
				v.etatVoeu=e;
			break;
		default:
			System.err.println("Le voeu est dans un �tat dans lequel il ne peux pas changer d'�tat : "+v.etatVoeu.toString());
			break;
		
		}	
	}
		

	@Override
	public void changerPeriode(String periode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voeu[] consulterListeVoeu(Etudiant etu) {
		return listeVoeux.get(etu.noEtu);
	}

	/**
	 * Permet d'enregistrer un voeu dans la liste des voeux
	 */
	@Override
	public void faireVoeu(Voeu v) throws VoeuNonTrouve, EtudiantNonTrouve {
		Rectorat r = new Rectorat();  //TODO lancer l'application gestVoeu avec un id de rectorat et voir comment le r�cup�rer
		if(v.idR==r){
			this.enregistrerVoeu(v);
		}else{
			//TODO trouver le gestVoeu
			// lebongestVoeu.faireVoeu(v);
		}
		
		
	}
	
	private void enregistrerVoeu(Voeu v){
		Voeu [] tabV = new Voeu[5];
		tabV = this.listeVoeux.get(v.noE);
		int i=0;
		while(tabV[i] != null && i<tabV.length){
			i++;
		}
		if (i<tabV.length){
			tabV[i] = v;
			this.listeVoeux.put(v.noE, tabV);
		}else{
			System.out.println("D�j� 5 voeux ont �t� fait");
		}
		
	}

}
