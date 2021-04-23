package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemLabelDTO {

    @JsonProperty("xml:lang")
    private String lang;
    private String type;
    private String value;

    @JsonProperty("xml:lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("xml:lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

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
        return "ItemLabelDTO{" +
                "lang='" + lang + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
