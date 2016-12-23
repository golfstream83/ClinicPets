package ru.tulin.servlets;

import ru.tulin.models.Client;
import ru.tulin.models.Dog;
import ru.tulin.store.ClientCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.11.2016
 */
public class ClientEditServlet extends HttpServlet {

    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", this.CLIENT_CACHE.get(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/EditClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        this.CLIENT_CACHE.edit(new Client(Integer.valueOf(req.getParameter("id")), req.getParameter("login"), null, null));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
