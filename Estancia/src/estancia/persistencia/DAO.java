
package estancia.persistencia;

/**
 *
 * @author Damian
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public abstract class DAO {
    
    protected Connection connection = null;
    protected ResultSet result = null;
    protected Statement stmt = null;
    
    
    protected final String user = "root";
    protected final String password = "root";
    protected final String driver = "com.mysql.jdbc.Driver";
    protected final String url = "jdbc:mysql://localhost:3306/estancias_exterior";
    
 //Conecta la base de datos       
    protected void conectionBase() throws ClassNotFoundException, SQLException {
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
//Desconecta la base de datos    
    protected void disconectionBase() throws Exception {    
        try {
            if (result!= null) {
                result.close();
            }
            if (stmt!= null) {
                stmt.close();
            }
            if (connection!= null) {
                connection.close();
            }
        } catch (Exception e){
            throw e;
        }  
    }
    
//Carga, Modifica o Elimina datos   
    protected void insertUpdateDelete(String sql) throws SQLException, ClassNotFoundException, Exception{
        try{
            conectionBase();
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally{
            disconectionBase();
        }
    }
    
//Consulta la base de datos       
    protected void queryBase(String sql) throws Exception{
        try{
            conectionBase();
            stmt = connection.createStatement();
            result = stmt.executeQuery(sql);
            
        } catch (Exception e) {
            throw e;
        } 
    }
}
