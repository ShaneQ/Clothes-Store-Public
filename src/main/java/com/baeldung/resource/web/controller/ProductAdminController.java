package com.baeldung.resource.web.controller;

import com.baeldung.resource.persistence.model.Image;
import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.persistence.model.ProductImage;
import com.baeldung.resource.persistence.model.ProductSize;
import com.baeldung.resource.persistence.model.Size;
import com.baeldung.resource.service.IProductService;
import com.baeldung.resource.web.dto.ImageDTO;
import com.baeldung.resource.web.dto.ProductDTO;

import com.baeldung.resource.web.dto.SizeDTO;
import java.util.ArrayList;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/private/product")
public class ProductAdminController {

    private IProductService productService;

    private ModelMapper mapper;


    public ProductAdminController(IProductService productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    protected ProductDTO convertToDto(Product entity) {
        return mapper.map(entity, ProductDTO.class);
    }

    protected Product convertToEntity(ProductDTO dto) {
        Product product = mapper.map(dto, Product.class);
        ArrayList<ProductSize> productSizes = new ArrayList<>();
        for (SizeDTO size : dto.getSizes()){
            ProductSize productSize = new ProductSize();
            productSize.setSize(new Size(size.getId(), null));
            productSizes.add(productSize);
        }
        Image coverImage = new Image();
        coverImage.setPath(dto.getImgCover().getUrl());
        product.setImgCover(coverImage);
        product.setSizes(productSizes);
        if(dto.getImages() != null){
            ArrayList<ProductImage> productImages = new ArrayList<>();
            for(ImageDTO imageDTO : dto.getImages()){
                ProductImage productImage = new ProductImage();
                Image image = new Image();
                image.setPath(imageDTO.getUrl());
                productImage.setId_image(image);
                productImages.add(productImage);
            }
            product.setImages(productImages);
        }

        return product;
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
