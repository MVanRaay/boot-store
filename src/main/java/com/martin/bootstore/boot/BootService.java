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

    public Boot getBootById(Long id) {
        if (bootRepository.findById(id).isPresent()) {
            return bootRepository.findById(id).get();
        }
        throw new IllegalStateException("No boot found");
    }

    public void addBoot(Boot boot) {
        bootRepository.save(boot);
    }

    public void updateBoot(Boot boot) { bootRepository.save(boot); }

    public void deleteBoot(Boot boot) { bootRepository.delete(boot); }
}
