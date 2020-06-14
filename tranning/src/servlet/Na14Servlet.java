package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BenhNhan;
import dao.BenhNhanDao;


/**
 * Servlet implementation class Na14Servlet
 */
@WebServlet("/Na14Servlet")
public class Na14Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Na14Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<BenhNhan> arrayList= new ArrayList<BenhNhan>();
		
	BenhNhanDao bnd= new BenhNhanDao();
	arrayList=bnd.getBenhNhan(1,20);
	request.setAttribute("benhnhan",arrayList);
	
	StringBuilder tongtrang=bnd.sotrang();
	
	
	request.setAttribute("sotrang","1");
	
	request.setAttribute("tongtrang",tongtrang);
	
	
	
	
	
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/user/Na14.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String pagenumber = request.getParameter("trang");
		 
		 
		 ArrayList<BenhNhan>arrayList= new ArrayList<BenhNhan>();
		 int pagenumbercv=Integer.parseInt(pagenumber);
		 int start=pagenumbercv*10+(pagenumbercv-2)*10+1;
		 int total=pagenumbercv*20;
		  BenhNhanDao bnd= new BenhNhanDao(); 
		  arrayList=bnd.getBenhNhan(start,total);
		  StringBuilder tongtrang=bnd.sotrang();
		
		 
		  request.setAttribute("benhnhan",arrayList);
		  request.setAttribute("sotrang",pagenumber);
		  request.setAttribute("tongtrang",tongtrang);
		  
		 request.getRequestDispatcher("/WEB-INF/jsp/user/Na14.jsp").forward(request,response);
		 
	}

}
