
import java.sql.*;

public class ConexionSQL {
    
        private static Connection SqlCn;
	private final String Nombre_db ="login_database";
	private final String usuario ="root";
	private final String password ="1009";
	private final String url ="jdbc:mysql://localhost:3306/";
        private final String driver = "com.mysql.cj.jdbc.Driver";
        
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
}
