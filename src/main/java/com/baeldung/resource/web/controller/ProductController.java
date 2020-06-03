package com.baeldung.resource.web.controller;

import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.service.IProductService;
import com.baeldung.resource.web.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @CrossOrigin(origins = "http://localhost:8089")
    public Collection<ProductDTO> findAll() {
        Iterable<Product> products = this.productService.findAll();
        List<ProductDTO> dtos = new ArrayList<>();
        products.forEach(p -> dtos.add(convertToDto(p)));
        return dtos;
    }

    protected ProductDTO convertToDto(Product entity) {
        ProductDTO dto = new ProductDTO(entity.getId(), entity.getName(),entity.getImagePath(), entity.getType());

        return dto;
    }

    protected Product convertToEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        if (!StringUtils.isEmpty(dto.getId())) {
            entity.setId(dto.getId());
        }
        return entity;
    }


    @GetMapping(value = "/{id}")
    public ProductDTO findOne(@PathVariable Long id) {
        Product entity = productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @CrossOrigin(origins = "http://localhost:8089")
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
