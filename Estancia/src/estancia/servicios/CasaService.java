
package estancia.servicios;

import estancia.entidades.Casa;
import estancia.persistencia.CasaDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class CasaService {
    
    CasaDAO cd = new CasaDAO();
    Scanner read = new Scanner(System.in);
    
//Se encarga de mostrar las consultas    
    public void showquery(ArrayList<Casa> casas) throws Exception{
        
        System.out.println("______________________________________________________________________________________________________________________________________");
        System.out.printf("|%-3s|%-13s|%-7s|%-7s|%-13s|%-13s|%-13s|%-13s|%-13s|%-13s|%-7s|%-7s|%-13s\n", "ID", "CALLE", "N°", "C.P.", "CIUDAD", "PAIS", 
                        "FECHA DESDE","FECHA HASTA","TIEMPO MIN","TIEMPO MAX","PRECIO","TIPO", "");
        for (Casa aux : casas) {
            System.out.printf("|%-3s|%-13s|%-7s|%-7s|%-13s|%-13s|%-13s|%-13s|%-13s|%-13s|%-7s|%-7s|%-13s\n",
                             aux.getId_casa(), aux.getCalle(), aux.getNumero(), aux.getCodigo_postal(), aux.getCiudad(), aux.getPais(),
                             aux.getFecha_desde(), aux.getFecha_hasta(), aux.getTiempo_minimo(), aux.getTiempo_maximo(), aux.getPrecio_habitacion(), aux.getTipo_vivienda(), "");
        }
        System.out.println("______________________________________________________________________________________________________________________________________");
    }

//Muestra la consulta B
    public void showqueryB() throws Exception{
        
        showquery(cd.queryB());
    }

//Muestra la consulta D
    public void showqueryD() throws Exception{
        
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
        
        showquery(cd.queryD(desde,hasta));
    }
    
//Muestra la consulta G
    public void showqueryG() throws Exception{
        
        showquery(cd.updateG());
    }
    
//Muestra la consulta H
    public void showqueryH() throws Exception{
        int i = 0;
        for (Casa aux : cd.queryH2()) {
            System.out.println(aux.getPais() + " " + cd.queryH().get(i));
            i++;
        }
    }
    
//Muestra la consulta I
    public void showqueryI() throws Exception{
        
        showquery(cd.queryI());
    }
    
    //Muestra la consulta F
    public void showqueryEF() throws Exception{
                
        System.out.println("______________________________________________________________________________________________");
        System.out.printf("|%-7s|%-13s|%-7s|%-7s|%-13s|%-13s|%-13s|%-13s|%-13s\n", "CASA", "CALLE", "N°", "C.P.", "CIUDAD", "PAIS", "PRECIO", "TIPO", "");
        for (Casa aux : cd.queryEF()) {
            System.out.printf("|%-7s|%-13s|%-7s|%-7s|%-13s|%-13s|%-13s|%-13s|%-13s\n",
                             aux.getId_casa(), aux.getCalle(), aux.getNumero(), aux.getCodigo_postal(), aux.getCiudad(), aux.getPais(), aux.getPrecio_habitacion(), aux.getTipo_vivienda(), "");
        }
        System.out.println("______________________________________________________________________________________________");
    }   
}
