/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Persona;
import org.glassfish.jersey.server.mvc.Viewable;
import org.javalite.activejdbc.Base;
/**
 *
 * @author martin
 */
@Path("/personas")
public class PersonasController{
    
    @Context
    HttpServletRequest request;
    
    @Context
    HttpServletResponse response;

    @GET
    @Produces(MediaType.TEXT_HTML)
    protected Response index() throws IOException, ServletException{
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        List<Persona> personas = Persona.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("personas",personas);        
        map.put("usuario","Martin");
        Base.close();
        return Response.ok(new Viewable("personas/index.jsp",map)).build();
    }

}
