package es.joseljg.examen_hamburguesa_repaso_22_23;

import java.io.Serializable;
import java.util.Objects;

public class Pedido implements Serializable {
    // atributos
    private String nombreh;
    private String nombrec;
    //------------------------------

    public Pedido(String nombreh, String nombrec) {
        this.nombreh = nombreh;
        this.nombrec = nombrec;
    }

    public Pedido() {
        this.nombreh = "Mac Pollo";
        this.nombrec = "patatas";
    }
    //------------------------------------

    public String getNombreh() {
        return nombreh;
    }

    public void setNombreh(String nombreh) {
        this.nombreh = nombreh;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }
    //-----------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(nombreh, pedido.nombreh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreh);
    }
    //---------------------------------

    @Override
    public String toString() {
        return "Pedido{" +
                "nombreh='" + nombreh + '\'' +
                ", nombrec='" + nombrec + '\'' +
                '}';
    }
}
