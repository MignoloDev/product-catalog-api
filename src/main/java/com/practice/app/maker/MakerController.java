package com.practice.app.maker;

import com.practice.app.entity.Maker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maker")
public class MakerController {

    private final MakerService makerService;

    public MakerController(MakerService makerService){
        this.makerService = makerService;
    }

    @GetMapping
    public List<Maker> findAll(){
        return makerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maker> findById(@PathVariable Long id){
        return makerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Maker> create(@RequestBody Maker maker){
        Maker saved = makerService.save(maker);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maker> update(@PathVariable Long id, @RequestBody Maker maker){
        return makerService.findById(id)
                .map(existing->{
                    maker.setId(id);
                    Maker updated = makerService.save(maker);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        makerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
