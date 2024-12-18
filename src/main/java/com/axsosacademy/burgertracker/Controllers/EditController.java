package com.axsosacademy.burgertracker.Controllers;

import com.axsosacademy.burgertracker.models.Burger;
import com.axsosacademy.burgertracker.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditController {
    private final BurgerService burgerService;

    public EditController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/burgers/{id}/edit")
    public String edit(@PathVariable Long id,
                       Model model,
                       @ModelAttribute("burger") Burger editedBurger) {
        Burger burger = burgerService.getBurgerById(id);
        model.addAttribute("burger", burger);
        return "edit";
    }



//    @RequestMapping(value = "/burgers/{id}/makeEdit", method = RequestMethod.PUT)
//    @PutMapping("/burgers/{id}/makeEdit")
    @RequestMapping(value = "/burgers/makeEdit", method = RequestMethod.POST)
    public String makeEdit(
            @Valid @ModelAttribute("burger") Burger burger,
            BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        else {
            burgerService.updateBurger(burger);
            return "redirect:/";
        }

    }

//    @RequestMapping(value = "/burgers/{id}/makeDelete", method = RequestMethod.DELETE)
    @RequestMapping(value = "/burgers/makeDelete", method = RequestMethod.POST)
    public String makeDelete(@ModelAttribute("toBeDeletedBurger") Burger toBeDeletedBurger
    ) {
        System.out.println("Id: " + toBeDeletedBurger.getId() + ".");
        burgerService.deleteBurger(toBeDeletedBurger);
        return "redirect:/";
    }

}
