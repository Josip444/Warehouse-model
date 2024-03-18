package com.example.skladiste.Controller;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.Parts;
import com.example.skladiste.Repository.CarBrandRepository;
import com.example.skladiste.Service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import java.util.List;

@Controller
public class CarBrandController {

    @Autowired
    CarBrandService carBrandService;

    @Autowired
    CarBrandRepository carBrandRepository;
    @GetMapping("/showBrandForm")
    public String showBrandForm(Model model){
        model.addAttribute("brand",new CarBrand());
        return "carBrand/createBrand";
    }

    @PostMapping("/createBrand")
    public String createBrand(CarBrand brand, Model model){

        this.carBrandService.save(brand);
        return "redirect:/showAllCarBrands";
    }

    @GetMapping("/showAllCarBrands")
    public String showAllParts(Model model){

        List<CarBrand> carBrands = this.carBrandRepository.findAll();

        model.addAttribute("brands",carBrands);

        return "carBrand/showAllCarBrands";
    }

    @PostMapping("/deleteCarBrand/{id}")
    public String deleteCarBrand(@PathVariable Long id){

        this.carBrandService.deleteCarBrand(id);

        return "redirect:/showAllCarBrands";
    }
}
