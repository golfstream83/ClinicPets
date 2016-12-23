package ru.tulin.store;

import ru.tulin.models.Client;
import ru.tulin.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 30.11.2016
 */
public class JdbcStorage implements Storage {

    private Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();

        try {
            Class.forName(settings.value("jdbc.driver_class"));
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Client> values() {
        final List<Client> clients = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from client")) {
            while (rs.next()) {
                clients.add(new Client(rs.getInt("uid"), rs.getString("name"), null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public int add(Client client) {
        try (final PreparedStatement statement = this.connection.prepareStatement(
                "insert into client (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getLogin());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public void edit(Client client) {
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE client SET name = (?) where uid = (?)")) {
            statement.setString(1, client.getLogin());
            statement.setInt(2, client.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("delete from client where uid = (?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from client where uid=(?)")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Client(rs.getInt("uid"), rs.getString("name"), null, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User %s does not exists", id));
    }

    @Override
    public Client findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCredentional(String login, String password) {
        return false;
    }
}
