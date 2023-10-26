package com.octa.courierXpress.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Shipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long packageWeight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="senderId", referencedColumnName = "id")
    private Person sender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="receiverId", referencedColumnName = "id")
    private Person receiver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="routeId", referencedColumnName = "id")
    private Route route;

    @Column
    private Boolean returnStarted;

    @Column
    private Boolean packageReturned;

    @JoinColumn(name="currentCity", referencedColumnName = "id", insertable = true, updatable = true)
    private Long currentCity;

    @Column
    private Long price;

    @Column
    private String packageType;

    @Column
    private String packageStatus;

    public Shipment() { super(); }

    public Shipment(Long packageWeight, Person sender, Person receiver, Route route, Boolean returnStarted, Boolean packageReturned, Long currentCity, Long price, String packageType, String packageStatus) {
        super();
        this.packageWeight = packageWeight;
        this.sender = sender;
        this.receiver = receiver;
        this.route = route;
        this.returnStarted = returnStarted;
        this.packageReturned = packageReturned;
        this.currentCity = currentCity;
        this.price = price;
        this.packageType = packageType;
        this.packageStatus = packageStatus;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getPackageWeight() { return packageWeight; }

    public void setPackageWeight(Long packageWeight) { this.packageWeight = packageWeight; }

    public Person getSender() { return sender; }

    public void setSender(Person sender) {  this.sender = sender; }

    public Person getReceiver() { return receiver; }

    public void setReceiver(Person receiver) { this.receiver = receiver; }

    public Route getRoute() { return route; }

    public void setRoute(Route route) { this.route = route; }

    public Boolean getReturnStarted() { return returnStarted; }

    public void setReturnStarted(Boolean returnStarted) { this.returnStarted = returnStarted; }

    public Boolean getPackageReturned() { return packageReturned; }

    public void setPackageReturned(Boolean packageReturned) { this.packageReturned = packageReturned; }

    public Long getCurrentCity() { return currentCity; }

    public void setCurrentCity(Long currentCity) { this.currentCity = currentCity; }

    public Long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

    public String getPackageType() { return packageType; }

    public void setPackageType(String packageType) { this.packageType = packageType; }

    public String getPackageStatus() { return packageStatus; }

    public void setPackageStatus(String packageStatus) { this.packageStatus = packageStatus; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return id == shipment.id && Objects.equals(packageWeight, shipment.packageWeight) && Objects.equals(sender, shipment.sender) && Objects.equals(receiver, shipment.receiver) && Objects.equals(route, shipment.route) && Objects.equals(returnStarted, shipment.returnStarted) && Objects.equals(packageReturned, shipment.packageReturned) && Objects.equals(currentCity, shipment.currentCity) && Objects.equals(price, shipment.price) && Objects.equals(packageType, shipment.packageType) && Objects.equals(packageStatus, shipment.packageStatus);
    }

    @Override
    public int hashCode() { return Objects.hash(id, packageWeight, sender, receiver, route, returnStarted, packageReturned, currentCity, price, packageType, packageStatus);}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", packageWeight='" + packageWeight + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", route=" + route +
                ", returnStarted=" + returnStarted +
                ", packageReturned=" + packageReturned +
                ", currentCity=" + currentCity +
                ", price=" + price +
                ", packageType=" + packageType +
                ", packageStatus=" + packageStatus +
                '}';
    }
}
