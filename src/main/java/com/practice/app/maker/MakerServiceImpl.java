package com.practice.app.maker;

import com.practice.app.entity.Maker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements MakerService {

    private final MakerRepository makerRepository;
    private final MakerMapper makerMapper;

    public MakerServiceImpl(MakerRepository makerRepository, MakerMapper makerMapper) {
        this.makerRepository = makerRepository;
        this.makerMapper = makerMapper;
    }

    @Override
    public List<MakerResponseDTO> findAll() {
        return makerRepository.findAll()
                .stream()
                .map(makerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public Optional<MakerResponseDTO> findById(Long id) {
        return makerRepository.findById(id)
                .map(makerMapper::toResponseDTO);
    }

    @Override
    public MakerResponseDTO save(MakerRequestDTO dto) {
        Maker maker = makerMapper.toEntity(dto);
        Maker saved = makerRepository.save(maker);
        return makerMapper.toResponseDTO(saved);
    }

    @Override
    public MakerResponseDTO update(Long id, MakerRequestDTO dto) {
        Maker maker = makerMapper.toEntity(dto);
        maker.setId(id);
        Maker updated = makerRepository.save(maker);
        return makerMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }

}