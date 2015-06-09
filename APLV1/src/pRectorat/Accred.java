package pRectorat;

/**
 * Struct definition : Accred
 * 
 * @author OpenORB Compiler
*/
public final class Accred implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noAccred
     */
    public String noAccred;

    /**
     * Struct member noD
     */
    public String noD;

    /**
     * Struct member noUniv
     */
    public String noUniv;

    /**
     * Default constructor
     */
    public Accred()
    { }

    /**
     * Constructor with fields initialization
     * @param noAccred noAccred struct member
     * @param noD noD struct member
     * @param noUniv noUniv struct member
     */
    public Accred(String noAccred, String noD, String noUniv)
    {
        this.noAccred = noAccred;
        this.noD = noD;
        this.noUniv = noUniv;
    }

}
