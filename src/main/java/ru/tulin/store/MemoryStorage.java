package ru.tulin.store;

import ru.tulin.models.Client;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.11.2016
 */
public class MemoryStorage implements Storage {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<Integer, Client>();

    public MemoryStorage() {
        this.clients.put(1, new Client(1, "admin", "admin", null));
    }

    @Override
    public Collection<Client> values() {
        return this.clients.values();
    }

    @Override
    public int add(final Client client) {
        this.clients.put(client.getId(), client);
        return client.getId();
    }

    @Override
    public void edit(final Client client) {
        this.clients.replace(client.getId(), client);
    }

    @Override
    public void delete(final int id) {
        this.clients.remove(id);
    }

    @Override
    public Client get(final int id) {
        return this.clients.get(id);
    }

    @Override
    public Client findByLogin(final String login) {
        for (final Client client : clients.values()) {
            if (client.getLogin().equals(login)) {
                return client;
            }
        }
        throw new IllegalStateException(String.format("Login %s not found", login));
    }

    @Override
    public int generateId() {
        return this.atomicInteger.incrementAndGet();
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isCredentional(String login, String password) {
        boolean exist = false;
        for (Client client : this.clients.values()) {
            if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
