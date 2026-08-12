package com.practice.app.maker;

import java.util.List;
import java.util.Optional;

public interface MakerService {

    List<MakerResponseDTO> findAll();

    Optional<MakerResponseDTO> findById(Long id);

    MakerResponseDTO save(MakerRequestDTO dto);

    MakerResponseDTO update(Long id, MakerRequestDTO dto);

    void deleteById(Long id);

}

