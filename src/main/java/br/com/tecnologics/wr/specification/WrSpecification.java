package br.com.tecnologics.wr.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class WrSpecification<T> implements Specification<T> {

    private final String key;
    private final String operation;
    private final String value;

    public WrSpecification(String key, String operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        if (root.get(this.key).getJavaType() == String.class) {
            return cb.like(root.get(this.key), "%" + this.value + "%");
        } else {
            return cb.equal(root.get(this.key), this.value);
        }
    }

}
