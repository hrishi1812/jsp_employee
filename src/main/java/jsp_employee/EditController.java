package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/up")
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeCRUD userCRUD=new EmployeeCRUD();
		
		try {
			int a=userCRUD.update(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),Long.parseLong(req.getParameter("phone")),req.getParameter("address"),
					req.getParameter("email"),req.getParameter("password"));
			if(a!=0) {
				Cookie[] cookies=req.getCookies();
				String value=null;
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("cookie")) {
						value=cookie.getValue();
						
					}
				}
				req.setAttribute("tracking", value);
				List<Employee> employees=userCRUD.getAllEmployee();
				req.setAttribute("list", employees);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

}
