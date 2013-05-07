package model.entity;

/**
 *
 * @author Alexander
 */
public enum Nivel {

    ADMINISTRADORA("Administradora"),
    DISTRIBUIDORA("Distribuidora"),
    SUB_DISTRIBUIDORA("Sub Distribuidora"),
    CANAL("Canal"),
    PUNTO_DE_VENTA("Punto de Venta");
    
    private final String text;

    private Nivel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Nivel fromText(String text) throws IllegalArgumentException {
        for (Nivel e : values()) {
            if (e.text.equalsIgnoreCase(text)) {
                return e;
            }
        }
        throw new IllegalArgumentException(String.format("El Nivel con texto %s no existe", text));
    }
}
