package com.martin.bootstore.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/boots")
public class BootController {
    private final BootService bootService;

    public BootController(BootService bootService) {
        this.bootService = bootService;
    }

    @GetMapping
    String getBoots(Model model) {
        model.addAttribute("something", "this is coming from the controller");
        model.addAttribute("boots", bootService.getAllBoots());
        model.addAttribute("id", 1);
        return "boots";
    }

    @GetMapping(path = "/add")
    String addBoot(Model model) {
        model.addAttribute("boot", new Boot());
        return "addBoot";
    }

    @PostMapping(path = "/add")
    String addBoot(Boot boot) {
        bootService.addBoot(boot);
        return "redirect:/boots";
    }

    @GetMapping(path = "/{id}")
    String bootDetails(@PathVariable String id, Model model) {
        Boot boot = bootService.getBootById(Long.parseLong(id));
        model.addAttribute("boot", boot);
        return "bootDetails";
    }

    @GetMapping(path = "/{id}/edit")
    String editBoot(@PathVariable String id, Model model) {
        Boot boot = bootService.getBootById(Long.parseLong(id));
        model.addAttribute("boot", boot);
        return "editBoot";
    }

    @PostMapping(path = "/{id}/edit")
    String editBoot(@PathVariable String id, Boot boot) {
        bootService.updateBoot(boot);
        return "redirect:/boots/" + id;
    }
}
