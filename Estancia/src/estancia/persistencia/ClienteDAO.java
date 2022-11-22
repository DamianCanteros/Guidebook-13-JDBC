
package estancia.persistencia;

import estancia.entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Damian
 */
public class ClienteDAO  extends DAO{

//Clientes que en algún momento realizaron una estancia.   
    public ArrayList<Cliente> queryE() throws Exception{
        
        try{        
            ArrayList<Cliente> clientes = new ArrayList();
            String sql = "SELECT id_cliente, id_casa, nombre, calle, numero, codigo_postal, ciudad, pais, email  FROM estancias INNER JOIN clientes USING (id_cliente)";
            queryBase(sql);
            Cliente c = null;
                        
            while (result.next()){
                c = new Cliente();
                c.setId(result.getInt("id_cliente"));
                c.setId_casa(result.getInt("id_casa"));
                c.setNombre(result.getString("nombre"));
                c.setCalle(result.getString("calle"));
                c.setNumero(result.getInt("numero"));
                c.setCodigo_postal(result.getInt("codigo_postal"));
                c.setCiudad(result.getString("ciudad"));
                c.setPais(result.getString("pais"));
                c.setEmail(result.getString("email"));
                clientes.add(c);
            }
            disconectionBase();
            return clientes;
        } catch (Exception e) {
            disconectionBase();
            throw e;
        } 
    }     
  
}
