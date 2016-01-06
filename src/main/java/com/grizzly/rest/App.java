package com.grizzly.rest;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ResourceConfig rc = new PackagesResourceConfig("com.grizzly.rest.Services");
        HttpServer server;
        try {
            server = GrizzlyServerFactory.createHttpServer("http://localhost:9999", rc);
            System.out.println(String.format("Jersey app started with WADL available at "
                            + "%sapplication.wadl\nHit enter to stop it...",
                    "com.grizzly.rest.Services"));
            System.in.read();
            server.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
