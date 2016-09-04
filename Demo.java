import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	
	public static void main(String[] args) {
		
		DBConnector dbc = new DBConnector("localhost", "hr", "root", "126874");
		ResultSet result = dbc.makeSelectStatement("SELECT CONCAT(first_name,last_name) as name , salary FROM employees;");
		try {
			while(result.next()){
				System.out.print(result.getString("name"));
				System.out.print(" - ");
				System.out.println(result.getString("salary"));
			}
		} catch (SQLException e) {
			System.out.println("Printing Errorr....");
			e.printStackTrace();
		}
		
	}

}
