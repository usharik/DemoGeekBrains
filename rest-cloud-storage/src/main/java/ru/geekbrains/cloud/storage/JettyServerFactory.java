package ru.geekbrains.cloud.storage;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServerFactory {

    public Server getJettyServer() {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/rest/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES,
                "com.fasterxml.jackson.jaxrs.json;ru.geekbrains.cloud.storage.rest");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(false);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
        String resourcePath = getClass().getResource("/public/").getPath();
        resource_handler.setResourceBase(resourcePath);
        ContextHandler staticCtx = new ContextHandler("/");
        staticCtx.setHandler(resource_handler);

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { staticCtx, context, new DefaultHandler() });

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(handlers);

        return jettyServer;
    }
}
