package com.practice.app.maker;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/makers")
public class MakerController {

    private final MakerService makerService;

    public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }

    @GetMapping
    public List<MakerResponseDTO> findAll() {
        return makerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MakerResponseDTO> findById(@PathVariable Long id) {
        return makerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MakerResponseDTO> create(@Valid @RequestBody MakerRequestDTO dto) {
        MakerResponseDTO saved = makerService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MakerResponseDTO> update(@PathVariable Long id, @Valid @RequestBody MakerRequestDTO dto) {
        MakerResponseDTO updated = makerService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        makerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}