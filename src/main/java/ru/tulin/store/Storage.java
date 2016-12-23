package ru.tulin.store;

import ru.tulin.models.Client;

import java.util.Collection;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.11.2016
 */
public interface Storage {

    public Collection<Client> values();

    public int add(final Client client);

    public void edit(final Client client);

    public void delete(final int id);

    public Client get(final int id);

    public Client findByLogin(final String login) ;

    public int generateId();

    public void close();

    public boolean isCredentional(String login, String password);
}
