
package estancia.persistencia;

import estancia.entidades.Familia;
import java.util.ArrayList;

/**
 *
 * @author Damian
 */
public final class FamiliaDAO extends DAO{

//Ingresar una consulta a la base de datos.   
    public ArrayList<Familia> query(String sql) throws Exception{
        
        try{        
            ArrayList<Familia> familias = new ArrayList();
            queryBase(sql);
            Familia f = null;
                        
            while (result.next()){
                f = new Familia();
                f.setId(result.getInt("id_familia"));
                f.setNombre(result.getString("nombre"));
                f.setEdad_minima(result.getInt("edad_minima"));
                f.setEdad_maxima(result.getInt("edad_maxima"));
                f.setNum_hijos(result.getInt("num_hijos"));
                f.setEmail(result.getString("email"));
                familias.add(f);
            }
            disconectionBase();
            return familias;
        } catch (Exception e) {
            disconectionBase();
            throw e;
        } 
    }  
    
//Lista aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años
        public ArrayList<Familia> queryA() throws Exception{
            System.out.println("\nFamilias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años");
            String sql = "SELECT * FROM familias WHERE edad_maxima < 10 AND num_hijos >= 3";
            return query(sql); 
    }
        
//Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail
        public ArrayList<Familia> queryC() throws Exception{
            System.out.println("\nFamilias cuya dirección de mail sea de Hotmail");
            String sql = "SELECT * FROM familias WHERE email LIKE '%hotmail%'";
            return query(sql); 
    }          
    
}
