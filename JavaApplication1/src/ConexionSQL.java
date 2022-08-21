
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSQL {
    
        private Connection SqlCn;
	private final String Nombre_db ="dbcontactos"; //Cambiar nombre de la base de dasto
	private final String usuario ="root";
	private final String password ="1009";
	private final String url ="jdbc:mysql://localhost:3306/";
        private final String driver = "com.mysql.cj.jdbc.Driver";
        
        private  PreparedStatement  stm =null;
	private ResultSet Rs = null;
        
        public Connection getConnetion() {
		try {
			//driver
			Class.forName(driver);
			//conexion con el server
			SqlCn =  DriverManager.getConnection(url + Nombre_db,usuario,password);
			if(SqlCn!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurre una ClassException: "+e.getMessage());
			SqlCn = null;
		}catch (SQLException e) {
			System.out.println("Ocurre una SQLException: "+e.getMessage());
		}
		return SqlCn;
	}
        ///////METODO PARA ELIMINAR BY ID///////
        public boolean DeleteUser(String ID) {
		boolean valid = false;
		 String statment= "delete from estudiantes where idEstudiantes = '"+ID+"'";
		try {
			SqlCn = getConnetion();
			stm = SqlCn.prepareStatement(statment);
			stm.executeUpdate();
			System.out.println("Estudiante eliminado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: "+e);
		}finally {
			valid=true;
                    try {
                        SqlCn.close();
                        System.out.println("Conexion cerrada ");
                    } catch (SQLException ex) {
                        Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		return valid;
	}
}
