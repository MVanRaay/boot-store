package com.martin.bootstore.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootService {
    private final BootRepository bootRepository;

    @Autowired
    public BootService(BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }

    public List<Boot> getAllBoots() {
        List<Boot> boots = bootRepository.findAll();
        if (boots.isEmpty()) {
            throw new IllegalStateException("No boots found");
        }
        return boots;
    }
}
