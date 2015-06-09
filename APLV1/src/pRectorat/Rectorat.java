package pRectorat;

/**
 * Struct definition : Rectorat
 * 
 * @author OpenORB Compiler
*/
public final class Rectorat implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noRec
     */
    public String noRec;

    /**
     * Struct member nomAcademie
     */
    public String nomAcademie;

    /**
     * Default constructor
     */
    public Rectorat()
    { }

    /**
     * Constructor with fields initialization
     * @param noRec noRec struct member
     * @param nomAcademie nomAcademie struct member
     */
    public Rectorat(String noRec, String nomAcademie)
    {
        this.noRec = noRec;
        this.nomAcademie = nomAcademie;
    }

}
