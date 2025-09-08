package com.my.touristAttraction.mapper;

import com.my.touristAttraction.dto.RestaurantDto;
import com.my.touristAttraction.entity.Restaurant;

public class RestaurantMapper {
    public static Restaurant toEntity(RestaurantDto dto) {
        if (dto == null) return null;
        return Restaurant.builder()
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

    public static RestaurantDto toDto(Restaurant entity) {
        if (entity == null) return null;
        RestaurantDto dto = new RestaurantDto();
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
