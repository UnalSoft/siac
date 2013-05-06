package model.entity;

/**
 *
 * @author Alexander
 */
public enum Rol {
    
    PROVEEDOR_DE_TI("1111", "Proveedor de TI"),
    PRIMER_ADMINISTRADOR("1110", "Primer Administrador"),
    ADMINISTRADOR("1101", "Administrador"),
    CONSULTA("1100", "Consulta"),
    OTRO("1001", "Otro");
    
    private final String id;
    private final String label;
    
    private Rol (final String id, final String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
    
}
