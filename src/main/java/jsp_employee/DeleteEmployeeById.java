package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteEmployeeById extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeCRUD userCRUD=new EmployeeCRUD();
		try {
			int count=userCRUD.delete(id);
			if(count!=0) {
				List<Employee> employees=userCRUD.getAllEmployee();
				req.setAttribute("list", employees);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
