package com.martin.bootstore.brand;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand getBrand(Long id) {
        if (brandRepository.findById(id).isPresent()) {
            return brandRepository.findById(id).get();
        }
        throw new IllegalArgumentException("No brand found");
    }

    public List<Brand> getAllBrands() {
        List<Brand> boots = brandRepository.findAll();

        if (boots.isEmpty()) {
            throw new IllegalStateException("No brand found");
        }

        return boots;
    }

    public void addBrand(Brand brand) {brandRepository.save(brand);}

    public void updateBrand(Brand brand) {brandRepository.save(brand);}

    public void deleteBrand(Brand brand) {brandRepository.delete(brand);}
}
