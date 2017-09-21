/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author martin
 */
@Path("index")
public class IndexController {
    
    @Context
    HttpServletRequest request;
    
    @Context
    HttpServletResponse response;
    
    @GET
    @Path("index")
    @Produces(MediaType.TEXT_HTML)
    protected Response index() throws IOException, ServletException{
        return Response.ok(new Viewable("index/index.jsp")).build();
    }
    
}
