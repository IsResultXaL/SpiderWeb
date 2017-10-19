package com.caogen.spiderWeb.dto;

public class JiaYuanVisualization {

    private String name;

    private long  valueMale;

    private long valueFemale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValueMale() {
        return valueMale;
    }

    public void setValueMale(long valueMale) {
        this.valueMale = valueMale;
    }

    public long getValueFemale() {
        return valueFemale;
    }

    public void setValueFemale(long valueFemale) {
        this.valueFemale = valueFemale;
    }

    @Override
    public String toString() {
        return "JiaYuanVisualization{" +
                "name='" + name + '\'' +
                ", valueMale=" + valueMale +
                ", valueFemale=" + valueFemale +
                '}';
    }
}
