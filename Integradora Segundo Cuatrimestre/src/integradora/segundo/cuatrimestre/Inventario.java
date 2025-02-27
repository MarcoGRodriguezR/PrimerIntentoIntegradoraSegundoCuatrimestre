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
    }    /**
     * Agrega un elemento/producto/electronico a Inventario
     * @param seccion El nombre de la seccion del elemento (productos, electronicos, etc.)
     * @param nombre El nombre del producto
     * @param unidades Las unidades inciales
     */
    public void AgregarElemento(String seccion, String nombre, int unidades){
        try {
            Inventario.get(seccion).add(new Elemento(nombre, unidades));
        } catch (Exception e) {
            ArrayList<Elemento> lista = new ArrayList<>();
            lista.add(new Elemento(nombre, unidades));
            
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
        
        /**
         * Propiedades que va a tener este elemento, por defecto tiene "Unidades y Ventas"
         * Es un diccionario de strings y objetos, la llave debe ser el nombre de la propiedad y el valor, el valor
         */
        public Dictionary<String, Object> Propiedades = new Hashtable<String, Object>(){{
            put("Unidades", 0);
            put("Ventas", 0);
        }};
        
        // <editor-fold defaultstate="collapsed" desc="ModificarPropiedad">
        /**
         * Utilizado para modificar propiedades de tipo int en este elemento, tengo que hacer esta estupidez por que java devuelve el valor y no la referencia con propiedad.get()
         * @param propiedad El nombre de la propiedad
         * @param valor El numero de la unidad a cambiar
         */
        public void ModificarPropiedad(String propiedad, int valor){
            try {
                Propiedades.put(propiedad, (int)Propiedades.get(propiedad) + valor);
            } catch (Exception e) {
                System.out.println("No existe la propiedad \"" + propiedad + "\", creando propiedad con ese nombre");
                Propiedades.put(propiedad, valor);
            }
        }
        // </editor-fold>
        
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
            
            // <editor-fold defaultstate="collapsed" desc="Conseguir las llaves por que POR ALGUNA BENDITA RAZON TENGO QUE HACER ESTA BABOSADA para tenerlas en orden">
            Enumeration<String> llaves = Propiedades.keys();
            
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < Propiedades.size(); i++) lista.add(llaves.nextElement());
            var listaBIEN = lista.reversed();
            // </editor-fold>
            
            for (int i = 0; i < Propiedades.size(); i++){
                texto += "\n" + listaBIEN.get(i) + ": " + Propiedades.get(listaBIEN.get(i));
            }

            texto += "\n" + toStringExtras();
                
            return texto;
        } 
        
        /**
         * Utilizado para agregar texto al final del metodo de "toString"
         */
        public String toStringExtras(){
            return "";      
        }
        
        public void ReiniciarUnidades(){
            Random rng = new Random();
            
            Propiedades.put("Unidades", 0);
        }
    }
}
