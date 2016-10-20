/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Filters;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mathias
 */
@Provider
@PreMatching
public class RestRequestFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
        if ( requestContext.getRequest().getMethod().equals( "OPTIONS" ) ) {
            // Just send a OK signal back to the browser
            requestContext.abortWith( Response.status( Response.Status.OK ).build() );
        }
    }
    
}