package com.martin.bootstore.boot;

import com.martin.bootstore.brand.BrandService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/boots")
public class BootController {
    private final BootService bootService;
    private final BrandService brandService;

    public BootController(BootService bootService, BrandService brandService) {
        this.bootService = bootService;
        this.brandService = brandService;
    }

    @GetMapping
    String getBoots(Model model) {
        model.addAttribute("boots", bootService.getAllBoots());
        model.addAttribute("id", 1);
        return "boots/boots";
    }

    @GetMapping(path = "/add")
    String addBoot(Model model) {
        Boot boot = new Boot();
        boot.setBootId(-1L);
        model.addAttribute("boot", boot);
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("genders", List.of(BootGender.values()));
        model.addAttribute("types", List.of(BootType.values()));
        return "boots/addBoot";
    }

    @PostMapping(path = "/add")
    String addBoot(@Valid Boot boot, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brands", brandService.getAllBrands());
            model.addAttribute("genders", List.of(BootGender.values()));
            model.addAttribute("types", List.of(BootType.values()));
            return "boots/addBoot";
        }

        bootService.addBoot(boot);
        return "redirect:/boots";
    }

    @GetMapping(path = "/{id}")
    String bootDetails(@PathVariable String id, Model model) {
        Boot boot = bootService.getBootById(Long.parseLong(id));
        model.addAttribute("boot", boot);
        return "boots/bootDetails";
    }

    @GetMapping(path = "/{id}/edit")
    String editBoot(@PathVariable String id, Model model) {
        Boot boot = bootService.getBootById(Long.parseLong(id));
        model.addAttribute("boot", boot);
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("genders", List.of(BootGender.values()));
        model.addAttribute("types", List.of(BootType.values()));
        return "boots/editBoot";
    }

    @PostMapping(path = "/{id}/edit")
    String editBoot(@PathVariable String id, @Valid Boot boot, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brands", brandService.getAllBrands());
            model.addAttribute("genders", List.of(BootGender.values()));
            model.addAttribute("types", List.of(BootType.values()));
            return "boots/editBoot";
        }

        bootService.updateBoot(boot);
        return "redirect:/boots/" + id;
    }

    @GetMapping(path = "/{id}/delete")
    String deleteBoot(@PathVariable String id, Model model) {
        Boot boot = bootService.getBootById(Long.parseLong(id));
        model.addAttribute("boot", boot);
        return "boots/deleteBoot";
    }

    @PostMapping(path = "/{id}/delete")
    String deleteBoot(@PathVariable String id, Boot boot) {
        bootService.deleteBoot(boot);
        return "redirect:/boots";
    }
}
