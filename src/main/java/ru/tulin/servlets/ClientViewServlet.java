package ru.tulin.servlets;

import ru.tulin.models.Client;
import ru.tulin.store.ClientCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.11.2016
 */
public class ClientViewServlet extends HttpServlet {

    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("clients", this.CLIENT_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/ViewClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        CLIENT_CACHE.close();
    }
}
