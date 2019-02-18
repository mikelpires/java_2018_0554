package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.daos.UsuarioDAO;
import com.ipartek.formacion.modelo.daos.VideoDAO;
import com.ipartek.formacion.modelo.pojo.Alerta;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

/**
 * Servlet implementation class VideosCrudController
 */
@WebServlet("/privado/video")
public class VideosCrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//LOG
	private final static Logger LOG = Logger.getLogger(VideosCrudController.class);
	
	private ValidatorFactory factory;
	private Validator validator;
	
	//VISTAS
	private static final String VIEW_INDEX = "videos/index.jsp";
	private static final String VIEW_FORM = "videos/form.jsp";
	private String vista;
 
	//OPERACIONES
	public static final String OP_LISTAR = "1";
	public static final String OP_IR_FORMULARIO = "2";
	public static final String OP_GUARDAR = "3"; // id == -1 insert , id > 0 update
	public static final String OP_ELIMINAR = "4";
		
		private Alerta alerta;
		
		//parametros	
		private String op;
		private String id;
		private String titulo;
		private String codigo;
		
		private String usuario_id;
		
	
		
	    private static VideoDAO videoDAO = null;
	    private static UsuarioDAO usuarioDAO = null;
	    
	    
	    
	    @Override
	    public void init(ServletConfig config) throws ServletException {    
	    	super.init(config);
	    	videoDAO = videoDAO.getInstance();
	    	usuarioDAO = UsuarioDAO.getInstance();
	    	factory  = Validation.buildDefaultValidatorFactory();
	    	validator  = factory.getValidator();
	    	
	    }
	    
	   
	  
	    
	  
	    
	   	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	
	
	

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		vista = VIEW_INDEX;
		alerta = null;
		try {
			// recoger parametros
			getParametros(request);
			// realizar operacion
			switch (op) {
				case OP_IR_FORMULARIO:
					irFormulario(request);
					break;
				case OP_GUARDAR:
					guardar(request);
					break;	
				case OP_ELIMINAR:
					eliminar(request);
					break;	
				default:
					listar(request);
					break;
			}
			
			
		}catch (Exception e) {
			LOG.error(e);	
			alerta = new Alerta( Alerta.TIPO_DANGER, "Error inexesperado sentimos las molestias.");
			
		}finally {
			// mensaje para el usuario
			request.setAttribute("alerta", alerta);
			// ir a una vista
			request.getRequestDispatcher(vista).forward(request, response);
		}	
	}


	private void listar(HttpServletRequest request) {
		request.setAttribute("videos", videoDAO.getAll());	
		
	}

	private void eliminar(HttpServletRequest request) throws SQLException {
		
		int identificador = Integer.parseInt(id);		
		
		if ( videoDAO.delete(identificador) ) {
			alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro eliminado con exito");
		}else {
			alerta = new Alerta( Alerta.TIPO_WARNING, "Registro NO eliminado, sentimos las molestias");
		}
				
		listar(request);		
	}


	private void guardar(HttpServletRequest request) {
	
		//crear pojo mediante parametros del formulario
				Video video = new Video();
				int identificador = Integer.parseInt(id);	
				video.setId( (long)identificador);
				video.setTitulo(titulo);
				video.setCodigo(codigo);
				
				//preparamos el usuario para insertarlo
				Usuario u = new Usuario();;
				u.setId( (long)Integer.parseInt(usuario_id));
				video.setUsuario(u);
				
				//validar 		
				Set<ConstraintViolation<Video>> violations = validator.validate(video);
				
				
				if ( violations.size() > 0 ) {              // validacion NO correcta
				 alerta = new Alerta( Alerta.TIPO_WARNING, "Los campos introduciodos no son correctos, por favor intentalo de nuevo");		 
				 vista = VIEW_FORM; 
				 request.setAttribute("video", video);	
				  
				}else {									  //  validacion correcta
				
					try {
						if ( identificador > 0 ) {
							videoDAO.update(video);	
						}else {				
							videoDAO.insert(video);
						}
						alerta = new Alerta( Alerta.TIPO_SUCCESS, "Registro guardado con exito");
						listar(request);
						
					}catch ( SQLException e) {
						alerta = new Alerta( Alerta.TIPO_WARNING, "Lo sentimos pero el codigo del video existe");
						vista = VIEW_FORM;
						request.setAttribute("video", video);
					}	
					
					
				}	
				
			}


	private void irFormulario(HttpServletRequest request) {
		
		vista = VIEW_FORM; 
		Video video = new Video();
		
		int identificador = Integer.parseInt(id);
		if ( identificador > 0 ) {			
			video = videoDAO.getById(identificador);
		}else {
			alerta = new Alerta( Alerta.TIPO_PRIMARY, "Insertar nuevo video");
		}
		
		request.setAttribute("video", video);	

		//envio todos los usuarios 
		request.setAttribute("usuarios", usuarioDAO.getAll());
	}

	
	private void getParametros(HttpServletRequest request) {

		op = request.getParameter("op");
		if( op == null ) {
			op = OP_LISTAR;
		} 
		
		
		id = request.getParameter("id");
		titulo = request.getParameter("titulo");
		codigo = request.getParameter("codigo");
		
		usuario_id = request.getParameter("usuario_id");
		
	
		
		LOG.debug( String.format("parametros: op=%s id=%s email=%s password=%s", op, id, titulo, codigo ));
		
	}
	
	

}