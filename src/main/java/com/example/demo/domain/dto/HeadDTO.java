package com.example.demo.domain.dto;

import java.util.List;

public class HeadDTO {

    private List<String> vars;

    public List<String> getVars() {
        return vars;
    }

    public void setVars(List<String> vars) {
        this.vars = vars;
    }

    @Override
    public String toString() {
        return "HeadDTO{" +
                "vars=" + vars +
                '}';
    }
}
