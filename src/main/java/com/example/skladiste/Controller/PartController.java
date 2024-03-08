package com.example.skladiste.Controller;

import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Model.Category;
import com.example.skladiste.Model.Parts;
import com.example.skladiste.Repository.CarModelRepository;
import com.example.skladiste.Repository.CategoryRepository;
import com.example.skladiste.Repository.PartRepository;
import com.example.skladiste.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PartController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarModelRepository carModelRepository;
    @Autowired
    PartRepository partRepository;

    @Autowired
    PartService partService;

    @GetMapping("/showPartForm")
    public String showPartForm(Model model){

        List<Category>categories = this.categoryRepository.findAll();
        List<CarModel> models = this.carModelRepository.findAll();

        model.addAttribute("categories",categories);
        model.addAttribute("models",models);
        model.addAttribute("part",new Parts());

        return "parts/createPart";
    }

    @PostMapping("/createPart")
    public String addPart(Parts parts){

        this.partRepository.save(parts);
        return "redirect:/showAllParts";
    }


    @GetMapping("/showAllParts")
    public String showAllParts(Model model){

        List<Parts> parts = this.partRepository.findAll();

        model.addAttribute("parts",parts);

        return "parts/showParts";
    }

    @PostMapping("/deletePart/{partId}")
    public String deleteOrder(@PathVariable Long partId){

        this.partService.deletePart(partId);

        return "redirect:/showAllParts";
    }
}
