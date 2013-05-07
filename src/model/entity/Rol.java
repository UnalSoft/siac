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

    private Rol(final String id, final String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Rol fromId(String id) throws IllegalArgumentException {
        for (Rol e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("Gender with id %s doesn't exists", id));
    }

    public static Rol fromLabel(String label) throws IllegalArgumentException {
        for (Rol e : values()) {
            if (e.label.equalsIgnoreCase(label)) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("Gender with label %s doesn't exists", label));
    }
}
