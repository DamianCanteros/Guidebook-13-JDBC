
package estancia.persistencia;

import estancia.entidades.Casa;
import java.util.ArrayList;

/**
 *
 * @author Damian
 */
public class CasaDAO  extends DAO{

//Ingresar o modifica un producto en la base de datos.
    public void update(Casa c,String sql) throws Exception{
        
        try{
            if (c == null) {
                throw new Exception("debe ingresar los datos de una casa");
            }
        
        insertUpdateDelete(sql);
        
        } catch (Exception e) {
            throw e;
        } 
    }
//Ingresar una consulta a la base de datos.   
    public ArrayList<Casa> query(String sql) throws Exception{
        
        try{        
            ArrayList<Casa> casas = new ArrayList();
            queryBase(sql);
            Casa c = null;
                        
            while (result.next()){
                c = new Casa();
                c.setId_casa(result.getInt("id_casa"));
                c.setCalle(result.getString("calle"));
                c.setNumero(result.getInt("numero"));
                c.setCodigo_postal(result.getInt("codigo_postal"));
                c.setCiudad(result.getString("ciudad"));
                c.setPais(result.getString("pais"));
                c.setFecha_desde(result.getDate("fecha_desde"));
                c.setFecha_hasta(result.getDate("fecha_hasta"));
                c.setTiempo_minimo(result.getInt("tiempo_minimo"));
                c.setTiempo_maximo(result.getInt("tiempo_maximo"));
                c.setPrecio_habitacion(result.getDouble("precio_habitacion"));
                c.setTipo_vivienda(result.getString("tipo_vivienda"));
                casas.add(c);
            }
            disconectionBase();
            return casas;
        } catch (Exception e) {
            disconectionBase();
            throw e;
        } 
    } 
  
//Devuelve la cuenta de las filas de una consulta   
    public ArrayList<Integer> count(String sql) throws Exception{
        
        try{        
            ArrayList<Integer> cantidad = new ArrayList();
            queryBase(sql);
                        
            while (result.next()){

            int count = result.getInt("Count(*)");

                cantidad.add(count);
            }
            disconectionBase();
            return cantidad;
        } catch (Exception e) {
            disconectionBase();
            throw e;
        } 
    }  
    
//Casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
    public ArrayList<Casa> queryB() throws Exception{
        System.out.println("\nCasas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido");
        String sql = "SELECT * FROM casas WHERE fecha_hasta <= '2020-08-31'  AND fecha_desde >= '2020-08-01'";
    return query(sql); 
    }         
    
//Casas disponibles a partir de una fecha dada y un número de días específico.
    public ArrayList<Casa> queryD(String desde, String hasta) throws Exception{
        System.out.println("\nCasas disponibles a partir de una fecha dada y un número de días específico");
        String sql = "SELECT * FROM casas WHERE fecha_desde NOT BETWEEN '" + desde + "' AND '" + hasta + "' AND fecha_hasta NOT BETWEEN '" + desde + "' AND '" + hasta + "'";
    return query(sql); 
    }
        
//Incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
    public ArrayList<Casa> updateG() throws Exception{
        
    //Busca y carga las casas de Reino Unido
        String sql1 = "SELECT * FROM casas WHERE pais = 'Reino Unido'";
        
        System.out.println("\nActualización de precios");
        for (Casa aux : query(sql1)) {
        //Modifica los precios
            aux.setPrecio_habitacion(aux.getPrecio_habitacion()*1.05);
            String sql2 = "UPDATE casas SET precio_habitacion = '" + aux.getPrecio_habitacion() + "' WHERE id_casa = '" + aux.getId_casa() + "';";
            update(aux,sql2);
        }
    //Busca las casas con los precios modificados    
        String sql3 = "SELECT * FROM casas WHERE pais = 'Reino Unido'";
    return query(sql3);
    }        
     
//Obtiene el número de casas que existen para cada uno de los países diferentes.
    public ArrayList<Integer> queryH() throws Exception{
        System.out.println("\nNúmero de casas que existen");
        String sql = "SELECT COUNT(*) FROM casas GROUP BY pais";
    return count(sql); 
    }

//Obtiene el nombre de los diferentes países.
    public ArrayList<Casa> queryH2() throws Exception{
        String sql = "SELECT * FROM casas GROUP BY pais";
    return query(sql); 
    }  
    
//Busca y lista aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
    public ArrayList<Casa> queryI() throws Exception{
    System.out.println("\nCasas del Reino Unido de las que se ha dicho que están limpias");
    String sql = "SELECT * FROM casas INNER JOIN comentarios AS c ON casas.id_casa = c.id_casa WHERE comentario LIKE '%limpia%'";
    return query(sql); 
    } 

//Casas que han sido reservadas por un cliente
    public ArrayList<Casa> queryEF() throws Exception{
        
        try{        
            ArrayList<Casa> casas = new ArrayList();
            String sql = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais, precio_habitacion, tipo_vivienda FROM casas INNER JOIN estancias USING (id_casa)";
            queryBase(sql);
            Casa c = null;
                        
            while (result.next()){
                c = new Casa();
                c.setId_casa(result.getInt("id_casa"));
                c.setCalle(result.getString("calle"));
                c.setNumero(result.getInt("numero"));
                c.setCodigo_postal(result.getInt("codigo_postal"));
                c.setCiudad(result.getString("ciudad"));
                c.setPais(result.getString("pais"));
                c.setPrecio_habitacion(result.getDouble("precio_habitacion"));
                c.setTipo_vivienda(result.getString("tipo_vivienda"));
                casas.add(c);
            }
            disconectionBase();
            return casas;
        } catch (Exception e) {
            disconectionBase();
            throw e;
        } 
    }         
}
