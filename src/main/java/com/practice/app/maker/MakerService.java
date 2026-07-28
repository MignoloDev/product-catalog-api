package com.practice.app.maker;

import com.practice.app.entity.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerService {

    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    Maker save(Maker maker);

    void deleteById(Long id);
}


