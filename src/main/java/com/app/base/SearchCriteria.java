package com.app.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCriteria {
    private List <String> key = new ArrayList<>();
    private  Object value;
    private SearchOperation searchOperation;

    public SearchCriteria() {
    }

    public SearchCriteria(Object value, SearchOperation searchOperation,  String... key) {
        this.key.addAll(Arrays.asList(key));
        this.value = value;
        this.searchOperation = searchOperation;
    }

    public List<String> getKey() {
        return key;
    }

    public void setKey(List<String> key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchOperation getSearchOperation() {
        return searchOperation;
    }

    public void setSearchOperation(SearchOperation searchOperation) {
        this.searchOperation = searchOperation;
    }
}
