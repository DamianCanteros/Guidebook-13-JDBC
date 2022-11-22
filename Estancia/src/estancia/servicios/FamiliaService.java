
package estancia.servicios;

import estancia.entidades.Familia;
import estancia.persistencia.FamiliaDAO;
import java.util.ArrayList;

/**
 *
 * @author Damian
 */
public class FamiliaService {
    
    FamiliaDAO fd = new FamiliaDAO();
        
//Se encarga de mostrar las consultas    
    public void showquery(ArrayList<Familia> familias) throws Exception{
        
        System.out.println("___________________________________________________________________________________________");
        System.out.printf("|%-7s|%-13s|%-13s|%-13s|%-13s|%-26s|%-13s\n", "ID", "NOMBRE", "EDAD MINIMA", "EDAD MAXIMA", "NUM HIJOS", "EMAIL","");
        for (Familia aux : familias) {
            System.out.printf("|%-7s|%-13s|%-13s|%-13s|%-13s|%-26s|%-13s\n",
                             aux.getId(), aux.getNombre(), aux.getEdad_minima(), aux.getEdad_maxima(), aux.getNum_hijos(), aux.getEmail(), "");
        }
        System.out.println("___________________________________________________________________________________________");
    }

//Muestra la consulta A
    public void showqueryA() throws Exception{
        
        showquery(fd.queryA());
    }
    
//Muestra la consulta C
    public void showqueryC() throws Exception{
        
        showquery(fd.queryC());
    }
}
