package com.octa.courierXpress.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cityName;

    @Column
    private boolean hasOffice;

    public City() { super(); }

    public City(String cityName, boolean hasOffice) {
        super();
        this.cityName = cityName;
        this.hasOffice = hasOffice;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCityName() { return cityName; }

    public void setCityName(String cityName) { this.cityName = cityName; }

    public boolean isHasOffice() { return hasOffice; }

    public void setHasOffice(boolean hasOffice) { this.hasOffice = hasOffice; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && hasOffice && Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() { return Objects.hash(id, cityName, hasOffice);}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", hasOffice=" + hasOffice +
                '}';
    }
}
