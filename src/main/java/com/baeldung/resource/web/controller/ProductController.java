package com.baeldung.resource.web.controller;

import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.service.IProductService;
import com.baeldung.resource.web.dto.ProductDTO;
import com.baeldung.resource.web.mapper.ProductDTOMapper;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService, ModelMapper mapper) {
        this.productService = productService;
    }

    @GetMapping
    public Collection<ProductDTO> findAll() {
        Iterable<Product> products = this.productService.findAll();
        List<ProductDTO> dtos = new ArrayList<>();
        products.forEach(entity -> dtos.add(ProductDTOMapper.convertToDto(entity)));
        return dtos;
    }

}
