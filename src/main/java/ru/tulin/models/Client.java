package ru.tulin.models;

/**
 * describes a class of client
 * @author Viktor Tulin
 * @version 1
 * @since 21.11.2016
 */
public class Client {

    /**
     * id of client
     */
    private int id;

    /**
     * login of client
     */
    private String login;

    /**
     * password of client
     */
    private String password;

    /**
     * pet
     */
    private final Pet pet;

    public Client(int id, String login, String password, Pet pet) {
        this.id = id;
        this.login = login;
        this.pet = pet;
        this.password = password;
    }

    /**
     * getter fo id of client
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * getter for login of client
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * setter for id of client
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * setter for login of client
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * getter for Pet
     * @return Pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
