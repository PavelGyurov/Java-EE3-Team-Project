package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shop.Customer;
import model.shop.DBManager.DBUserDAO;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String town = request.getParameter("town");
		String street = request.getParameter("street");
		int streetnumber = Integer.parseInt(request.getParameter("streetnumber"));

		String regOrUpdate = request.getParameter("regOrUpdate");

		String validate = validateInput(name, email, password, cpassword, firstname, lastname, phone, town, street, streetnumber);
		
		
		if(validate.equals("succes")){
			Customer user = new Customer(name, password, email, firstname, lastname, phone, town, street,
					streetnumber);
			if(regOrUpdate.equals("reg")){
				try {
					if (DBUserDAO.getInstance().usernameExists(name)) {
						response.sendRedirect("register.jsp?reg="+"nameeexist");
						
					} else {
						DBUserDAO.getInstance().addUser(user);
						request.getSession().setAttribute("registration", "succes");
						response.sendRedirect("success.jsp");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(regOrUpdate.equals("update")){
				try {
					DBUserDAO.getInstance().updateUser(user);
					request.getSession().setAttribute("registration", "succes");
					response.sendRedirect("profile.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			request.setAttribute("registration", validate);
			if(regOrUpdate.equals("reg")){
				response.sendRedirect("register.jsp?reg="+validate);
			} else if(regOrUpdate.equals("update")){
				response.sendRedirect("profile.jsp?reg="+validate);
			}
		}
		


	}

	private String validateInput(String name, String email, String password, String cpassword, String firstname,
			String lastname, String phone, String town, String street, int streetnumber) {
		if (name == null || name.equals("") || email == null || email.equals("") || password == null
				|| password.equals("") || cpassword == null || cpassword.equals("") || firstname == null
				|| firstname.equals("") || lastname == null || lastname.equals("") || phone == null || phone.equals("")
				|| town == null || town.equals("") || street == null || street.equals("")) {
			return "empty";
		} else if (streetnumber <= 0) {
			return "negativenumber";
		} else if (!isValidEmailAddress(email)) {
			return "invalidemail";
		} else{
			return "succes";
		}
	}

	private boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
