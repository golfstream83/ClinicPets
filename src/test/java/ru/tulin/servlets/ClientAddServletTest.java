package ru.tulin.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.tulin.store.ClientCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 28.11.2016
 */
public class ClientAddServletTest extends Mockito {

    final ClientCache cache = ClientCache.getInstance();

    @Test
    public void addClient() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");

        assertTrue(cache.values().isEmpty());

        new ClientAddServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("login");
        assertFalse(cache.values().isEmpty());

        cache.delete(cache.findByLogin("test").getId());
    }

}