package jsp_employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class SignUpController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String email=req.getParameter("email");
        String password=req.getParameter("password");

		Employee user=new Employee();
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setAddress(address);
		user.setEmail(email);
		user.setPassword(password);
		EmployeeCRUD userCRUD=new EmployeeCRUD();
		try {
			PrintWriter out=res.getWriter();
			int count=userCRUD.signUp(user);
			if(count!=0) {
//				out.print("Sign Up Succes");
				req.setAttribute("message", "SignUp Successfully");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, res);
			}else {
			//	out.print("Sign Up Failed");
				req.setAttribute("message", "SignUp Failed");
				RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
				dispatcher.forward(req, res);
			}
		} catch (Throwable e) {
			
			e.printStackTrace();
		}

	}

}
