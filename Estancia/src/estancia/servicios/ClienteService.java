
package estancia.servicios;

import estancia.entidades.Cliente;
import estancia.persistencia.ClienteDAO;

/**
 *
 * @author Damian
 */
public class ClienteService {
    
    ClienteDAO cd = new ClienteDAO();
    
//Se encarga de mostrar las consultas    
    public void showqueryE() throws Exception{
        System.out.println("\nClientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron");
        System.out.println("___________________________________________________________________________________________________________________________________________________");
        System.out.printf("|%-7s|%-7s|%-26s|%-26s|%-7s|%-13s|%-13s|%-13s|%-26s|\n", "CLIENTE", "CASA", "NOMBRE", "CALLE", "N°", "C.P.", "CIUDAD", "PAIS", "EMAIL", "");
        for (Cliente aux : cd.queryE()) {
            System.out.printf("|%-7s|%-7s|%-26s|%-26s|%-7s|%-13s|%-13s|%-13s|%-26s|\n",
                             aux.getId(), aux.getId_casa(), aux.getNombre(), aux.getCalle(), aux.getNumero(), aux.getCodigo_postal(), aux.getCiudad(), aux.getPais(), aux.getEmail(), "");
        }
        System.out.println("___________________________________________________________________________________________________________________________________________________");
    }
 
}
