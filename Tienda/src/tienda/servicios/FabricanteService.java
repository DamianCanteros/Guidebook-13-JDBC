
package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class FabricanteService {
    
    FabricanteDAO fd = new FabricanteDAO();
    Scanner read = new Scanner(System.in);
    
//Carga un producto a la base de datos
    public void createManufacture() throws Exception{
       
        String answer = "Y";
        do {
            System.out.println("ingrese el codigo del fabricante");
            int codigo = read.nextInt();
            System.out.println("ingrese el nombre del fabricante");
            String nombre = read.next();

            Fabricante f = new Fabricante(codigo,nombre);
            
            System.out.println("Do you want enter another product? Y/N");
            answer = read.next();
            
            fd.queryG(f);
            
        } while (answer.equalsIgnoreCase("Y"));
    }
}
