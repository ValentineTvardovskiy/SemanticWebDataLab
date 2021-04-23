package com.example.demo.domain.dto;

public class WikiDataDTO {

    private HeadDTO head;
    private ResultsDTO results;

    public HeadDTO getHead() {
        return head;
    }

    public void setHead(HeadDTO head) {
        this.head = head;
    }

    public ResultsDTO getResults() {
        return results;
    }

    public void setResults(ResultsDTO results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "WikiDataDTO{" +
                "head=" + head +
                ", results=" + results +
                '}';
    }
}
