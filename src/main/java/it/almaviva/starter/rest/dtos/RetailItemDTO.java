package it.almaviva.starter.rest.dtos;

import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class RetailItemDTO {

    private Long id;
    private String title;
    private String description;
    private Integer currentPrice;

    public static RetailItemDTO fromRetailItemEntity(RetailItemEntity retailItemEntity) {
        RetailItemDTOBuilder retailItemBuilder = RetailItemDTO.builder();
        return retailItemBuilder
            .id(retailItemEntity.getId())
            .title(retailItemEntity.getTitle())
            .description(retailItemEntity.getDescription())
            .currentPrice(retailItemEntity.getCurrentPrice().getPrice())
            .build();
    }
}
