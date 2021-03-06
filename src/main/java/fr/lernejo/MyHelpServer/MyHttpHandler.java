package fr.lernejo.MyHttpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String corps = "Hello";
        exchange.sendResponseHeaders(200, corps.length());
        try (OutputStream os = exchange.getResponseBody()) { // (1)
            os.write(corps.getBytes());
        }
    }
}
