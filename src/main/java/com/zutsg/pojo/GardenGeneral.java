package com.zutsg.pojo;

public class GardenGeneral {
    private Integer id;

    private String gardenintroduction;

    private Integer organizationset;

    private String ingardencondition;

    private String ingardenflow;

    private String ingardenknow;

    public GardenGeneral(Integer id, String gardenintroduction, Integer organizationset, String ingardencondition, String ingardenflow, String ingardenknow) {
        this.id = id;
        this.gardenintroduction = gardenintroduction;
        this.organizationset = organizationset;
        this.ingardencondition = ingardencondition;
        this.ingardenflow = ingardenflow;
        this.ingardenknow = ingardenknow;
    }

    public GardenGeneral() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGardenintroduction() {
        return gardenintroduction;
    }

    public void setGardenintroduction(String gardenintroduction) {
        this.gardenintroduction = gardenintroduction == null ? null : gardenintroduction.trim();
    }

    public Integer getOrganizationset() {
        return organizationset;
    }

    public void setOrganizationset(Integer organizationset) {
        this.organizationset = organizationset;
    }

    public String getIngardencondition() {
        return ingardencondition;
    }

    public void setIngardencondition(String ingardencondition) {
        this.ingardencondition = ingardencondition == null ? null : ingardencondition.trim();
    }

    public String getIngardenflow() {
        return ingardenflow;
    }

    public void setIngardenflow(String ingardenflow) {
        this.ingardenflow = ingardenflow == null ? null : ingardenflow.trim();
    }

    public String getIngardenknow() {
        return ingardenknow;
    }

    public void setIngardenknow(String ingardenknow) {
        this.ingardenknow = ingardenknow == null ? null : ingardenknow.trim();
    }
}