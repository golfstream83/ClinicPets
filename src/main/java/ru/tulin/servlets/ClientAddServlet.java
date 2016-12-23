package ru.tulin.servlets;

import ru.tulin.models.Client;
import ru.tulin.models.Dog;
import ru.tulin.store.ClientCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.11.2016
 */
public class ClientAddServlet extends HttpServlet {

    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        this.CLIENT_CACHE.add(new Client(CLIENT_CACHE.generateId(), req.getParameter("login"), null, null));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
