package com.my.touristAttraction.mapper;

import com.my.touristAttraction.dto.AccommodationDto;
import com.my.touristAttraction.entity.Accommodation;

public class AccommodationMapper {
    public static Accommodation toEntity(AccommodationDto dto) {
        if (dto == null) return null;
        return Accommodation.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .homepage(dto.getHomepage())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .roomCount(dto.getRoomCount())
                .amenities(dto.getAmenities())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .build();
    }

    public static AccommodationDto toDto(Accommodation entity) {
        if (entity == null) return null;
        AccommodationDto dto = new AccommodationDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setHomepage(entity.getHomepage());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setRoomCount(entity.getRoomCount());
        dto.setAmenities(entity.getAmenities());
        dto.setPrice(entity.getPrice());
        dto.setImageUrl(entity.getImageUrl());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        return dto;
    }
}
