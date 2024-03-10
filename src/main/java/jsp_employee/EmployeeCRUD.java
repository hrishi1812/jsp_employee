package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class EmployeeCRUD {
	public Connection getConnection() throws Throwable {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&password=976478@se.com");
		return connection;
	}
	public int signUp(Employee user) throws Throwable {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getEmail());
		preparedStatement.setString(6, user.getPassword());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public String logIn(String email) throws Throwable {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("Select password from employee where email=? ");
		preparedStatement.setString(1, email);
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		if(resultSet.next()) {
			password=resultSet.getString("password");
		}
		connection.close();
		return password;
	}
	public List<Employee> getAllEmployee() throws Throwable{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("Select * from employee");
		ResultSet resultSet=preparedStatement.executeQuery();
		List<Employee> list= new ArrayList<Employee>();
		while (resultSet.next()) {
			Employee e=new Employee();
			e.setId(resultSet.getInt("id"));
			e.setName(resultSet.getString("name"));
			e.setPhone(resultSet.getLong("phone"));
			e.setAddress(resultSet.getString("address"));
			e.setEmail(resultSet.getString("email"));
			e.setPassword(resultSet.getString("password"));
			list.add(e);
		}
		connection.close();
		return list;
		
	}
public Employee getEmployeeDetailById(int id) throws Throwable {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("Select * from employee where id=? ");
	preparedStatement.setInt(1, id);
	ResultSet resultSet=preparedStatement.executeQuery();
	Employee e=new Employee();
	while (resultSet.next()) {
		e.setId(resultSet.getInt("id"));
		e.setName(resultSet.getString("name"));
		e.setPhone(resultSet.getLong("phone"));
		e.setAddress(resultSet.getString("address"));
		e.setEmail(resultSet.getString("email"));
		e.setPassword(resultSet.getString("password"));
	}
	connection.close();
	return e;
	
}
public int delete(int id) throws Throwable {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id=? ");
	preparedStatement.setInt(1, id);
	
	int result=preparedStatement.executeUpdate();
	
	connection.close();
	return result;
	
}
public int update(int id,String name,long phone,String address,String email,String password) throws Throwable {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("update employee set name=?,phone=?,address=?,email=?,password=? where id=? ");
	preparedStatement.setInt(6, id);
	preparedStatement.setString(1, name);
	preparedStatement.setLong(2, phone);
	preparedStatement.setString(3, address);
	preparedStatement.setString(4, email);
	preparedStatement.setString(5, password);
	int result=preparedStatement.executeUpdate();
	connection.close();
	return result;
}

}
