package integradora.segundo.cuatrimestre;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Inventario{
    public ArrayList<String> Secciones = new ArrayList<>();
    public Dictionary<String, ArrayList<Elemento>> Inventario = new Hashtable<>();

    // <editor-fold defaultstate="collapsed" desc="Seccion de Productos">
    public void AgregarElemento(String seccion, String nombre){
        try {
            Inventario.get(seccion).add(new Elemento(nombre));
        } catch (Exception e) {
            ArrayList<Elemento> lista = new ArrayList<>();
            lista.add(new Elemento(nombre));
            
            Inventario.put(seccion, lista);
            Secciones.add(seccion);
        }
    }
    public void AgregarSeccion(String seccion){
        Secciones.add(seccion);
        Inventario.put(seccion, new ArrayList<>());
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Seccion de Productos">
    public Elemento Encontrar(String seccion, String nombre){
        
        try {
            for (Elemento elemento: Inventario.get(seccion)){
            if (elemento.Nombre == nombre) return elemento;
            }
        } catch (Exception e) {            
            System.out.println("Hubo un error al intentar acceder: " + nombre + "en la seccion " + seccion);
            showMessageDialog(null, "Hubo un error al intentar acceder " + nombre + "en la seccion " + seccion, "Error", ERROR_MESSAGE);
        }
        
        return null;
    }
    
    public Elemento Encontrar(String nombre){
        
        try {
            for (String seccion: Secciones){
                for (Elemento elemento: Inventario.get(seccion)){
                if (elemento.Nombre == nombre) return elemento;
                }
            }
        } catch (Exception e) {            
            System.out.println("Hubo un error al intentar acceder: " + nombre);
            showMessageDialog(null, "Hubo un error al intentar acceder " + nombre, "Error", ERROR_MESSAGE);
        }
        
        return null;
    }
    // </editor-fold>

    public class Elemento{
        public String Nombre;
        public int Unidades;
        
        public Elemento(String nombre) {
            Nombre = nombre;
        }
        
        public String toString() { return "Nombre del producto: " + Nombre + 
                "\nUnidades: " + Unidades; } 
    }
}

//
//public class Inventario {
//    // 2025 Feb 05: Temporal, en lo que hacemos una base de datos
//    
//    /**
//     * La propiedad donde se guardan los productos, el primer indice es para productos normales, el segundo para electronicos
//     */
//    public Dictionary<String, ArrayList<String>> inventario = new Hashtable<>();
//    
//    public ArrayList<String> ObtenerSecciones(){
//        ArrayList<String> lista = new ArrayList<>();
//        lista.add("Productos");
//        lista.add("Electronicos");
//        return lista;
//    }
//    
//    private int guh = 0;
//    public void Prueba(){
//        guh++;
//        System.out.println("Guh: " + guh);
//    }
//
//    public Inventario(){
//        Creacion();
//    }
//    private void Creacion(){
//        // 2025 Feb 11: lo dejare aqui por ahora, ya luego lo pongo en menu inventario
//        
//        ArrayList<String> lista = new ArrayList<>();
//        lista.add("Orden de burritos");
//        lista.add("Chicken bake");
//        lista.add("anborgesas");
//        
//        inventario.put(ObtenerSecciones().get(0), lista);
//        
//        lista = new ArrayList<>();
//        lista.add("Bombona");
//        lista.add("Tostadora");
//        lista.add("Refri");
//        
//        inventario.put(ObtenerSecciones().get(1), lista);
//        
//        System.out.println(inventario.get(ObtenerSecciones().get(0)));
//        System.out.println(inventario.get(ObtenerSecciones().get(1)));
//    }
//    
//    public  ArrayList<String> ObtenerElementosEnSeccion(String seccion){
//        try {
//            return inventario.get(seccion);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//    
//    /*
//    public class Producto{
//        public String Nombre;
//        
//        public Producto(String nombre){
//            Nombre = nombre;
//        }
//        
//        public String toString(){
//            return Nombre;
//        }
//    }
//    */
//}