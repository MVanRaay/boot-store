package com.martin.bootstore.brand;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public String allBrands(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        return "brands/brands";
    }

    @GetMapping(path = "/add")
    public String addBrand(Model model) {
        Brand brand = new Brand();
        brand.setBrandId(-1L);
        model.addAttribute("brand", brand);
        return "brands/addBrand";
    }

    @PostMapping(path = "/add")
    public String addBrand(@Valid Brand brand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "brands/addBrand";
        }

        brandService.addBrand(brand);
        return "redirect:/brands";
    }

    @GetMapping(path = "/{id}")
    public String brandDetails(@PathVariable String id, Model model) {
        model.addAttribute("brand", brandService.getBrand(Long.parseLong(id)));
        return "brands/brandDetails";
    }

    @GetMapping(path = "/{id}/edit")
    public String editBrand(@PathVariable String id, Model model) {
        model.addAttribute("brand", brandService.getBrand(Long.parseLong(id)));
        return "brands/editBrand";
    }

    @PostMapping(path = "/{id}/edit")
    public String editBrand(@PathVariable String id, @Valid Brand brand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "brands/editBrand";
        }

        brandService.updateBrand(brand);
        return "redirect:/brands/" + id;
    }

    @GetMapping(path = "/{id}/delete")
    public String deleteBrand(@PathVariable String id, Model model) {
        model.addAttribute("brand", brandService.getBrand(Long.parseLong(id)));
        return "brands/deleteBrand";
    }

    @PostMapping(path = "/{id}/delete")
    public String deleteBrand(@PathVariable String id, Brand brand) {
        brandService.deleteBrand(brand);
        return "redirect:/brands";
    }
}
