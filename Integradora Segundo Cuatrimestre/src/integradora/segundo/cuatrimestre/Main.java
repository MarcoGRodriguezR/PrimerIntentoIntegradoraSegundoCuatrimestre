package integradora.segundo.cuatrimestre;
//jesus

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Main {
    
    public static Inventario inv;
    
    public static void main(String[] args) {
        inv = new Inventario();
        
        // <editor-fold defaultstate="collapsed" desc="Seccion de Productos">
        inv.AgregarElemento("Productos", "Orden de burritos");
        inv.AgregarElemento(inv.Secciones.get(0), "Papapongas");
        inv.AgregarElemento(inv.Secciones.get(0), "Taco de tierra");
        inv.AgregarElemento(inv.Secciones.get(0), "Sarten vegano");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seccion de Productos">
        inv.AgregarElemento("Electronicos", "Microondas");
        inv.AgregarElemento(inv.Secciones.get(1), "Tostante");
        inv.AgregarElemento(inv.Secciones.get(1), "Frigorefri");
        inv.AgregarElemento(inv.Secciones.get(1), "Chihuahua robot");
        // </editor-fold>
        
        System.out.println(inv.Encontrar("Papapongas"));
        
        Menu menu = new Menu();
        menu.setVisible(true);   
    }
    
}
