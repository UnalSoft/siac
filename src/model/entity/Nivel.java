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
    
    private Nivel (String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
}
