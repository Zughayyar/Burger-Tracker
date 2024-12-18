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
    public String edit(@PathVariable Long id, Model model, @ModelAttribute("burger") Burger editedBurger) {
        Burger burger = burgerService.getBurgerById(id);
        model.addAttribute("burger", burger);
        return "edit";
    }



//    @RequestMapping(value = "/burgers/{id}/makeEdit", method = RequestMethod.PUT)
    @PutMapping("/burgers/{id}/makeEdit")
    public String makeEdit(@PathVariable Long id, @Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        else {
            burger.setId(id);
            burgerService.updateBurger(burger);
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/burgers/{id}/makeDelete", method = RequestMethod.DELETE)
    public String makeDelete(@PathVariable Long id) {
        burgerService.deleteBurger(id);
        return "redirect:/";
    }


//    @PutMapping("/burgers/{id}")
//    public String update(
//            @Valid @ModelAttribute("burger") Burger burger,
//            BindingResult result,
//            Model model) {
//        System.out.println("burger: " + burger.getName() + ",   ID:" + burger.getId());
//        if (result.hasErrors()) {
//            model.addAttribute("burger", burger);
//            return "edit";
//        }
//        else {
//            burgerService.updateBurger(burger);
//            return "redirect:/";
//        }
//    }
//
//    @DeleteMapping("/burgers/{id}")
//    public String delete(@PathVariable Long id) {
//        burgerService.deleteBurger(id);
//        return "redirect:/";
//    }
}
