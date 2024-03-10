package jsp_employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/lifecycle")
public class LifeCycleController extends HttpServlet {
	
	public LifeCycleController() {
		System.out.println("initilation is done");
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("init() call");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() is call");
	}
	@Override
	public void destroy() {
		System.out.println("destroy() is call");
	}

}
