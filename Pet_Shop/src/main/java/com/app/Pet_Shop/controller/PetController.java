package com.app.Pet_Shop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.Pet_Shop.entity.Pet;
import com.app.Pet_Shop.service.PetService;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public String listPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets";
    }

    @GetMapping("/{id}")
    public String viewPet(@PathVariable Long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id).orElse(null));
        return "pet-view";
    }

    @GetMapping("/new")
    public String newPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "pet-form";
    }

    @PostMapping
    public String savePet(@ModelAttribute Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String editPetForm(@PathVariable Long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id).orElse(null));
        return "pet-form";
    }

    @PostMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/pets";
    }
}
