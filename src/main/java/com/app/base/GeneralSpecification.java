package com.app.base;


import com.app.model.Item;
import com.app.model.Uom;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralSpecification<T> implements Specification<T> {

    private SearchCriteria searchCriteria;

    public GeneralSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public GeneralSpecification() {

    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicateList = new ArrayList<>();

        if (searchCriteria.getValue() != null && searchCriteria.getValue().toString() != ""){
            if(searchCriteria.getSearchOperation().equals(SearchOperation.MATCH)){
                for (String key : searchCriteria.getKey()) {
                    predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(key)), "%" + searchCriteria.getValue().toString().toLowerCase() + "%"));
                }
            }
            return criteriaBuilder.or(predicateList.toArray(new Predicate[predicateList.size()]));
        }

        return null;
    }

    public Specification<T> joinUom(String search) {
        return (root, query, criteriaBuilder) -> {
            Join<T, Uom> uomJoin = root.join("uom");
            Predicate equalPredicate = criteriaBuilder.like(criteriaBuilder.lower(uomJoin.get("name")), "%" + search.toLowerCase() + "%");
            return equalPredicate;
        };
    }
}
