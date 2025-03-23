package com.martin.bootstore.store;

import com.martin.bootstore.boot.BootService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/store")
public class StoreController {
    private final BootService bootService;

    public StoreController(BootService bootService) {
        this.bootService = bootService;
    }

    @GetMapping
    public String store(ModelMap model) {
        model.addAttribute("boots", bootService.getAllBoots());
        return "store";
    }
}
