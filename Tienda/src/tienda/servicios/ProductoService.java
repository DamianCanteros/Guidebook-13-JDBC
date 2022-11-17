
package tienda.servicios;

import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class ProductoService {
    
    ProductoDAO pd = new ProductoDAO();
    Scanner read = new Scanner(System.in);

//Muestra la consulta A
    public void showProductA() throws Exception{
        
        System.out.println("\n_____________ todos los productos _____________\n");
        for (Producto aux : pd.queryA()) {
            System.out.println(aux.getNombre());
        }
    }
//Muestra la consulta B
    public void showProductB() throws Exception{
        
        System.out.println("\n_____________ nombres y precios de todos los productos _____________\n");
        for (Producto aux : pd.queryB()) {
            System.out.println(aux.getNombre() + "\t\t\t\t\t\t\t$" + aux.getPrecio());
        }
    }
//Muestra la consulta C
    public void showProductC() throws Exception{
        
        System.out.println("\n_____________ productos que su precio esta entre 120 y 202 _____________\n");
        for (Producto aux : pd.queryC()) {
            System.out.println(aux.getNombre() + "\t\t\t\t\t\t\t$" + aux.getPrecio());
        }
    }
//Muestra la consulta D
    public void showProductD() throws Exception{
        
        System.out.println("\n_____________ todos los Portátiles _____________\n");
        for (Producto aux : pd.queryD()) {
            System.out.println(aux.getNombre() + "\t\t\t\t\t\t\t$"+ aux.getPrecio());
        }
    }
//Muestra la consulta E
    public void showProductE() throws Exception{
        
        System.out.println("\n_____________ nombre y el precio del producto más barato _____________\n");
        for (Producto aux : pd.queryE()) {
            System.out.println(aux.getNombre() + "\t\t\t\t\t\t\t$"+ aux.getPrecio());
        }
    }
//Carga un producto a la base de datos
    public void createProduct() throws Exception{
       
        String answer = "Y";
        do {
            System.out.println("ingrese el codigo del producto");
            int codigo = read.nextInt();
            System.out.println("ingrese el nombre del producto");
            String nombre = read.next();
            System.out.println("ingrese el precio del producto");
            double precio = read.nextDouble();
            System.out.println("ingrese el codigo del fabricante del producto");
            int codigo_fabricante = read.nextInt();

            Producto p = new Producto(codigo,nombre,precio,codigo_fabricante);
            
            System.out.println("Do you want enter another product? Y/N");
            answer = read.next();
            
            pd.queryF(p);
            
        } while (answer.equalsIgnoreCase("Y"));
    }
    
//Modifica un producto a la base de datos
    public void modifyProduct() throws Exception{
       
            System.out.println("ingrese el codigo del producto a modificar");
            int codigo = read.nextInt();
            System.out.println("ingrese el nuevo precio del producto a modificar");
            double precio = read.nextDouble();

            Producto p = new Producto();
            p.setCodigo(codigo);
            p.setPrecio(precio);
            
            pd.queryH(p);
    }
}
