package integradora.segundo.cuatrimestre;

import java.util.ArrayList;

public class Inventario {
    // 2025 Feb 05: Temporal, en lo que hacemos una base de datos

    /**
     * La propiedad donde se guardan los productos, el primer indice es para productos normales, el segundo para electronicos
     */
    public ArrayList<ArrayList<Producto>> inventario;
    
    public Inventario(){
        inventario = new ArrayList<>();
        
        // <editor-fold defaultstate="collapsed" desc="Productos">   
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Doritos"));
        productos.add(new Producto("Pepsi"));
        productos.add(new Producto("Coca Cola"));
        productos.add(new Producto("Ruffles"));
        productos.add(new Producto("Cheetos"));
        productos.add(new Producto("Licuado"));
        productos.add(new Producto("Taro bubble tea"));
        productos.add(new Producto("Sandwich de pollo"));
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Electronicos">
        ArrayList<Producto> electronicos = new ArrayList<>();
        electronicos.add(new Producto("Tostadora"));
        electronicos.add(new Producto("MicroOndas"));
        // </editor-fold>
        
        inventario.add(productos);
        inventario.add(electronicos);
    }
    public class Producto{
        public String Nombre;
        
        public Producto(String nombre){
            Nombre = nombre;
        }
        
        public String toString(){
            return Nombre;
        }
    }
}