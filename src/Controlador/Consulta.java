package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.Elemento;

/**
 * Servlet implementation class Consulta
 */
@WebServlet("/Consulta")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/datavision?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM INVENTARIO");
			
			List<Elemento> inventario = new ArrayList<>();
			Elemento e;
			
			 while(miResultSet.next()) {				//se indica nombre de columna o npumero de índice
				 e = new Elemento();
				 e.setId(miResultSet.getString("id"));
				 e.setNombre(miResultSet.getString("elemento"));
				 e.setSerie(miResultSet.getString("serial"));
				 e.setParte(miResultSet.getString("parte"));
				 e.setEstado(miResultSet.getString("estado"));
				 e.setUbicacion(miResultSet.getString("ubicacion"));
				 inventario.add(e);
				}
			 request.setAttribute("inventario", inventario);
			}catch(Exception e) {
				System.out.println("No conecta");
				e.printStackTrace();
			}
		
		request.getRequestDispatcher("/WEB-INF/views/consulta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
