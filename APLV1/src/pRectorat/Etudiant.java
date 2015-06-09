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

}
