package com.practice.app.maker;

import com.practice.app.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakerRepository extends JpaRepository<Maker, Long> {
}
