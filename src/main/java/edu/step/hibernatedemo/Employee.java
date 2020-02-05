package edu.step.hibernatedemo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "app")
public class Employee implements Serializable {
    
    /**
     * Default serial version Id.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;
    @Column(name = "address", unique = true, nullable = false, length = 100)
    private String address;
    @Column(name = "phoneno", unique = true, nullable = false, length = 100)
    private String phoneno;

    public Employee() {
    }

    public Employee(String name, String address, String phoneno) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", address=" + address + ", phoneno=" + phoneno + "]";
    }

}