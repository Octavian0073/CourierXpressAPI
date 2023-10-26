package com.octa.courierXpress.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String roleName;

    public Roles() { super(); }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getRoleName() { return roleName; }

    public void setRoleName(String roleName) { this.roleName = roleName; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return id == roles.id && Objects.equals(roleName, roles.roleName);
    }

    @Override
    public int hashCode() { return Objects.hash(id, roleName);}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + roleName + '\'' +
                '}';
    }
}
