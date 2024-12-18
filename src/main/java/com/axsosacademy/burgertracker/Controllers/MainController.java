package com.axsosacademy.burgertracker.Controllers;

import com.axsosacademy.burgertracker.models.Burger;
import com.axsosacademy.burgertracker.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    private final BurgerService burgerService;

    public MainController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/")
    public String index(
            Model model,
            @ModelAttribute("burger") Burger burger,
            @ModelAttribute("toBeDeletedBurger") Burger toBeDeletedBurger
    ) {
        model.addAttribute("burgers", burgerService.getAllBurgers());
        return "index";
    }

    @PostMapping("/addBurger")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("burgers", burgerService.getAllBurgers());
            return "index";
        }
        else {
            burgerService.addBurger(burger);
            return "redirect:/";
        }
    }
}
