package com.baeldung.resource.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean dryClean;

    private String quickDesc;

    private String material;

    private String description;

    private String fittingInfo;
    private String washInfo;

    private double retailPrice;

    private double rentalPrice;



    private String type;

    @OneToOne
    @JoinColumn(name = "id_product_category")
    private ProductCategory category;

    @OneToOne
    @JoinColumn(name = "id_product_measurement")
    private ProductMeasurement measurement;

    @OneToOne
    @JoinColumn(name = "id_cover_img")
    private Image coverImg;

    @OneToMany
    @JoinColumn(name = "id_product")
    private List<ProductOccasion> occasions;

    @OneToMany
    @JoinColumn(name = "id_product")
    private List<ProductSize> sizes;

}
