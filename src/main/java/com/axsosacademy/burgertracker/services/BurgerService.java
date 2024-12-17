package com.axsosacademy.burgertracker.services;


import com.axsosacademy.burgertracker.models.Burger;
import com.axsosacademy.burgertracker.repositories.BurgerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    // returns all the books
    public List<Burger> getAllBurgers() {
        return burgerRepository.findAll();
    }

    // Add burger
    public void addBurger(Burger burger) {
        burgerRepository.save(burger);
    }

    // Update burger
    public void updateBurger(Burger burger) {
        burgerRepository.save(burger);
    }

    // Delete burger
    public void deleteBurger(Burger burger) {
        burgerRepository.delete(burger);
    }


}
