package Entidades;

public class Regalo {
    private String nombre;
    private double precioBase;
    private double precioEnvio;
    private double precioTotal;

    public Regalo(String nombre, double precioBase, double precioEnvio) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.precioEnvio = precioEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public double getPrecioTotal() {
        this.precioTotal =(this.precioBase + this.precioEnvio);
        return precioTotal;
    }

    @Override
    public String toString() {
        return  nombre + " - " +
                " precioBase: $" + precioBase +
                " - precioEnvio $" + precioEnvio +
                " - precioTotal $" + precioTotal;
    }
}
