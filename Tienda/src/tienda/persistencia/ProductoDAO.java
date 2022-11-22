
package tienda.persistencia;

import tienda.entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Damian
 */
public final class ProductoDAO extends DAO {
    

    public Collection<Producto> query(String sql) throws Exception{
        
        try{        
            Collection<Producto> productos = new ArrayList();
            queryBase(sql);
            Producto p = null;
                        
            while (result.next()){
                p = new Producto();
                p.setNombre(result.getString("nombre"));
                p.setPrecio(result.getDouble("precio"));
                productos.add(p);
            }
            disconectionBase();
            return productos;
        } catch (Exception e) {
            disconectionBase();
            throw e;
        } 
    }  
    
//a) Lista el nombre de todos los productos que hay en la tabla producto.
    public Collection<Producto> queryA() throws Exception{
        
        String sql = "SELECT nombre, precio FROM producto";
        return query(sql); 
    }

//b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public Collection<Producto> queryB() throws Exception{
             
        String sql = "SELECT nombre, precio FROM producto";
        return query(sql);
    }  

//c) Listar aquellos productos que su precio esté entre 120 y 202.
    public Collection<Producto> queryC() throws Exception{
             
        String sql = "SELECT nombre, precio FROM producto WHERE precio BETWEEN 120 AND 202";
        return query(sql);
    }  
    
//d) Buscar y listar todos los Portátiles de la tabla producto.
    public Collection<Producto> queryD() throws Exception{
             
        String sql = "SELECT nombre, precio FROM producto WHERE nombre LIKE '%Portátil%'";
        return query(sql);
    }        
            
//e) Listar el nombre y el precio del producto más barato.
    public Collection<Producto> queryE() throws Exception{
             
        String sql = "SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1";
        return query(sql);
    }    
    
//f) Ingresar un producto a la base de datos.
    public void queryF(Producto p) throws Exception{
        
        try{
            if (p == null) {
                throw new Exception("debe ingresar un producto");
            }
        String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)" 
                     + "VALUES ( '" + p.getCodigo() + "','" + p.getNombre() + "','" + p.getPrecio() + "','" + p.getCodigoFabricante() + "');";
        
        insertUpdateDelete(sql);
        
        } catch (Exception e) {
            throw e;
        } 
    }

//h) Editar un producto con datos a elección.
    public void queryH(Producto p) throws Exception{
        
        try{
            if (p == null) {
                throw new Exception("debe ingresar un producto");
            }
        String sql = "UPDATE producto SET precio = '" + p.getPrecio() + "' WHERE codigo = '" + p.getCodigo() + "';";
        
        insertUpdateDelete(sql);
        
        } catch (Exception e) {
            throw e;
        } 
    }
}



