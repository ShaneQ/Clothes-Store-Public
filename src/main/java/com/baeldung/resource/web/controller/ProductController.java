package com.baeldung.resource.web.controller;

import com.baeldung.resource.persistence.model.Image;
import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.persistence.model.ProductImage;
import com.baeldung.resource.persistence.model.ProductSize;
import com.baeldung.resource.service.IProductService;
import com.baeldung.resource.web.dto.ImageDTO;
import com.baeldung.resource.web.dto.ProductDTO;
import com.baeldung.resource.web.dto.SizeDTO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/public/product")
public class ProductController {

    private IProductService productService;

    private ModelMapper mapper;

    Converter<ProductSize, SizeDTO> productSize = new AbstractConverter<>() {
        @Override
        protected SizeDTO convert(ProductSize source) {
            if(source != null){
                return new SizeDTO(source.getSize().getId(), source.getSize().getName());
            }
            return null;
        }
    };
    Converter<Image, ImageDTO> coverImage = new AbstractConverter<>() {
        @Override
        protected ImageDTO convert(Image source) {
            if(source != null){
                return new ImageDTO(source.getId(), source.getPath());
            }
            return null;
        }
    };
    Converter<ProductImage, ImageDTO> imagesDTO = new AbstractConverter<>() {
        @Override
        protected ImageDTO convert(ProductImage source) {
            if(source != null){
                return new ImageDTO(source.getId_image().getId(), source.getId_image().getPath());
            }
            return null;
        }
    };
    public ProductController(IProductService productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
        this.mapper.addConverter(productSize);
        this.mapper.addConverter(coverImage);
        this.mapper.addConverter(imagesDTO);
    }

    @GetMapping
    public Collection<ProductDTO> findAll() {
        Iterable<Product> products = this.productService.findAll();
        List<ProductDTO> dtos = new ArrayList<>();
        products.forEach(p -> dtos.add(convertToDto(p)));
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


}
