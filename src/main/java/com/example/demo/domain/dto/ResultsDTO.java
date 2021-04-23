package com.example.demo.domain.dto;

import java.util.List;

public class ResultsDTO {

    private List<BindingDTO> bindings;

    public List<BindingDTO> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingDTO> bindings) {
        this.bindings = bindings;
    }

    @Override
    public String toString() {
        return "ResultsDTO{" +
                "bindings=" + bindings +
                '}';
    }
}
