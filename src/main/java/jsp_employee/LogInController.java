package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/log")
public class LogInController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		EmployeeCRUD userCRUD=new EmployeeCRUD();
		
		try {
//			PrintWriter out=res.getWriter();
		String dbPassword=	userCRUD.logIn(email);
		if(dbPassword!=null) {
			if(password.equals(dbPassword)) {
//				out.print("Login Sucess");
				Cookie cookie=new Cookie("cookie",email);
				res.addCookie(cookie);
				Cookie cookie1=new Cookie("cookie1","1234");
				res.addCookie(cookie1);
				HttpSession httpSession=req.getSession();
				httpSession.setAttribute("session", email);
				System.out.println(httpSession);
				List<Employee> employees=userCRUD.getAllEmployee();
				req.setAttribute("list", employees);
				RequestDispatcher dispatcher=req.getRequestDispatcher("success.jsp");
				dispatcher.forward(req, res);
//				res.sendRedirect("success.jsp");
			}else {
//				out.print("Invalid Password");
				req.setAttribute("message", "Invalid Password");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, res);
				
			}
			
		}else {
//			out.print("User Not Register   "+email);
			req.setAttribute("message", "User Not Register Please Register");
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
			dispatcher.forward(req, res);
		}
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}
}
