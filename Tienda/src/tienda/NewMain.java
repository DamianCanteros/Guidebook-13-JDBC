
package tienda;

import tienda.servicios.FabricanteService;
import tienda.servicios.ProductoService;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class NewMain {

    public static void main(String[] args) throws Exception {
        
        ProductoService ps =new ProductoService();
        FabricanteService fs =new FabricanteService();
        Scanner read = new Scanner(System.in);
        
        int answer;
        
        do {
            System.out.println("\n============= STORE =============\n");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("1) Lista el nombre de todos los productos que hay en la tabla producto");
            System.out.println("2) Lista los nombres y los precios de todos los productos de la tabla producto");
            System.out.println("3) Listar aquellos productos que su precio esté entre 120 y 202");
            System.out.println("4) Buscar y listar todos los Portátiles de la tabla producto");
            System.out.println("5) Listar el nombre y el precio del producto más barato");
            System.out.println("6) Ingresar un producto a la base de datos");
            System.out.println("7) Ingresar un fabricante a la base de datos");
            System.out.println("8) Editar un producto con datos a elección");
            System.out.println("9) Salir");
            answer = read.nextInt();

            switch (answer){

                case 1: ps.showProductA();
                break;
                case 2: ps.showProductB();
                break;
                case 3: ps.showProductC();
                break;
                case 4: ps.showProductD();
                break;
                case 5: ps.showProductE();
                break;
                case 6: ps.createProduct();
                break;
                case 7: fs.createManufacture();
                break;
                case 8: ps.modifyProduct();
                break;
                case 9: break;
            } 
        } while (answer!=9); 
    }
}
