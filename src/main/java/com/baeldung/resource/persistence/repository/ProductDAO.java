package com.baeldung.resource.persistence.repository;

import com.baeldung.resource.persistence.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchUser(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root r = query.from(Product.class);

        Predicate predicate = builder.conjunction();

        ProductSearchQueryCriteriaConsumer searchConsumer =
                new ProductSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<Product> result = entityManager.createQuery(query).getResultList();
        return result;
    }

    public void save(Product entity) {
        entityManager.persist(entity);
    }
}