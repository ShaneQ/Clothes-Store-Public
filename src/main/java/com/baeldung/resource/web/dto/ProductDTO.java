package com.baeldung.resource.web.dto;

import com.baeldung.resource.persistence.model.Image;
import com.baeldung.resource.persistence.model.ProductImage;
import com.baeldung.resource.persistence.model.ProductSize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private String imagePath;
    private String type;
    private String description;
    private Image coverImg;
    private List<ProductSize> sizes;
}