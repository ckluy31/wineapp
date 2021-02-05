package com.example.winestats.breakdown;

import java.util.List;

public class Wine {
    // wine model to store the details of each wine
    private String lotCode;
    private Double volume;
    private String description;
    private String tankCode;
    private String productState;
    private String ownerName;
    private List<BreakdownComponent> componentList;

    public Wine(){

    }

    public Wine(String lotCode, Double volume, String description, String tankCode, String productState, String ownerName, List<BreakdownComponent> componentList) {
        this.lotCode = lotCode;
        this.volume = volume;
        this.description = description;
        this.tankCode = tankCode;
        this.productState = productState;
        this.ownerName = ownerName;
        this.componentList = componentList;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTankCode() {
        return tankCode;
    }

    public void setTankCode(String tankCode) {
        this.tankCode = tankCode;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<BreakdownComponent> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<BreakdownComponent> componentList) {
        this.componentList = componentList;
    }
}
