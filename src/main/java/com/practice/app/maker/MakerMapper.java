package com.practice.app.maker;

import com.practice.app.entity.Maker;
import org.springframework.stereotype.Component;

@Component
public class MakerMapper {

    public Maker toEntity(MakerRequestDTO dto){
        return Maker.builder()
                .name(dto.name())
                .country(dto.country())
                .email(dto.email())
                .phone(dto.phone())
                .build();
    }

    public MakerResponseDTO toResponseDTO(Maker maker){
        return new MakerResponseDTO(
                maker.getId(),
                maker.getName(),
                maker.getCountry(),
                maker.getEmail(),
                maker.getPhone()
        );
    }
}
