package Controlers;

import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Regalo;
import java.util.ArrayList;

public class ControlRegalo {
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Producto> productos;
    private ArrayList<Regalo> regalos;
    private ControlArchivoJson controlArchivoJson;


    public ControlRegalo(String rutaArchivoProveedores, String rutaArchivoProductos) {
        this.controlArchivoJson = new ControlArchivoJson();
        this.regalos = new ArrayList<>();
        this.proveedores =  controlArchivoJson.ObtenerInforcionEnObjetosDeArchivoProveedores(rutaArchivoProveedores);
        this.productos = controlArchivoJson.ObtenerInforcionEnObjetosDeArchivoProductos(rutaArchivoProductos);
        this.crearRegalos();
    }

    private ArrayList<Regalo> buscarRegalosPorCriterios(int edadPersona, double precioMaximo){
        ArrayList<Regalo> resultado = new ArrayList<>();
        for (Regalo regalo: this.regalos) {
            Producto productoRegalo = obtenerProductoPorNombre(regalo.getNombre());
            if(productoRegalo.getEdad() == edadPersona && regalo.getPrecioTotal() <= precioMaximo)
                resultado.add(regalo);
        }
        return resultado;
    }
    private void crearRegalos(){
        Regalo regalo = null;
        for (Producto producto : this.productos){
            Proveedor proveedor = obtenerProveedorPorNombre(producto.getProveedor());
            if(proveedor != null){
                regalo = new Regalo(producto.getNombre(),producto.getPrecio(),proveedor.getPrecioEnvio());
                this.regalos.add(regalo);
            }
        }
    }
    private Proveedor obtenerProveedorPorNombre(String nombre){
        for (Proveedor proveedor: this.proveedores) {
            if(proveedor.getNombre().equalsIgnoreCase(nombre))
                return proveedor;
        }
        return null;
    }
    private Producto obtenerProductoPorNombre(String nombre){
        for (Producto producto: this.productos) {
            if(producto.getNombre().equalsIgnoreCase(nombre))
                return producto;
        }
        return null;
    }
    public void mostrarRegalosPorCriterios(int edadPersona, double precioMaximo){
        ArrayList<Regalo> resultado = buscarRegalosPorCriterios(edadPersona,precioMaximo);
        if(resultado.size() <= 0) {
            System.out.println("No se tiene productos para esa edad o precio");
        }
        for (Regalo regalo: resultado) {
            System.out.println(regalo.toString());
        }
    }
}
