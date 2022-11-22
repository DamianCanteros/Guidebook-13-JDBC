
package estancia.persistencia;

import estancia.entidades.Estancia;
import java.util.ArrayList;

/**
 *
 * @author Damian
 */
public class EstanciaDAO  extends DAO{

//Estancias que han sido reservadas por un cliente  
    public ArrayList<Estancia> queryF() throws Exception{
        
        try{        
            ArrayList<Estancia> estancias = new ArrayList();
            String sql = "SELECT id_estancia, id_casa, nombre_huesped, ciudad, pais, fecha_desde, fecha_hasta FROM estancias INNER JOIN clientes USING (id_cliente)";
            queryBase(sql);
            Estancia e = null;

            while (result.next()){
                e = new Estancia();
                e.setId_estancia(result.getInt("id_estancia"));
                e.setId_casa(result.getInt("id_casa"));
                e.setNombre_huesped(result.getString("nombre_huesped"));
                e.setCiudad(result.getString("ciudad"));
                e.setPais(result.getString("pais"));        
                e.setFecha_desde(result.getDate("fecha_desde"));
                e.setFecha_hasta(result.getDate("fecha_hasta"));
                estancias.add(e);
            }
            disconectionBase();
            return estancias;
        } catch (Exception ex) {
            disconectionBase();
            throw ex;
        } 
    }
//______________________________________________________________________________________________________________________________________________________
    
//Inserta nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.

//Casas disponibles a partir de una fecha dada y un número de días específico.
    public ArrayList<Estancia> queryJ0(String desde, String hasta) throws Exception{

        try{      
            ArrayList<Estancia> estancias = new ArrayList();
            String sql = "SELECT id_casa FROM estancias WHERE fecha_desde BETWEEN '" + desde + "' AND '" + hasta + "' AND fecha_hasta BETWEEN '" + desde + "' AND '" + hasta + "'";
            queryBase(sql);
            Estancia e = null;
            while (result.next()){
                e = new Estancia();
                e.setId_casa(result.getInt("id_casa"));
                estancias.add(e);
            }
            disconectionBase();
            return estancias;
        } catch (Exception ex) {
            disconectionBase();
            throw ex;
        } 
    }    
    
//Carga id_estancia.    
    public int queryJ1() throws Exception{
        
        try{        
            String sql = "SELECT id_estancia FROM estancias ORDER BY id_estancia DESC LIMIT 1";
            queryBase(sql);
            int estancia = 0;
            while (result.next()){
                estancia = result.getInt("id_estancia")+1;
            }
            disconectionBase();
            return estancia;
        } catch (Exception ex) {
            disconectionBase();
            throw ex;
        } 
    }
    
//Carga id_cliente.      
    public int queryJ2(String huesped) throws Exception{
        
        try{     
            int id_cliente = 0;
            String sql = "SELECT id_cliente FROM estancias RIGHT JOIN clientes USING (id_cliente) WHERE clientes.nombre = '" + huesped + "';";
            queryBase(sql);
            while (result.next()){
                id_cliente = result.getInt("id_cliente");
            }
            disconectionBase();           
            return id_cliente;
        } catch (Exception ex) {
            disconectionBase();
            throw ex;
        } 
    } 

//Carga la nueva estancia.  
    public void updateJ(int casa, String huesped, String desde, String hasta) throws Exception{
        
        try{
            if (queryJ1() == 0) {
                throw new Exception("debe ingresar una estancia");
            }
        String sql = "INSERT INTO estancias (id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta)" 
                     + "VALUES ( '" + queryJ1() + "','" + queryJ2(huesped) + "','" + casa + "','" + huesped + "','" + desde + "','" + hasta + "');";
        
        insertUpdateDelete(sql);
        
        } catch (Exception e) {
            throw e;
        } 
    }
//Busca los nuevos datos en la tabla estancias.   
    public Estancia queryJ() throws Exception{
        
        try{        
            ArrayList<Estancia> estancias = new ArrayList();
            String sql = "SELECT * FROM estancias ORDER BY id_estancia DESC LIMIT 1";
            queryBase(sql);
            Estancia e = null;

            while (result.next()){
                e = new Estancia();
                e.setId_estancia(result.getInt("id_estancia"));
                e.setId_cliente(result.getInt("id_cliente"));
                e.setId_casa(result.getInt("id_casa"));
                e.setNombre_huesped(result.getString("nombre_huesped"));      
                e.setFecha_desde(result.getDate("fecha_desde"));
                e.setFecha_hasta(result.getDate("fecha_hasta"));
            }
            disconectionBase();
            return e;
        } catch (Exception ex) {
            disconectionBase();
            throw ex;
        } 
    }
  
}
