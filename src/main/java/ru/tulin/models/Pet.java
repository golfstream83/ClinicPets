package ru.tulin.models;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 21.11.2016
 */
public abstract class Pet {

    /**
     * name of pet
     */
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    /**
     * getter for name of pet
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name of pet
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
