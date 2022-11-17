
package tienda.persistencia;

import tienda.entidades.Fabricante;


/**
 *
 * @author Damian
 */
public class FabricanteDAO extends DAO {
        
//g) Ingresar un fabricante a la base de datos
    public void queryG(Fabricante f) throws Exception{
        
        try{
            if (f == null) {
                throw new Exception("debe ingresar un fabricante");
            }
        String sql = "INSERT INTO fabricante (codigo, nombre)" 
                     + "VALUES ( '" + f.getCodigo() + "','" + f.getNombre() + "');";
        
        insertUpdateDelete(sql);
        
        } catch (Exception e) {
            throw e;
        } 
    }
}
