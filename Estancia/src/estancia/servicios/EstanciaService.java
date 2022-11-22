
package estancia.servicios;

import estancia.entidades.Estancia;
import estancia.persistencia.EstanciaDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class EstanciaService {
    
    EstanciaDAO ed = new EstanciaDAO();
    Scanner read = new Scanner(System.in);
    
//Muestra la consulta F
    public void showqueryF() throws Exception{
        System.out.println("\nEstancias que han sido reservadas por un cliente y la descripción de la casa");
        System.out.println("_________________________________________________________________________________________________________");
        System.out.printf("|%-13s|%-7s|%-26s|%-13s|%-13s|%-13s|%-13s|\n", "ESTANCIA", "CASA", "HUESPED", "CIUDAD", "PAIS", "FECHA DESDE", "FECHA HASTA", "");
        for (Estancia aux : ed.queryF()) {
            System.out.printf("|%-13s|%-7s|%-26s|%-13s|%-13s|%-13s|%-13s|\n",
                             aux.getId_estancia(), aux.getId_casa(), aux.getNombre_huesped(), aux.getCiudad(), aux.getPais(), aux.getFecha_desde(), aux.getFecha_hasta(), "");
        }
        System.out.println("_________________________________________________________________________________________________________");
    }   
    
//Verifica y muestra la consulta J
    public void showqueryJ() throws Exception{
        
    //Pide los datos al usuario
        System.out.println("ingrese el ID de la casa");
        int casa = read.nextInt();        
        System.out.println("ingrese el nombre del huesped");
        String a = read.next();
        String b = read.next();
        String huesped = a.concat(" ").concat(b);
        System.out.println(huesped);
        System.out.println("ingrese la fecha yyyy-MM-dd");
        String desde = read.next();
        System.out.println("ingrese la cantidad de días");
        int dias = read.nextInt();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date desdeDate = sdf.parse(desde);  	
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(desdeDate);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        String hasta = sdf.format(calendar.getTime());
        
    //Verifica la disponibilidad    
        boolean equals = true;
        Iterator<Estancia> it = ed.queryJ0(desde, hasta).iterator();
            while(it.hasNext() && equals){
                Estancia aux = it.next();
                if (aux.getId_casa() == casa ) {
                equals = false;
            }
        }

        if (equals) {
        //Carga la nueva estancia 
            ed.updateJ(casa, huesped, desde, hasta);
        //Muestra la nueva estancia 
            System.out.println("__________________________________________________________________________________");
            System.out.printf("|%-13s|%-13s|%-7s|%-26s|%-13s|%-13s|\n", "ESTANCIA", "CLIENTE", "CASA", "HUESPED", "FECHA DESDE", "FECHA HASTA", "");
            System.out.printf("|%-13s|%-13s|%-7s|%-26s|%-13s|%-13s|\n", ed.queryJ().getId_estancia(), ed.queryJ().getId_cliente(), ed.queryJ().getId_casa(), ed.queryJ().getNombre_huesped(), ed.queryJ().getFecha_desde(), ed.queryJ().getFecha_hasta(), "");
            System.out.println("__________________________________________________________________________________");
        } else{
            System.out.println("La casa " + casa + " no esta disponible entre el " + desde + " y el " + hasta);    
        }
    }
}