package com.octa.courierXpress.model;

public class ShipmentForUpdateDTO {

    private Long currentCity;
    private String packageStatus;
    private Boolean returnStarted;
    private Boolean packageReturned;

    public Long getCurrentCity() { return currentCity; }

    public void setCurrentCity(Long currentCity) { this.currentCity = currentCity; }

    public String getPackageStatus() { return packageStatus; }

    public void setPackageStatus(String packageStatus) { this.packageStatus = packageStatus; }

    public Boolean getReturnStarted() { return returnStarted; }

    public void setReturnStarted(Boolean returnStarted) { this.returnStarted = returnStarted; }

    public Boolean getPackageReturned() { return packageReturned; }

    public void setPackageReturned(Boolean packageReturned) { this.packageReturned = packageReturned; }
}
