package com.example.skladiste.Controller;

import com.example.skladiste.Model.*;
import com.example.skladiste.Repository.CarBrandRepository;
import com.example.skladiste.Repository.CarModelRepository;
import com.example.skladiste.Repository.CategoryRepository;
import com.example.skladiste.Repository.PartRepository;
import com.example.skladiste.Service.CarModelService;
import com.example.skladiste.Service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    CarBrandRepository carBrandRepository;

    @Autowired
    CarModelService carModelService;

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
    public String showAllParts(@RequestParam(defaultValue = "0") int page,Model model){

        PageRequest pageable = PageRequest.of(page, MaxPerPage.MAX_PER_PAGE.getValue());
        Page<Parts> parts = partRepository.findAll(pageable);

        model.addAttribute("parts",parts.getContent());
        model.addAttribute("currentPage", parts.getNumber());
        model.addAttribute("totalPages", parts.getTotalPages());
        return "parts/showParts";
    }

    @PostMapping("/deletePart/{partId}")
    public String deleteOrder(@PathVariable Long partId){

        this.partService.deletePart(partId);

        return "redirect:/showAllParts";
    }

    @GetMapping("/searchForm")
    public String showProduct(Model model){

        List<Category>categories = this.categoryRepository.findAll();
        List<CarModel> models = this.carModelRepository.findAll();
        List<CarBrand>brands = this.carBrandRepository.findAll();

        model.addAttribute("brands",brands);
        model.addAttribute("models",models);
        model.addAttribute("categories",categories);

        return "parts/searchParts";
    }

    @GetMapping("/searchParts")
    public String searchParts(@RequestParam(name = "brand",required = true)Long brandId,
                              @RequestParam(name= "model",required = true)Long modelId,
                              @RequestParam(name="category",required = true)Long categoryId,
                              @RequestParam(defaultValue = "0") int page,Model model){

        PageRequest pageable = PageRequest.of(page, MaxPerPage.MAX_PER_PAGE.getValue());
        Page<Parts> parts = this.partService.findPartsBySearch(brandId,modelId,categoryId,pageable);

        model.addAttribute("parts",parts);
        model.addAttribute("currentPage", parts.getNumber());
        model.addAttribute("totalPages", parts.getTotalPages());
        return "parts/showParts";
    }

    @GetMapping("/search")
    public String searchByPartsName(Model model,
                                    @RequestParam("search")String search,
                                    @RequestParam(defaultValue = "0") int page){

        PageRequest pageable = PageRequest.of(page, MaxPerPage.MAX_PER_PAGE.getValue());
        Page<Parts> parts = this.partService.searchPartsByName(search,pageable);

        model.addAttribute("parts",parts.getContent());
        model.addAttribute("currentPage", parts.getNumber());
        model.addAttribute("totalPages", parts.getTotalPages());
        return "parts/showParts";
    }
}
