package pRectorat;

/** 
 * Helper class for : TabAccred
 *  
 * @author OpenORB Compiler
 */ 
public class TabAccredHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert TabAccred into an any
     * @param a an any
     * @param t TabAccred value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Accred[] t)
    {
        a.insert_Streamable(new pRectorat.TabAccredHolder(t));
    }

    /**
     * Extract TabAccred from an any
     * @param a an any
     * @return the extracted TabAccred value
     */
    public static pRectorat.Accred[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pRectorat.TabAccredHolder)
                    return ((pRectorat.TabAccredHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pRectorat.TabAccredHolder h = new pRectorat.TabAccredHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the TabAccred TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"TabAccred",orb.create_sequence_tc(0,pRectorat.AccredHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the TabAccred IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Rectorat/TabAccred:1.0";

    /**
     * Read TabAccred from a marshalled stream
     * @param istream the input stream
     * @return the readed TabAccred value
     */
    public static pRectorat.Accred[] read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.Accred[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new pRectorat.Accred[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = pRectorat.AccredHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write TabAccred into a marshalled stream
     * @param ostream the output stream
     * @param value TabAccred value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Accred[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            pRectorat.AccredHelper.write(ostream,value[i7]);

        }
    }

}
