package com.octa.courierXpress.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fromCityId", referencedColumnName = "id")
    private City fromCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="toCityId", referencedColumnName = "id")
    private City toCity;

    @Column
    private Long distance;

    public Route() { super(); }

    public Route(City fromCity, City toCity, Long distance) {
        super();
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public City getFromCity() { return fromCity; }

    public void setFromCity(City fromCity) { this.fromCity = fromCity; }

    public City getToCity() { return toCity; }

    public void setToCity(City toCity) { this.toCity = toCity; }

    public Long getDistance() { return distance; }

    public void setDistance(Long distance) { this.distance = distance;}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id && Objects.equals(fromCity, route.fromCity) && Objects.equals(toCity, route.toCity) && Objects.equals(distance, route.distance);
    }

    @Override
    public int hashCode() { return Objects.hash(id, fromCity, toCity, distance);}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", fromCity='" + fromCity + '\'' +
                ", toCity=" + toCity +
                ", distance=" + distance +
                '}';
    }
}

