package com.zutsg.pojo;

public class GardenGeneral {
    private Integer id;

    private String gardenIntroduction;

    private Integer organizationSet;

    private String inGardenCondition;

    private String inGardenFlow;

    private String inGardenKnow;

    public GardenGeneral(Integer id, String gardenIntroduction, Integer organizationSet, String inGardenCondition, String inGardenFlow, String inGardenKnow) {
        this.id = id;
        this.gardenIntroduction = gardenIntroduction;
        this.organizationSet = organizationSet;
        this.inGardenCondition = inGardenCondition;
        this.inGardenFlow = inGardenFlow;
        this.inGardenKnow = inGardenKnow;
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

    public String getGardenIntroduction() {
        return gardenIntroduction;
    }

    public void setGardenIntroduction(String gardenIntroduction) {
        this.gardenIntroduction = gardenIntroduction;
    }

    public Integer getOrganizationSet() {
        return organizationSet;
    }

    public void setOrganizationSet(Integer organizationSet) {
        this.organizationSet = organizationSet;
    }

    public String getInGardenCondition() {
        return inGardenCondition;
    }

    public void setInGardenCondition(String inGardenCondition) {
        this.inGardenCondition = inGardenCondition;
    }

    public String getInGardenFlow() {
        return inGardenFlow;
    }

    public void setInGardenFlow(String inGardenFlow) {
        this.inGardenFlow = inGardenFlow;
    }

    public String getInGardenKnow() {
        return inGardenKnow;
    }

    public void setInGardenKnow(String inGardenKnow) {
        this.inGardenKnow = inGardenKnow;
    }
}