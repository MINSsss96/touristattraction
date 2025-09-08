package com.my.touristAttraction.mapper;

import com.my.touristAttraction.dto.TouristSpotDto;
import com.my.touristAttraction.entity.TouristSpot;

public class TouristSpotMapper {
    public static TouristSpot toEntity(TouristSpotDto dto) {
        if (dto == null) return null;
        return TouristSpot.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .homepage(dto.getHomepage())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .openingHours(dto.getOpeningHours())
                .closedDays(dto.getClosedDays())
                .entranceFee(dto.getEntranceFee())
                .facilities(dto.getFacilities())
                .services(dto.getServices())
                .imageUrl(dto.getImageUrl())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .build();
    }

    public static TouristSpotDto toDto(TouristSpot entity) {
        if (entity == null) return null;
        TouristSpotDto dto = new TouristSpotDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setHomepage(entity.getHomepage());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setOpeningHours(entity.getOpeningHours());
        dto.setClosedDays(entity.getClosedDays());
        dto.setEntranceFee(entity.getEntranceFee());
        dto.setFacilities(entity.getFacilities());
        dto.setServices(entity.getServices());
        dto.setImageUrl(entity.getImageUrl());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        return dto;
    }
}
