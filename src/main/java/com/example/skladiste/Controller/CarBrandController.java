package com.example.skladiste.Controller;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Service.CarBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class CarBrandController {

    private CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;

    }


    @GetMapping("/showBrand")
    public String showBrandForm(Model model){
        model.addAttribute("brand",new CarBrand());
        return "carBrand/createBrand";
    }

    @PostMapping("/showBrand")
    public String createBrand(@Valid CarBrand carBrand, Model model){

        this.carBrandService.save(carBrand);
        return "redirect:/showBrand";
    }
}
