package com.baeldung.resource.web.controller;

import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.service.IProductService;
import com.baeldung.resource.web.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private IProductService productService;

    private ModelMapper mapper;


    public ProductController(IProductService productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public Collection<ProductDTO> findAll() {
        Iterable<Product> products = this.productService.findAll();
        List<ProductDTO> dtos = new ArrayList<>();
        products.forEach(p -> dtos.add(mapper.map(p, ProductDTO.class)));
        return dtos;
    }

    protected ProductDTO convertToDto(Product entity) {
        return mapper.map(entity, ProductDTO.class);
    }

    protected Product convertToEntity(ProductDTO dto) {
        return mapper.map(dto, Product.class);
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findOne(Principal principal, @PathVariable Long id) {
        Product entity = productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody ProductDTO newFoo) {
        Product entity = convertToEntity(newFoo);
        this.productService.save(entity);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO dto) {
        Product entity = convertToEntity(dto);
        return this.convertToDto(this.productService.save(entity));
    }
}
