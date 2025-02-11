package integradora.segundo.cuatrimestre;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import java.util.ArrayList;


public class Inventario {
    // 2025 Feb 05: Temporal, en lo que hacemos una base de datos

    public static ArrayList<String> ObtenerSecciones(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Productos");
        lista.add("Electronicos");
        return lista;
    }
    
    /**
     * La propiedad donde se guardan los productos, el primer indice es para productos normales, el segundo para electronicos
     */
    
    public Dictionary<String, ArrayList<String>> inventario = new Hashtable<>();
;
    
    
    public Inventario(){
        Creacion();
    }
    private void Creacion(){
        // 2025 Feb 11: lo dejare aqui por ahora, ya luego lo pongo en menu inventario
        
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Orden de burritos");
        lista.add("Chicken bake");
        lista.add("anborgesas");
        
        inventario.put(ObtenerSecciones().get(0), lista);
        
        lista = new ArrayList<>();
        lista.add("Bombona");
        lista.add("Tostadora");
        lista.add("Refri");
        
        inventario.put(ObtenerSecciones().get(1), lista);
        
        System.out.println(inventario.get(ObtenerSecciones().get(0)));
        System.out.println(inventario.get(ObtenerSecciones().get(1)));
    }
    
    public  ArrayList<String> ObtenerElementosEnSeccion(String seccion){
        try {
            return inventario.get(seccion);
        } catch (Exception e) {
            return null;
        }
    }
    
    /*
    public class Producto{
        public String Nombre;
        
        public Producto(String nombre){
            Nombre = nombre;
        }
        
        public String toString(){
            return Nombre;
        }
    }
    */
}