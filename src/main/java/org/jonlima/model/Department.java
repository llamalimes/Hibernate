package org.jonlima.model;
import jakarta.persistence.*;

@Entity
@Table(name = "DEPARTMENT")

public class Department {
    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int did;
    private String name;
    private String state;

    public Department(String name, String state){
        this.name = name;
        this.state = state;
    }

    public Department(){

    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
