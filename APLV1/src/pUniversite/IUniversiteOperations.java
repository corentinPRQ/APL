package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public interface IUniversiteOperations
{
    /**
     * Read accessor for getCandidatures attribute
     * @return the attribute value
     */
    public pRectorat.Voeu getCandidatures();

    /**
     * Operation getListePrerequis
     */
    public pRectorat.Diplome[] getListePrerequis(String dip);

    /**
     * Operation identifier
     */
    public boolean identifier(String login, String mdp)
        throws pUniversite.universitaireNonTrouve;

    /**
     * Operation enregistrerEtatCandidature
     */
    public void enregistrerEtatCandidature(pRectorat.Voeu c, pRectorat.Etat e)
        throws pUniversite.voeuNonTrouve;

    /**
     * Operation ajouterListePrincipale
     */
    public void ajouterListePrincipale(pRectorat.Voeu c)
        throws pUniversite.voeuNonTrouve;

    /**
     * Operation ajouterListeComplementaire
     */
    public void ajouterListeComplementaire(pRectorat.Voeu c)
        throws pUniversite.voeuNonTrouve;

    /**
     * Operation ajouterListeRejet
     */
    public void ajouterListeRejet(pRectorat.Voeu c)
        throws pUniversite.voeuNonTrouve;

    /**
     * Operation majListes
     */
    public void majListes();

    /**
     * Operation getNotes
     */
    public pUniversite.Note[] getNotes(pRectorat.Etudiant idE)
        throws pRectorat.EtudiantNonTrouve;

    /**
     * Operation enregistrerAnnuaire
     */
    public void enregistrerAnnuaire(String ior);

}
