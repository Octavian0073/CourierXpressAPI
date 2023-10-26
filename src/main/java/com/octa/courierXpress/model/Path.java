package com.octa.courierXpress.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Path implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fromCityId", referencedColumnName = "id", insertable = true, updatable = true)
    private City fromCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="toCityId1", referencedColumnName = "id", insertable = true, updatable = true)
    private City toCity1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="toCityId2", referencedColumnName = "id", insertable = true, updatable = true)
    private City toCity2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="toCityId3", referencedColumnName = "id", insertable = true, updatable = true)
    private City toCity3;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="toCityId4", referencedColumnName = "id", insertable = true, updatable = true)
    private City toCity4;
    public Path() { super(); }

    public Path(City fromCity, City toCity1, City toCity2, City toCity3, City toCity4) {
        super();
        this.fromCity = fromCity;
        this.toCity1 = toCity1;
        this.toCity2 = toCity2;
        this.toCity3 = toCity3;
        this.toCity4 = toCity4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public City getFromCity() { return fromCity; }

    public void setFromCity(City fromCity) { this.fromCity = fromCity; }

    public City getToCity1() { return toCity1; }

    public void setToCity1(City toCity1) { this.toCity1 = toCity1; }

    public City getToCity2() { return toCity2; }

    public void setToCity2(City toCity2) { this.toCity2 = toCity2; }

    public City getToCity3() { return toCity3; }

    public void setToCity3(City toCity3) { this.toCity3 = toCity3; }

    public City getToCity4() { return toCity4; }

    public void setToCity4(City toCity4) { this.toCity4 = toCity4; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return id == path.id && Objects.equals(fromCity, path.fromCity) && Objects.equals(toCity1, path.toCity1) && Objects.equals(toCity2, path.toCity2) && Objects.equals(toCity3, path.toCity3) && Objects.equals(toCity4, path.toCity4);
    }

    @Override
    public int hashCode() { return Objects.hash(id, fromCity, toCity1, toCity2, toCity3, toCity4);}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", fromCity='" + fromCity + '\'' +
                ", toCity1=" + toCity1 +
                ", toCity2=" + toCity2 +
                ", toCity3=" + toCity3 +
                ", toCity4=" + toCity4 +
                '}';
    }
}
