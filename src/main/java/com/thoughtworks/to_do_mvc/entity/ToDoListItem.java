package com.thoughtworks.to_do_mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ToDoListItem {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String name;
    private boolean state;

    public ToDoListItem(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public ToDoListItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

