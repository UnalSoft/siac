package model.service;

/**
 *
 * @author Zergio
 */
public class ServiceFactory {

    private ServiceFactory() {
    }
    private static ServiceFactory instance;

    public static synchronized ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }
    
    //TODO Actualizar conforme se agreguen nuevos servicios al modelo

    public UsuarioService getUsuarioService() {
        return UsuarioService.getInstance();
    }
    
}
