import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	
	// Load JDBC driver -> Build Path / Configure / Add external jars
	
	private String ip;
	private String db;
	private String name;
	private String pass;
	private Connection con;
	private Statement stm;
	private PreparedStatement prepStm;
	
	DBConnector(String ip, String db, String name , String pass){
		this.ip = ip;
		this.db = db;
		this.name = name;
		this.pass = pass;
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver not loaded correctly....");
				e.printStackTrace();
			}
			try {
				this.con = DriverManager.getConnection("jdbc:mysql://"+ ip +":3306/" + db , name , pass);
				System.out.println("Connection made...");
				this.stm = con.createStatement();
				System.out.println("Statement created...");
			} catch (SQLException e) {
				System.out.println("Connection ERROR...");
				e.printStackTrace();
			}
			
	}	
	
	
	public ResultSet makeSelectStatement(String selectStatement){
			ResultSet rs = null;
		try {
			rs = stm.executeQuery(selectStatement);
			System.out.println("Statement executed");
		} catch (SQLException e) {
			System.out.println("Error in SQL Statement....");
			e.printStackTrace();
		}
		return rs;
	}
	
	public void makePreparedStatement(String insertStatement, String value1, String value2){
	try {
		prepStm = con.prepareStatement(insertStatement);
		prepStm.setString(1, value1);
		prepStm.setString(2, value2);
		prepStm.executeUpdate();
		System.out.println("Statement executed");
	} catch (SQLException e) {
		System.out.println("Error in SQL Statement....");
		e.printStackTrace();
	}
}

}
