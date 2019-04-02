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
 * Servlet implementation class Actualizar
 */
@WebServlet("/Actualizar")
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int id;
       String elemento;
       String serial;
       String parte;
       String estado;
       String ubicacion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/actualizar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.id =Integer.parseInt(request.getParameter("idac"));
		this.elemento= request.getParameter("elementoac");
		this.serial= request.getParameter("serialac");
		this.parte= request.getParameter("parteac");
		this.estado= request.getParameter("estadoac");
		this.ubicacion= request.getParameter("ubicacionac");
		
		try {
			 Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/datavision?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			 Statement miStatement = miConexion.createStatement();
			 
			 String instruccionSQL = "UPDATE INVENTARIO SET ELEMENTO='"+elemento+"', SERIAL='"+serial+"', PARTE='"+parte+"', ESTADO='"+estado+"', UBICACION='"+ubicacion+"' WHERE ID='"+id+"'";
			 miStatement.executeUpdate(instruccionSQL);
			 
			 System.out.println("Se editó un registro");
			}
		catch(Exception e) {
				System.out.println("No conecta");
				e.printStackTrace();
			}
		request.getRequestDispatcher("/WEB-INF/views/actualizarok.jsp").forward(request, response);
	}

}

