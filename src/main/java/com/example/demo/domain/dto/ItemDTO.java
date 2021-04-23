package com.example.demo.domain.dto;

public class ItemDTO {

    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
