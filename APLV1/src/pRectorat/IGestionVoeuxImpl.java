package pRectorat;

import java.io.FileNotFoundException;

import utilitaires.utils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;

import Applications.PeriodeApplication;
import ClientsServeurs.ClientGestionVoeuxUniversite;

public class IGestionVoeuxImpl extends IGestionVoeuxPOA {
	private static org.omg.CORBA.ORB orb;
	private static NamingContext nameRoot;
	private static String nomObj;

	private Hashtable<String, Voeu[]> listeVoeux;
	private Hashtable<String, String[]> listeAccreditation;
	private Accred[] lesAccred;
	private Hashtable<String, String> listeUtilisateurs;
	
	//constructeur par d�faut
	public IGestionVoeuxImpl(ORB orb, NamingContext nameRoot, String nomObj){
		//Liste d'accr�ditation � charger avec un fichier
		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;

		listeAccreditation = new Hashtable<String, String[]>();
		listeVoeux = new Hashtable<String, Voeu[]>();
		listeUtilisateurs = new Hashtable<String, String>();
		initialiserUsers("src/users.csv");
		initialiserAccred("src/Accreditation.csv");
	}

	@Override
	public Universite[] getCatalogueUniversite() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean identifier(String login, String mdp)
			throws EtudiantNonTrouve {
		if (!listeUtilisateurs.contains(login)) {
			// mettre un code GUI pour notifier de l'erreur d'identification
			throw new EtudiantNonTrouve();
		} else {
			if (listeUtilisateurs.get(login).equals(mdp) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Accred[] getListeAccreditations() {
		return null;
	}

	/**
	 * Renvoie tous les voeux le return est un tableau de voeux qui peut
	 * contenir des valeurs null � la fin
	 */
	@Override
	public Voeu[] getVoeux() {
		System.out.println("Entr� dans le getVoeux de IGestionVoeuIMPL");
		Voeu vt = new Voeu("tests", "0", new Accred(), new Rectorat(), null,
				null);
		Voeu[] lesVt = new Voeu[1];
		lesVt[0] = vt;
		return (lesVt);
		
		
//		Collection<Voeu[]> colV = this.listeVoeux.values();
//		int taille = colV.size();
//		// on cr�e un tableau de voeux en fonction de la taille max potentielle
//		Voeu[] tabV = new Voeu[5 * taille];
//		int i = 0;
//		Iterator<Voeu[]> itV = colV.iterator();
//		// On parcourt la collection de Voeu[5] de la HM
//		while (itV.hasNext()) {
//			Voeu[] tabVTmp = new Voeu[5];
//			tabVTmp = itV.next();
//			// on parcourt les 5 voeux potentiel
//			for (int j = 0; tabVTmp[j] != null && j < tabVTmp.length; j++) {
//				tabV[i] = tabVTmp[j];
//				i++;
//			}
//		}
//
//		if (tabV.length != 0) {
//			System.out.println(tabV.length);
//			return tabV;
//		} else {
//			Voeu v = new Voeu("listeVide", "0", new Accred(), new Rectorat(), null,
//					null);
//			Voeu[] lesV = new Voeu[1];
//			lesV[0] = v;
//			return (lesV);
//		}

	}

	/**
	 * Permet de modifier la d�cision de l'�tudiant sur un voeu
	 * 
	 * @param pDecision
	 * @param v
	 * @throws VoeuNonTrouve
	 */
	@Override
	public void repondreVoeu(DecisionEtudiant pDecision, Voeu v)
			throws VoeuNonTrouve {
		v.decEtudiant = pDecision;
	}

	private void validerVoeu(Voeu v) throws VoeuNonTrouve {
		String idObj = v.acreditation.libelleU + "_Gestion";
		ClientGestionVoeuxUniversite cu = new ClientGestionVoeuxUniversite(orb,
				nameRoot, nomObj, idObj);

		boolean prerequisOK = false;
		String dipV = v.acreditation.libelleD;
		// appel � la m�thode getPr�requis de universit� avec en param
		// l'intitul� de la formation
		Diplome[] pr = cu.getListePrerequis(dipV);
		String formaEtu = "L3 Miage"; // TODO r�cup�rer la formation du mec
		for (int i = 0; i < pr.length; i++) {
			if (pr[i].libelle.equals(formaEtu)) {
				prerequisOK = true;
			}
			break;
		}

		if (prerequisOK) {
			this.setEtatVoeu(v, Etat.valide_encours);
		} else {
			this.setEtatVoeu(v, Etat.non_valide);
		}
	}

	@Override
	// Change l'�tat d'un voeu
	public void setEtatVoeu(Voeu v, Etat e) {

		switch (v.etatVoeu.value()) {
		// Le voeu est cr�e il peut passer "Valide en cours" ou "Non Valide"
		case Etat._cree:
			if (e == Etat.valide_encours || e == Etat.non_valide)
				v.etatVoeu = e;
			break;
		// Le voeu est "Valide en cours" il peut passer "liste principale"
		// "liste secondaire" "refus"
		case Etat._valide_encours:
			if (e == Etat.liste_principale || e == Etat.liste_secondaire
					|| e == Etat.refus)
				v.etatVoeu = e;
			break;
		// Le voeu est en liste secondaire il peut passer en refus
		case Etat._liste_secondaire:
			if (e == Etat.refus)
				v.etatVoeu = e;
			break;
		default:
			System.err
					.println("Le voeu est dans un �tat dans lequel il ne peux pas changer d'�tat : "
							+ v.etatVoeu.toString());
			break;

		}
	}

	public static void changerPeriode() {
		// La m�thode consiste en une MAJ du properties
		Properties p;
		p = null;
		try {
			p = utils.load("parametres.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Echec ouverture properties");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Echec ouverture properties");
			e.printStackTrace();
		}
		if (p != null) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("parametres.properties");
				if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_1.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_2.toString());
				} else if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_2.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_3.toString());
				} else if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_3.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_4.toString());
				}
				// Enregistrement
				p.store(fos, null);
			} catch (FileNotFoundException e1) {
				System.out.println("Echec �criture properties");
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		Rectorat r = new Rectorat();
		// TODO lancer l'application gestVoeu avec un id de rectorat et voir
		// comment le r�cup�rer
		if (v.idR == r) {
			this.enregistrerVoeu(v);
		} else {
			// TODO trouver le gestVoeu
			// lebongestVoeu.faireVoeu(v);
		}

	}

	private void enregistrerVoeu(Voeu v) {
		Voeu[] tabV = new Voeu[5];
		tabV = this.listeVoeux.get(v.noE);
		int i = 0;
		while (tabV[i] != null && i < tabV.length) {
			i++;
		}
		if (i < tabV.length) {
			tabV[i] = v;
			this.listeVoeux.put(v.noE, tabV);
		} else {
			System.out.println("D�j� 5 voeux ont �t� fait");
		}
	}

	private void initialiserUsers(String path) {
		String lineRead;
		String[] lineSplit;
		String login = "";
		String mdp = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";", 4);
				// System.out.println("line split users : "+ lineSplit[0] +
				// " - " + lineSplit[1] + " - " + lineSplit[2] + " - "
				// +lineSplit[3]);
				for (int i = 0; i < lineSplit.length; i++) {
					switch (i) {
					case 0:
						login = lineSplit[0];
						break;
					case 1:
						mdp = lineSplit[1];
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						break;
					}
				}
				// System.out.println("Login : "+login + " - mdp : "+mdp);
				this.listeUtilisateurs.put(login, mdp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialiserAccred(String path) {
		/*
		 * R�fl�chir � un moyen d'int�grer les notes pour les pr�requis! 
		 */
		
		String lineRead;
		String[] lineSplit;
		String Universite="";
		String Diplome="";
		String NoAccred="";

		
		//variable comptant le nombre de lignes du fichier par diplome
		int cpteur = 0;
		String DipPrecedent = "";
		ArrayList<Accred> listAccred = new ArrayList<Accred>();
		
	
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",3);
//				System.out.println("line split : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				for (int i=0; i<lineSplit.length; i++){
					switch(i){ 
					case 0 : NoAccred= lineSplit[0];
					break;
					case 1 : Diplome= lineSplit[1];
					break;
					case 2 : Universite = lineSplit[2];
					break;
					default : System.err.println("Erreur dans la lecture du fichier");
					break;
					}					
				}
				listAccred.add(new Accred(NoAccred,Diplome,Universite));
				
				/*//si le num�ro etudiant est diff�rent du pr�c�dent c'est qu'on chang� d'�tudiant, donc on enregistre ses notes
//				System.out.println("NumDIP : " + numDip + " - numDipPrecedent : " + numDipPrecedent);
				if (!Diplome.equals(DipPrecedent)){
					lesUniv = new String[list.size()];
					for(int i=0;i<list.size();i++){
						lesUniv[i]=list.get(i);
					}
					this.listeAccreditation.put(DipPrecedent,lesUniv);
					list=new ArrayList<String>();
				}
				
				DipPrecedent = Diplome;
				
				list.add(Universite);
				*/
				
			}
			/*lesUniv = new String[list.size()];
			for(int i=0;i<list.size();i++){
				lesUniv[i]=list.get(i);*/
			
			//} this.listeAccreditation.put(Diplome, lesUniv);
			this.lesAccred=new Accred[listAccred.size()];
			for(int i=0;i<listAccred.size();i++){
				lesAccred[i]=listAccred.get(i);
			}		
			NoAccred="";
			listAccred = new ArrayList<Accred>();
		
//			lesUniv = new String[list.size()];

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void afficherAccred(){
		for(int i = 0;i<lesAccred.length;i++){
			System.out.println(lesAccred[i].toString());
		}
	}

	// public static void main (String [] args){
	// System.out.println("Debut du test");
	// IGestionVoeuxImpl igV=new IGestionVoeuxImpl(orb, nameRoot, nomObj);
	//
	// try {
	// igV.validerVoeu(new Voeu("v1", "e1", new Accred("a1", "dip1", "lib1"),
	// new Rectorat("midi-pyrenees"), DecisionEtudiant.oui,
	// Etat.liste_principale));
	// } catch (VoeuNonTrouve e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}
