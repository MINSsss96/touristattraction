package com.my.touristAttraction.mapper;

import com.my.touristAttraction.dto.LeisureDto;
import com.my.touristAttraction.entity.Leisure;

public class LeisureMapper {
    public static Leisure toEntity(LeisureDto dto) {
        if (dto == null) return null;
        return Leisure.builder()
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

    public static LeisureDto toDto(Leisure entity) {
        if (entity == null) return null;
        LeisureDto dto = new LeisureDto();
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
