import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;

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
		
		// JASON FILES
		//IMPORT GSON
		
		Gson gson = new Gson();
		String json = gson.toJson(new File("hah") );
		File partsJson = new File("parts.JSON");
		if(!partsJson.exists()){
			try {
				partsJson.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(json);
		try {
			FileWriter writer = new FileWriter(partsJson);
			writer.write(json);
			System.out.println("FILE CREATED");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
