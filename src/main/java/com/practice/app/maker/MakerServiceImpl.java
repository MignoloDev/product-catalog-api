package com.practice.app.maker;

import com.practice.app.entity.Maker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements MakerService{

    private final MakerRepository makerRepository;

    public MakerServiceImpl(MakerRepository makerRepository){
        this.makerRepository = makerRepository;
    }

    @Override
    public List<Maker> findAll(){
        return makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id){
        return makerRepository.findById(id);
    }

    @Override
    public Maker save(Maker maker){
        return makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id){
        makerRepository.deleteById(id);
    }
}
