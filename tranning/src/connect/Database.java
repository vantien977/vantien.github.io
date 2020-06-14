package connect;


import java.sql.DriverManager;
import java.sql.Connection;



public class Database {
	

	 static Connection con;
	 
	    

	    public Connection moKetNoi() {
	        try {
	        	 String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=trainning";
	        	  String user="root";
	              String pass="12345";
	              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	              con = DriverManager.getConnection(url,user,pass);
	              //System.out.println("Ket noi thanh cong");
	              return con;
	            
	           
	          
	        } catch (Exception ex) {
	            System.out.println("loi:" + ex.getMessage());
	        }
	        return null;
	    }
	 
		
	   

	    public static void main(String[] arg) {
	        Database db =new Database();
	        Connection connect= db.moKetNoi();
	        if(connect!=null)
	        {
	        	System.out.print(connect);
	        }
	       
	    }
}
