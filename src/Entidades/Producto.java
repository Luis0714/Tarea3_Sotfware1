package Entidades;

public class Producto extends Object {
    private String nombre;
    private int edad;
    private double precio;
    private String proveedor;

    public Producto(String nombre, int edadRecomendada, double precioBase, String proveedor) {
        this.nombre = nombre;
        this.edad = edadRecomendada;
        this.precio = precioBase;
        this.proveedor = proveedor;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
