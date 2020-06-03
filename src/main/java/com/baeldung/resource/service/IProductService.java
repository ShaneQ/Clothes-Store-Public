package com.baeldung.resource.service;

import com.baeldung.resource.persistence.model.Product;

import java.util.Optional;


public interface IProductService {

    Optional<Product> findById(Long id);

    Product save(Product foo);

    Iterable<Product> findAll();

}
