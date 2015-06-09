package Applications;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import ClientsServeurs.ClientGestionVoeuxMinistere;

public class ApplicationGestionEtudiant {
	public static int noEtu = 0;
	private static int idEtdu;

//	public ApplicationGestionEtudiant(String login){
//		String[] arguments = new String[2];
//		arguments[0]=login;
//		main(arguments);
//	}
	
	
	public static void main(String[] args) {
		try {
			noEtu++;
			idEtdu = noEtu; 
			// TODO Auto-generated method stub
			// Intialisation de l'ORB
			//************************
			//Il faut le faire qu'une fois!!!!!!
			System.out.println("init de l'orb");
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Enregistrement dans le service de nommage
			//*******************************************
			// Recuperation du naming service
			System.out.println("Recuperation du naming service");
			NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");
			//Cas d'une connexion avec un Ministere : 
			String idObj = "Midi-Pyrenees_GestionVoeux";
			// Construction du nom a enregistrer
			String nomOb = "ClientEtudiantGV";

			System.out.println("lancement du client Etudiant");
			ClientGestionVoeuxMinistere cu = new ClientGestionVoeuxMinistere(orb, nameRoot, nomOb, idObj);

			Thread tcli = new Thread(cu);
			tcli.start();


		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	}
//	System.out.println("1 : Faire un voeux");
//	System.out.println("2 : Consulter liste de voeux");
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	choix = in.read();
//	String idEtu = "123";
//	
//	switch(choix){
//	case 1:
//		Voeu voeu = new Voeu(new idVoeu("1", new idEtudiant("123", "Roig"),  new Accred("1", new idDiplome("1", "MasterMIAGE"), new idUniversite("1", "PS"))), new idRectorat("1", "MP"), DecisionEtudiant.oui, Etat.cree);
//		ClientGestionVoeux.monGV.faireVoeu(idEtu, new Accred("1", new idDiplome("1", "MasterMIAGE"), new idUniversite("1", "PS")), voeu);
//		if (!listeDeVoeux.containsKey(idEtu)){
//			listeDeVoeux.put(idEtu, new ArrayList<Voeu>());
//		}				
//		listeDeVoeux.get(idEtu).add(voeu);
//		System.out.println("Liste de voeu : " + listeDeVoeux.get(idEtu));
//		break;
//	case 2: 
//		System.out.println(listeDeVoeux.get(idEtu));
//		break;
//	case 9 : 
//		break;
//
//		
//	}
//}
