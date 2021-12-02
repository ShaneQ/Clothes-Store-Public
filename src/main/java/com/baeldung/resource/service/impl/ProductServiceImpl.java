package com.baeldung.resource.service.impl;

import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.persistence.repository.IProductRepository;
import com.baeldung.resource.service.IProductService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository ProductRepository;

    private com.baeldung.resource.persistence.repository.ProductRepository productRepTwo;

    public ProductServiceImpl(IProductRepository productRepository,
            com.baeldung.resource.persistence.repository.ProductRepository productRepTwo) {
        this.ProductRepository = productRepository;
        this.productRepTwo = productRepTwo;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> product = ProductRepository.findById(id);
        if(product.isPresent()){
            if(product.get().isDeleted() || product.get().isHidden()){
                return Optional.empty();
            }else{
                return product;
            }
        }else{
            return Optional.empty();
        }

    }

    @Override
    public Product save(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public Iterable<Product> findAll() {
        return ProductRepository.findByDeletedFalseAndHiddenFalse();
    }

    @Override
    public Iterable<Product> findAll(Specification<Product> spec) {
        return productRepTwo.findAll(spec);
    }
}
