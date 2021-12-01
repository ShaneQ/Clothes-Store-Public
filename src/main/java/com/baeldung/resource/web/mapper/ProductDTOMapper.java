package com.baeldung.resource.web.mapper;

import com.baeldung.resource.persistence.model.Product;
import com.baeldung.resource.web.dto.ImageDTO;
import com.baeldung.resource.web.dto.ProductDTO;
import com.baeldung.resource.web.dto.ProductMeasurementDTO;
import com.baeldung.resource.web.dto.SizeDTO;
import java.util.stream.Collectors;

public class ProductDTOMapper {

    public static ProductDTO convertToDto(Product entity) {
        ProductDTO dto = ProductDTO.builder()
                .description(entity.getDescription())
                .dryClean(entity.isDryClean())
                .id(entity.getId())
                .fittingInfo(entity.getFittingInfo())
                .imgCover(new ImageDTO(entity.getImgCover().getId(), entity.getImgCover().getPath()))
                .quickDesc(entity.getQuickDesc())
                .material(entity.getMaterial())
                .washInfo(entity.getWashInfo())
                .name(entity.getName())
                .color(entity.getColor().getId())
                .season(entity.getSeason().getId())
                .productCategory(entity.getCategory().getId())
                .retailPrice(entity.getRetailPrice())
                .build();
        dto.setImages(entity.getImages().stream().map(entityImage -> new ImageDTO(entityImage.getId_image().getId(), entityImage.getId_image().getPath())).collect(
                Collectors.toList()));
        dto.setMeasurements(new ProductMeasurementDTO(entity.getMeasurement().getLength(),entity.getMeasurement().getChest(),entity.getMeasurement().getHips(),entity.getMeasurement().getWaist()));
        dto.setSizes(entity.getSizes().stream().map( entitySize -> new SizeDTO(entitySize.getSize().getId(), entitySize.getSize().getName())).collect(Collectors.toList()));
        return dto;
    }
}
