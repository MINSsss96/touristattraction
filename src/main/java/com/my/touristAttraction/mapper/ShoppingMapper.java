package com.my.touristAttraction.mapper;

import com.my.touristAttraction.dto.ShoppingDto;
import com.my.touristAttraction.entity.Shopping;

public class ShoppingMapper {
    public static Shopping toEntity(ShoppingDto dto) {
        if (dto == null) return null;
        return Shopping.builder()
                .id(dto.getId())
                .name(dto.getName())
                .region(dto.getRegion())
                .type(dto.getType())
                .description(dto.getDescription())
                .imageUrl(dto.getImageUrl())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }

    public static ShoppingDto toDto(Shopping entity) {
        if (entity == null) return null;
        ShoppingDto dto = new ShoppingDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRegion(entity.getRegion());
        dto.setType(entity.getType());
        dto.setDescription(entity.getDescription());
        dto.setImageUrl(entity.getImageUrl());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        return dto;
    }
}
