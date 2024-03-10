package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id",id);
		
		EmployeeCRUD crud=new EmployeeCRUD();
		try {
			Employee employee=crud.getEmployeeDetailById(id);
			HttpSession httpSession=req.getSession();
			String sessionValue=(String) httpSession.getAttribute("session");
			if (sessionValue!=null) {
				req.setAttribute("emp",employee);
				RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
				dispatcher.forward(req, res);
			}else {
				req.setAttribute("message", "Please Login");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, res);
			}
			
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

}
