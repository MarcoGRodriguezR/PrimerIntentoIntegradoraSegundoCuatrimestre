package integradora.segundo.cuatrimestre;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.*;


import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Inventario{
    // TO DO: Electronicos, capacitores y resistencias
    
    /**
     * Las secciones del inventario, es basciamente lo mismo que Inventario.Keys() en teoria, pero mas facil de llamar
     */
    public ArrayList<String> Secciones = new ArrayList<>() {{
        add("Productos");
        add("Electronicos");
    }};
    
    /**
     * Todos los productos, checha la clase Elemento para saber que propiedades tiene
     */
    public Dictionary<String, ArrayList<Elemento>> Inventario = new Hashtable<String, ArrayList<Elemento>>() {{
        put("Productos", new ArrayList<Elemento>());
        put("Electronicos", new ArrayList<Elemento>());
        //etc
    }};

    // <editor-fold defaultstate="collapsed" desc="Agregar Elemetos">
    /**
     * Agrega un elemento/producto/electronico a Inventario
     * @param seccion El nombre de la seccion del elemento (productos, electronicos, etc.)
     * @param nombre El nombre del producto
     */
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
    
    /**
     * Agrega una seccion a Inventario y crea un arreglo vacio en ese espacio
     * @param seccion Nombre de la seccion 
     */
    public void AgregarSeccion(String seccion){
        Secciones.add(seccion);
        Inventario.put(seccion, new ArrayList<>());
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Encontrar tal">
    /**
     * Utilizado para encontrar elementos en el inventario
     * @param seccion El nombre de la seccion donde buscar el elemento
     * @param nombre El nombre del elemento
     * @return Devuelve el primer elemento encontrado con el mismo nombre
     */
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
    
    /**
     * Utilizado para encontrar elementos en el inventario
     * @param nombre El nombre del elemento
     * @return Devuelve el primer elemento encontrado con el mismo nombre de la primera seccion donde este
     */
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

    // <editor-fold defaultstate="collapsed" desc="Encontrar tal">
    public void EliminarElemento(String seccion, String nombre){
        try {
            for (int i = 0; i < Inventario.get(seccion).size(); i++){
                if (Inventario.get(seccion).get(i).Nombre == nombre){
                    Inventario.get(seccion).remove(i);
                }
            }
        } catch (Exception e) {            
            System.out.println("Hubo un error al intentar eliminar: " + nombre + "en la seccion " + seccion);
            showMessageDialog(null, "Hubo un error al intentar eliminar " + nombre + "en la seccion " + seccion, "Error", ERROR_MESSAGE);
        }
    }
        
    // </editor-fold>
    
    /**
     * La clase base de donde se basaran productos y electronicos
     */
    public class Elemento{
        public String Nombre;
        
        /**
         * Unidades en existencia
         */
        public int Unidades;
        
        public Dictionary<String, Object> Propiedades = new Hashtable<String, Object>(){{
            put("Unidades", 0);
            put("Ventas", 0);
        }};
        
        
        public Elemento(String nombre) {
            Nombre = nombre;
            
            Random rng = new Random(); // 8
            Propiedades.put("Ventas", (int)(rng.nextFloat() * 100));
        }
        public Elemento(String nombre, int unidades) {
            Nombre = nombre;
            Propiedades.put("Unidades", unidades);
            
            Random rng = new Random(); // 8
            Propiedades.put("Ventas", (int)(rng.nextFloat() * 100));
        }
        
        /**
         * Utilizado para poner su informacion en textos
         * @return Devuelve un texto que contiene toda la informacion sobre este elemento
         */
        public String toString() { 
            String texto = "Nombre del producto: " + Nombre;
            
            Enumeration<String> llaves = Propiedades.keys();
            for (int i = 0; i < Propiedades.size(); i++){
                String propiedad = llaves.nextElement();
                texto += "\n" + propiedad + ": " + Propiedades.get(propiedad);
            }

            texto += "\n" + toStringExtras();
                
            return texto;
        } 
        public String toStringExtras(){
            return "";      
        }
        
        /**
         * Reiniciara todos los valores, excepto nombre
         */
        public void ReiniciarValores(){
            Random rng = new Random();
            
            Unidades = 0;
        }
    }
}
