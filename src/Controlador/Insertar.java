package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Insertar
 */
@WebServlet("/Insertar")
public class Insertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	String elemento;
	String serial;
	String parte;
	String estado;
	String ubicacion;
    public Insertar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/insertar.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.elemento= request.getParameter("elementoin");
		this.serial= request.getParameter("serialin");
		this.parte= request.getParameter("partein");
		this.estado= request.getParameter("estadoin");
		this.ubicacion= request.getParameter("ubicacionin");
		
		try {
			 Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/datavision?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			 Statement miStatement = miConexion.createStatement();
			 
			 String instruccionSQL = "INSERT INTO INVENTARIO (ELEMENTO, SERIAL, PARTE, ESTADO, UBICACION) VALUES ('"+elemento+
					 					"', '"+serial+"', '"+parte+"', '"+estado+"', '"+ubicacion+"')";
			 miStatement.executeUpdate(instruccionSQL);
			 
			 System.out.println("Se insertó un registro");
			}
		catch(Exception e) {
				System.out.println("No conecta");
				e.printStackTrace();
			}
		request.getRequestDispatcher("/WEB-INF/views/insertarok.jsp").forward(request, response);
	}
	
	

}
