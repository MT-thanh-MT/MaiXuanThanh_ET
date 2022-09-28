package com.rrssys.controller;

import com.rrssys.entity.Furniture;
import com.rrssys.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rental-furniture")
public class FurnitureRentalController {
    @Autowired
    private FurnitureServiceImpl furnitureService;
    @GetMapping("/list")
    public String listFurniture(Model model){
        model.addAttribute("furniture", new Furniture());
        List<Furniture> listFurniture = furnitureService.getAll();
        model.addAttribute("listFurniture",listFurniture);
        return "furniture";
    }
    @PostMapping("/save")
    public String save(Model model, @ModelAttribute("furniture")Furniture furniture) {

        furnitureService.add(furniture);
        List<Furniture> listFurniture = furnitureService.getAll();
        model.addAttribute("listFurniture",listFurniture);
        model.addAttribute("furniture", furniture);
        return "furniture";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        furnitureService.delete(id);
        List<Furniture> listFurniture = furnitureService.getAll();
        model.addAttribute("listFurniture",listFurniture);
        model.addAttribute("furniture", new Furniture());
        return "furniture";
    }
    @GetMapping("/search")
    public String findBySeri(@RequestParam("seriSeach") Long seriSeach, Model model) {
        List<Furniture> listFurniture = new ArrayList<>();
        Furniture furniture;
        try {
            furniture = furnitureService.getBySeri(seriSeach);
            listFurniture.add(furniture);
        } catch (Exception e) {
            furniture = new Furniture();
        }
        model.addAttribute("listFurniture",listFurniture);
        model.addAttribute("furniture", furniture);
        model.addAttribute("seriSeach", seriSeach);

        return "furniture";
    }
}
