
package Controlador;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Modelo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		description = "Login Servlet", 
		urlPatterns = { 
				"/Login", 
				"/Login.do"
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getLogger();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public void init(){
    	/* 2(a) CrearÃ¡ un objeto de tipo Map llamado DB el cual
    	 *  estarÃ¡ compuesto de String como llaves 
    	 *  y me.jmll.model.User como valor.
    	 * */
    	Map<String, User> DB = null;
    	if (this.getServletContext().getAttribute("DB") == null){
    		/*
    		 * Escribe aquÃ­ tu cÃ³digo
    		 * 
    		 * */
    		DB = new HashMap<String, User>();
    		
    		User user1 = new User("edwin.hidalgo", "Passw0rd");
    		user1.setFullName("Edwin Hidalgo");
    		User user2 = new User("guadalupe.palma", "Passworfnui3b");
    		user2.setFullName("Guadalupe Palma");
    		User user3 = new User("nadia.teja", "Ednfekjhb");
    		user3.setFullName("Nadia Teja");
    		
    		String user4 = "Hugo";
    		
    		DB.put(user1.getUsername(), user1);
    		DB.put(user2.getUsername(), user2);
    		DB.put(user3.getUsername(), user3);
    		
    		log.debug("Se han creado los usuarios");
    		
    		this.getServletContext().setAttribute("DB", DB);

    	} else {
    		DB = (HashMap<String, User>) this.getServletContext().getAttribute("DB");
    	}
    	log.info("Usuarios en DB {}", DB.keySet());
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 3. obtendrÃ¡ el request dispatcher y enviarÃ¡ la solicitud 
		 * a /WEB-INF/views/session.jsp si el atributo de la sesiÃ³n
		 *  user no es nulo. De lo contrario, llamarÃ¡ al mÃ©todo doPost()
		 * */
		if (request.getSession().getAttribute("user") != null){
    		/*
    		 * Escribe aquÃ­ tu cÃ³digo
    		 * 
    		 * */
			request.getRequestDispatcher("/WEB-INF/views/session.jsp").forward(request, response);
			
		} else {
			doPost(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();
		/* 4(a) a.	ValidarÃ¡ que los parÃ¡metros de la solicitud inputPassword e 
		 * inputUsername no sean nulos, de lo contrario agregarÃ¡ un elemento 
		 * string a la lista errors con el mensaje â€œYou should login firstâ€�, 
		 * registrarÃ¡ un evento WARN con el log con el mismo mensaje y 
		 * reenviarÃ¡ a /WEB-INF/views/login.jsp utilizando el requestDispatcher.
		 * */
		if (request.getParameter("inputUsername") != null && request.getParameter("inputPassword") != null ){
			String username = request.getParameter("inputUsername");
			String password = request.getParameter("inputPassword");
			log.info("Autentificando a {}", username);
			// valida usuario y password
			User user = login(username, password);
			if (user != null){
				/* 4(b). a.	Si el usuario no es nulo, asigna el atributo 
				 * user a la sesiÃ³n con el valor de getUsername y crea
				 *  un Cookie llamado fullName con el valor de getFullName
				 * */
				/*
	    		 * Escribe aquÃ­ tu cÃ³digo
	    		 * 
	    		 * */
				request.getSession().setAttribute("user", user.getFullName());
				
				Cookie fullName = new Cookie("fullName", URLEncoder.encode(user.getFullName(), "UTF-8"));
				fullName.setPath("/");
				fullName.setMaxAge(60 * 60 * 1);
				fullName.setHttpOnly(true);
				response.addCookie(fullName);
				
				doSession(request, response);
				request.getRequestDispatcher("/WEB-INF/views/session.jsp").forward(request, response);
				
			} else{
				log.error("Invalid username or password.");
				errors.add("Invalid username or password.");
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		} else {
    		/*
    		 * Escribe aquÃ­ tu cÃ³digo
    		 * 
    		 * */
			String errorMsg= "You should login first";
			errors.add(errorMsg);
			log.warn(errorMsg);

			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
	
	private User login(String username, String password){
		/* 5(a). Obtiene el atributo DB del ServletContext, 
		 *  y lo referencia a la variable DB para posteriormente
		 *  validar la existencia del usuario en cuestiÃ³n 
		 *  utilizando el mÃ©todo get(username) de la
		 *   clase HashMap.
		 * */
		if (username == null || password == null){
            return null;
        }
		/*
		 * Escribe aquÃ­ tu cÃ³digo
		 * 
		 * */
		Map<String, User> DB = (HashMap<String, User>) this.getServletContext().getAttribute("DB");
		User user = DB.get(username);
         
        if (user == null){
            return null;
        }
         
        if (!user.getPassword().equals(password.trim())){
            return null;
        }
        return user;
         
	}
	
	private void doSession(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// Obtiene la session actual
		HttpSession session = request.getSession();
		log.debug("Inicia doSession para {}", session.getId());
		// Crea un objeto Date a partir de un Long que es cuando se creo el cookie
		Date createTime = new Date(session.getCreationTime());
		// Obtiene la session ID (JSESSIONID)
		String sessionId = session.getId();
		// Obtiene el last Accessed time en objeto Date
		Date lastAccessedTime = new Date(session.getLastAccessedTime());
		// Obtiene max inactive interval (timeout) en segundos
		int maxInactiveInterval = session.getMaxInactiveInterval();

		// Guarda atributos en la session
		session.setAttribute("lastAccessedTime", lastAccessedTime);
		session.setAttribute("creationTime", createTime);
		session.setAttribute("sessionId", sessionId);
		session.setAttribute("maxInactiveInterval", maxInactiveInterval);
		log.debug("Termina doSession para {}", session.getId());
	}
}
