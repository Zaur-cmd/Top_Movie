package com.example.topmovie.api;

import java.util.List;

public class Root {
    private int page;

    private List<Result> results;

    private int total_pages;

    private int total_results;

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return this.page;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_pages() {
        return this.total_pages;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_results() {
        return this.total_results;
    }
}
