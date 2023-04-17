package Interfaces;

import java.util.ArrayList;
import java.util.Objects;

public interface IControlArchivo {
    /**
     * Lee el contenido de un archivo
     * @param ruta la ubicacion del archivo
     * @return el contenido del archivo en una cadena
     */
    String leerArchivo(String ruta);
}
