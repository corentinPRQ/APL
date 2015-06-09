package pRectorat;

/**
 * Interface definition : IGestionVoeux
 * 
 * @author OpenORB Compiler
 */
public abstract class IGestionVoeuxPOA extends org.omg.PortableServer.Servant
        implements IGestionVoeuxOperations, org.omg.CORBA.portable.InvokeHandler
{
    public IGestionVoeux _this()
    {
        return IGestionVoeuxHelper.narrow(_this_object());
    }

    public IGestionVoeux _this(org.omg.CORBA.ORB orb)
    {
        return IGestionVoeuxHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:pRectorat/IGestionVoeux:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_getCatalogueUniversite")) {
                return _invoke__get_getCatalogueUniversite(_is, handler);
        } else if (opName.equals("_get_getListeAccreditations")) {
                return _invoke__get_getListeAccreditations(_is, handler);
        } else if (opName.equals("_get_getVoeux")) {
                return _invoke__get_getVoeux(_is, handler);
        } else if (opName.equals("changerPeriode")) {
                return _invoke_changerPeriode(_is, handler);
        } else if (opName.equals("consulterListeVoeu")) {
                return _invoke_consulterListeVoeu(_is, handler);
        } else if (opName.equals("faireVoeu")) {
                return _invoke_faireVoeu(_is, handler);
        } else if (opName.equals("repondreVoeu")) {
                return _invoke_repondreVoeu(_is, handler);
        } else if (opName.equals("setEtatVoeu")) {
                return _invoke_setEtatVoeu(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_getCatalogueUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Universite[] arg = getCatalogueUniversite();
        _output = handler.createReply();
        pRectorat.TabUnivHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_getListeAccreditations(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Accred[] arg = getListeAccreditations();
        _output = handler.createReply();
        pRectorat.TabAccredHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_getVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu[] arg = getVoeux();
        _output = handler.createReply();
        pRectorat.TabVoeuxHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterListeVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Etudiant arg0_in = pRectorat.EtudiantHelper.read(_is);

        pRectorat.Voeu[] _arg_result = consulterListeVoeu(arg0_in);

        _output = handler.createReply();
        pRectorat.TabVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_setEtatVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);
        pRectorat.Etat arg1_in = pRectorat.EtatHelper.read(_is);

        setEtatVoeu(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_faireVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            faireVoeu(arg0_in);

            _output = handler.createReply();

        }
        catch (pRectorat.VoeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.VoeuNonTrouveHelper.write(_output,_exception);
        }
        catch (pRectorat.EtudiantNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.EtudiantNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondreVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.DecisionEtudiant arg0_in = pRectorat.DecisionEtudiantHelper.read(_is);
        pRectorat.Voeu arg1_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            repondreVoeu(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (pRectorat.VoeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.VoeuNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_changerPeriode(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        changerPeriode(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
