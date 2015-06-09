package pRectorat;

/**
 * Struct definition : Diplome
 * 
 * @author OpenORB Compiler
*/
public final class Diplome implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noDiplome
     */
    public String noDiplome;

    /**
     * Struct member libelle
     */
    public String libelle;

    /**
     * Struct member niveau
     */
    public pRectorat.NiveauEtude niveau;

    /**
     * Default constructor
     */
    public Diplome()
    { }

    /**
     * Constructor with fields initialization
     * @param noDiplome noDiplome struct member
     * @param libelle libelle struct member
     * @param niveau niveau struct member
     */
    public Diplome(String noDiplome, String libelle, pRectorat.NiveauEtude niveau)
    {
        this.noDiplome = noDiplome;
        this.libelle = libelle;
        this.niveau = niveau;
    }

}
