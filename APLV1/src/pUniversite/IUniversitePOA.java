package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public abstract class IUniversitePOA extends org.omg.PortableServer.Servant
        implements IUniversiteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public IUniversite _this()
    {
        return IUniversiteHelper.narrow(_this_object());
    }

    public IUniversite _this(org.omg.CORBA.ORB orb)
    {
        return IUniversiteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:pUniversite/IUniversite:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_getCandidatures",
                    new Operation__get_getCandidatures());
            operationMap.put("ajouterListeComplementaire",
                    new Operation_ajouterListeComplementaire());
            operationMap.put("ajouterListePrincipale",
                    new Operation_ajouterListePrincipale());
            operationMap.put("ajouterListeRejet",
                    new Operation_ajouterListeRejet());
            operationMap.put("enregistrerAnnuaire",
                    new Operation_enregistrerAnnuaire());
            operationMap.put("enregistrerEtatCandidature",
                    new Operation_enregistrerEtatCandidature());
            operationMap.put("getListePrerequis",
                    new Operation_getListePrerequis());
            operationMap.put("getNotes",
                    new Operation_getNotes());
            operationMap.put("identifier",
                    new Operation_identifier());
            operationMap.put("majListes",
                    new Operation_majListes());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_getCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg = getCandidatures();
        _output = handler.createReply();
        pRectorat.VoeuHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListePrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        pRectorat.Diplome[] _arg_result = getListePrerequis(arg0_in);

        _output = handler.createReply();
        pUniversite.listePrerequisHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_identifier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            boolean _arg_result = identifier(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (pUniversite.universitaireNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pUniversite.universitaireNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerEtatCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);
        pRectorat.Etat arg1_in = pRectorat.EtatHelper.read(_is);

        try
        {
            enregistrerEtatCandidature(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (pUniversite.voeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pUniversite.voeuNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterListePrincipale(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            ajouterListePrincipale(arg0_in);

            _output = handler.createReply();

        }
        catch (pUniversite.voeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pUniversite.voeuNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterListeComplementaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            ajouterListeComplementaire(arg0_in);

            _output = handler.createReply();

        }
        catch (pUniversite.voeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pUniversite.voeuNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterListeRejet(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            ajouterListeRejet(arg0_in);

            _output = handler.createReply();

        }
        catch (pUniversite.voeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pUniversite.voeuNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majListes(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        majListes();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getNotes(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Etudiant arg0_in = pRectorat.EtudiantHelper.read(_is);

        try
        {
            pUniversite.Note[] _arg_result = getNotes(arg0_in);

            _output = handler.createReply();
            pUniversite.listeNotesHelper.write(_output,_arg_result);

        }
        catch (pRectorat.EtudiantNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.EtudiantNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerAnnuaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        enregistrerAnnuaire(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                IUniversitePOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_getCandidatures extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_getCandidatures(_is, handler);
        }
    }

    private static final class Operation_getListePrerequis extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getListePrerequis(_is, handler);
        }
    }

    private static final class Operation_identifier extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_identifier(_is, handler);
        }
    }

    private static final class Operation_enregistrerEtatCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerEtatCandidature(_is, handler);
        }
    }

    private static final class Operation_ajouterListePrincipale extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterListePrincipale(_is, handler);
        }
    }

    private static final class Operation_ajouterListeComplementaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterListeComplementaire(_is, handler);
        }
    }

    private static final class Operation_ajouterListeRejet extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterListeRejet(_is, handler);
        }
    }

    private static final class Operation_majListes extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_majListes(_is, handler);
        }
    }

    private static final class Operation_getNotes extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getNotes(_is, handler);
        }
    }

    private static final class Operation_enregistrerAnnuaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IUniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerAnnuaire(_is, handler);
        }
    }

}
