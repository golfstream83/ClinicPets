package ru.tulin.store;

import org.junit.Test;
import ru.tulin.models.Client;

import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 01.12.2016
 */
public class JdbcStorageTest {

    @Test
    public void testCreate() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final int id = storage.add(new Client(-1, "test", null, null));
        final Client client = storage.get(id);
        assertEquals(id, client.getId());
        storage.close();
    }

}