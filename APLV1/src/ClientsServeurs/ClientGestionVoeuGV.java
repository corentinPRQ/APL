package ClientsServeurs;

import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CosNaming.NamingContext;

import pRectorat.IGestionVoeux;
import pRectorat.Voeu;
import pUniversite.IUniversite;

public class ClientGestionVoeuGV implements Runnable{


//	public static IGestionVoeux monGV;
	public static IGestionVoeux monGV;
	
	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private String idObj;
	private HashMap<String, ArrayList<Voeu>> listeDeVoeux;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
