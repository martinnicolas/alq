/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
@Path("personas")
public class PersonasController{
    
    @Context
    HttpServletRequest request;
    
    @Context
    HttpServletResponse response;

    @GET
    @Path("index")
    @Produces(MediaType.TEXT_HTML)
    protected Response index(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        List<Persona> personas = Persona.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("personas",personas);        
        map.put("usuario","Martin");
        Base.close();
        return Response.ok(new Viewable("personas/index.jsp",map)).build();
    }
    
    @GET
    @Path("new")
    @Produces(MediaType.TEXT_HTML)
    protected Response add(){
        return Response.ok(new Viewable("personas/add.jsp")).build();
    }
    
    @GET
    @Path("edit")
    @Produces(MediaType.TEXT_HTML)
    protected Response edit(){
        return Response.ok(new Viewable("personas/edit.jsp")).build();
    }
    
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_HTML)
    protected Response update(@QueryParam("id") String id){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Persona persona = Persona.findFirst("id = ?", id);        
        persona.set("apellido","Gonzalez");
        persona.saveIt();
        Base.close();
        return Response.ok().build();
    }
    
    @DELETE
    @Path("destroy")
    @Produces(MediaType.TEXT_HTML)
    protected Response destroy(@QueryParam("id") String id){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Persona persona = Persona.findFirst("id = ?", id);        
        persona.delete();
        Base.close();
        return Response.ok().build();
    }
    
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_HTML)
    protected Response create(){
        Persona persona = new Persona();
        persona.set("dni", 31343209);
        persona.set("apellido", "Moreno");
        persona.set("nombre", "Felipe");
        persona.saveIt();
        return Response.ok().build();
    }
    
    

}
