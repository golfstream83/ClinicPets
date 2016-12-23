package ru.tulin.store;

import ru.tulin.models.Client;

import java.util.Collection;
import java.util.List;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.11.2016
 */
public class ClientCache implements Storage {

    private static final ClientCache INSTANCE = new ClientCache();

    private Storage storage = new MemoryStorage();

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public static ClientCache getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<Client> values() {
        return this.storage.values();
    }

    @Override
    public int add(final Client client) {
        return this.storage.add(client);
    }

    @Override
    public void edit(final Client client) {
        this.storage.edit(client);
    }

    @Override
    public void delete(final int id) {
        this.storage.delete(id);
    }

    @Override
    public Client get(final int id) {
        return this.storage.get(id);
    }

    @Override
    public Client findByLogin(final String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }

    @Override
    public boolean isCredentional(String login, String password) {
        return this.storage.isCredentional(login, password);
    }
}
