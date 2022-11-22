
package estancia;

import estancia.servicios.CasaService;
import estancia.servicios.ClienteService;
import estancia.servicios.EstanciaService;
import estancia.servicios.FamiliaService;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class NewMain {

    public static void main(String[] args) throws Exception {
        
        FamiliaService fs = new FamiliaService();
        CasaService hs = new CasaService();
        ClienteService cs = new ClienteService();
        EstanciaService es = new EstanciaService();
        Scanner read = new Scanner(System.in);
        
        int answer;
        
        do {
            System.out.println("\n============= ESTANCIA =============\n");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("1) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
            System.out.println("2) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido");
            System.out.println("3) Encontrar todas aquellas familias cuya dirección de mail sea de Hotmail");
            System.out.println("4) Consultar la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.");
            System.out.println("5) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.");
            System.out.println("6) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior");
            System.out.println("7) Incrementar el precio por día en un 5% de todas las casas del Reino Unido y Mostar los precios actualizados");
            System.out.println("8) Obtener el número de casas que existen para cada uno de los países diferentes");
            System.out.println("9) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’");
            System.out.println("10) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas");
            System.out.println("11) Salir");
            answer = read.nextInt();

            switch (answer){

                case 1: fs.showqueryA();
                break;
                case 2: hs.showqueryB();
                break;
                case 3: fs.showqueryC();
                break;
                case 4: hs.showqueryD();
                break;
                case 5: cs.showqueryE();
                        hs.showqueryEF();
                break;
                case 6: es.showqueryF();
                        hs.showqueryEF();
                break;
                case 7: hs.showqueryG();
                break;
                case 8: hs.showqueryH();
                break;
                case 9: hs.showqueryI();
                break;
                case 10: es.showqueryJ();
                break;
                case 11: break;
            } 
        } while (answer!=11); 
 
    }
    
}
