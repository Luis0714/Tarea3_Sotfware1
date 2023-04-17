package Controlers;

import Entidades.Producto;
import Entidades.Proveedor;
import Interfaces.IControlArchivo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ControlArchivoJson implements IControlArchivo {
    Gson gson;
    public ControlArchivoJson() {
        gson = new Gson();
    }

    @Override
    public String leerArchivo(String ruta) {
        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido += linea;
            }
            br.close();
        }catch (Exception e){
            System.out.println("Error al leer el archivo en "+ ruta+" Error: "+e);
        }
        return contenido;
    }

    public ArrayList<Proveedor> ObtenerInforcionEnObjetosDeArchivoProveedores(String ruta){
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            String contenido = leerArchivo(ruta);
            proveedores = gson.fromJson(contenido, new TypeToken<ArrayList<Proveedor>>(){}.getType());
        }catch (Exception e){
            System.out.println("Error al decodificar Contenido del Archivo Error: "+e);
        }
        return proveedores;
    }
    public ArrayList<Producto> ObtenerInforcionEnObjetosDeArchivoProductos(String ruta){
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            String contenido = leerArchivo(ruta);
            Gson gson = new Gson();
            productos = gson.fromJson(contenido, new TypeToken<ArrayList<Producto>>(){}.getType());
        }catch (Exception e){
            System.out.println("Error al decodificar Contenido del Archivo Error: "+e);
        }
        return productos;
    }
}
