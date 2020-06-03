package com.baeldung.resource.service.impl;

import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.persistence.repository.IProductRepository;
import com.baeldung.resource.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository ProductRepository;

    public ProductServiceImpl(IProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return ProductRepository.findById(id);
    }

    @Override
    public Product save(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public Iterable<Product> findAll() {
        return ProductRepository.findAll();
    }
}
