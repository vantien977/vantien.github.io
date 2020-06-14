package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.BenhNhan;
import connect.Database;

public class BenhNhanDao {
	
	Database db;
	
	Connection conn;
	
	public ArrayList<BenhNhan> getBenhNhan(int start,int total){
		 db= new Database();
		 conn=db.moKetNoi();
	ArrayList<BenhNhan>	arrayListBN= new ArrayList<BenhNhan>();
	 String sql="SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY id) AS RowNum  FROM benhnhan1) AS MyDerivedTable WHERE MyDerivedTable.RowNum BETWEEN "+start+" AND "+total+";";
	 
	 try {
		 PreparedStatement ps = conn.prepareCall(sql);
         ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BenhNhan bn= new BenhNhan();
			bn.setPatid(rs.getInt("id"));
			bn.setPatname(rs.getString("name"));
			bn.setPatintday(rs.getDate("intday"));
			bn.setPatupdday(rs.getDate("updday"));
            arrayListBN.add(bn);
        }
		 return arrayListBN;
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	 return null;
	 
	 
		
	}
	
	public StringBuilder sotrang()
	{
		db= new Database();
		 conn=db.moKetNoi();
	
	 String sql="SELECT COUNT(*) AS cot FROM benhnhan1	;";
	 StringBuilder socot=new StringBuilder();
	 
	 try {
		 PreparedStatement ps = conn.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
			socot.append(rs.getString("cot"));
        }
		 
	} catch (SQLException e) {
		// TODO: handle exception
		
	}
	//sc= Integer.parseInt(socot.toString());
	 
	 return socot;
	 
		
	}
	public ArrayList<BenhNhan> getBenhNhanTheoTrang(ArrayList<BenhNhan> arrayList,int trang)
	{
		int i;
		int n=trang*20;
		 ArrayList<BenhNhan> arrayList2= new ArrayList<BenhNhan>();
		for(i=(trang*10)+(trang-2)*10+1;i<=n;i++)
		{
			arrayList2.add(arrayList.get(i));
		}
		return arrayList2;
	}
	public static void main(String args[])
	
	{
		System.out.println("loi");
		BenhNhanDao bnd= new BenhNhanDao();
		System.out.println("loi");
		ArrayList< BenhNhan>arrayList =bnd.getBenhNhan(1,20);
		System.out.println(arrayList);
		
		
			for(int i=0;i<arrayList.size();i++)
			{
				System.out.println(arrayList.get(i));
			}
			StringBuilder trang=bnd.sotrang();
			System.out.println(trang+"so trang");
		
		
	}
	

}
