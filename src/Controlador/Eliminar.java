package Controlador;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/eliminar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/datavision?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			Statement miStatement = miConexion.createStatement();
			 
			 this.id = Integer.parseInt(request.getParameter("idel"));
			 String instruccionSQL = "DELETE FROM INVENTARIO WHERE ID='"+id+"'";
			 miStatement.executeUpdate(instruccionSQL);
			 
			 System.out.println("Se eliminó un registro");
			}
		catch(Exception e) {
				System.out.println("No conecta");
				e.printStackTrace();
			}
		request.getRequestDispatcher("/WEB-INF/views/eliminarok.jsp").forward(request, response);
	}

}
