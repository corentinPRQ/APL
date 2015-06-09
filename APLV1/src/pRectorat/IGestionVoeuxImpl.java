package pRectorat;

import java.util.Hashtable;

public class IGestionVoeuxImpl extends IGestionVoeuxPOA{
	
	private Hashtable<String, Diplome[]> listeAccreditation;
	
	
	//constructeur par défaut
	public IGestionVoeuxImpl(){
		//Liste d'accréditation à charger avec un fichier
		listeAccreditation = new Hashtable<String, Diplome[]>();		
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

	@Override
	public Voeu[] getVoeux() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void repondreVoeu(DecisionEtudiant pDecision, Voeu v)
			throws VoeuNonTrouve {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validerVoeu(Voeu v) throws VoeuNonTrouve {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void relayerVoeu(Voeu voeu) throws VoeuNonTrouve {
		// TODO Auto-generated method stub
		
	}

	@Override
	//Change l'état d'un voeu
	public void setEtatVoeu(Voeu v, Etat e) {
		
		switch(v.etatVoeu.value()){
		//Le voeu est crée il peut passer "Valide en cours" ou "Non Valide"
		case Etat._cree:
			if(e==Etat.valide_encours || e==Etat.non_valide)
				v.etatVoeu=e;
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
			System.err.println("Le voeu est dans un état dans lequel il ne peux pas changer d'état : "+v.etatVoeu.toString());
		break;
		
		}	
	}
		

	@Override
	public void changerPeriode(String periode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voeu[] consulterListeVoeu(Etudiant etu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void faireVoeu(Voeu v) throws VoeuNonTrouve, EtudiantNonTrouve {
		// TODO Auto-generated method stub
		
	}

}
