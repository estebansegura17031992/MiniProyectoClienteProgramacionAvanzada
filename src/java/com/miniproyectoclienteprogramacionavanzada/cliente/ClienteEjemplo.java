/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miniproyectoclienteprogramacionavanzada.cliente;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author esteban
 */
public class ClienteEjemplo extends HttpServlet {

    private Client client;
    private String REST_SERVICE_URL = "http://localhost:8084/MiniProyectoProgramacionAvanzada/rest/UserService/users";
    private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String PASS = "pass";
    private static final String FAIL = "fail";

   private final String  folder = "/WEB-INF";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JAXBException {
        String action = request.getServletPath();
        
        // Control de las acciones a realizar según el *.htm
        if(action.equals("/index.htm")){
            // Guardar un atributo en la petición
            request.setAttribute("saludo", "Bienvenido a Programacion Avanzada");
            
            try  {
                this.client = ClientBuilder.newClient();
        
                GenericType<List<User>> list = new GenericType<List<User>>() {};
                List<User> users = client
                    .target(REST_SERVICE_URL)
                    .request(MediaType.APPLICATION_XML)
                    .get(list);
                
                request.setAttribute("users", users);
                
                // Mostrar index.jsp
                request.getRequestDispatcher(folder+"/index.jsp").
                        forward(request, response);
                } catch(Exception ex){
                    System.out.println("Error get rs");
                }
        } else if(action.equals("/detalleCliente.htm")){
                String userId = request.getParameter("userId");
                
                User sampleUser = new User();
                sampleUser.setIdUser(userId);
                this.client = ClientBuilder.newClient();
                User user = client
                    .target(REST_SERVICE_URL)
                    .path("/{userid}")
                    .resolveTemplate("userid", userId)
                    .request(MediaType.APPLICATION_XML)
                    .get(User.class);
                
                request.setAttribute("user", user);
                
                // Mostrar index.jsp
            request.getRequestDispatcher(folder+"/detalleCliente.jsp").
                    forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            //Logger.getLogger(ClienteEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            //Logger.getLogger(ClienteEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
