package pRectorat;

/**
 * Struct definition : Etudiant
 * 
 * @author OpenORB Compiler
*/
public final class Etudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noEtu
     */
    public String noEtu;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Default constructor
     */
    public Etudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param noEtu noEtu struct member
     * @param nom nom struct member
     */
    public Etudiant(String noEtu, String nom)
    {
        this.noEtu = noEtu;
        this.nom = nom;
    }

<<<<<<< HEAD
	/**
	 * @return the noEtu
	 */
	public String getNoEtu() {
		return noEtu;
	}

	/**
	 * @param noEtu the noEtu to set
	 */
	public void setNoEtu(String noEtu) {
		this.noEtu = noEtu;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

    
=======
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APL.git
}
