package com.baeldung.resource.service;

import com.baeldung.resource.persistence.model.Product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;

public interface IProductService {

    Optional<Product> findById(Long id);

    Product save(Product foo);

    Iterable<Product> findAll();

    Iterable<Product> findAll(Specification<Product> spec);
}
