package model.dao;

/**
 *
 * @author Alexander
 */
public class DAOFactory {
    
    private String PU = "SIACPU";

    private DAOFactory() {
    }

    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO(PU);
    }

    public EmpresaDAO getEmpresaDAO() {
        return new EmpresaDAO(PU);
    }

    public ErrorDAO getErrorDAO() {
        return new ErrorDAO(PU);
    }
    
    public VersionDAO getVersionDAO() {
        return new VersionDAO(PU);
    }

    private static DAOFactory instance;

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }
}
