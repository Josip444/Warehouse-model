package com.example.skladiste.Controller;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Repository.CarBrandRepository;
import com.example.skladiste.Repository.CarModelRepository;
import com.example.skladiste.Service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarModelController {

    @Autowired
    CarBrandRepository carBrandRepository;
    @Autowired
    CarModelRepository carModelRepository;
    @Autowired
    CarModelService carModelService;
    @GetMapping("/showModelForm")
    public String showBrandForm(Model model){

        List<CarBrand> brands = this.carBrandRepository.findAll();

        model.addAttribute("brands",brands);
        model.addAttribute("carModel",new CarModel());

        return "model/createModel";
    }
    @PostMapping("/createModel")
    public String createBrand(CarModel carModel, Model model){

        this.carModelRepository.save(carModel);
        return "redirect:/showCarModels";
    }

    @GetMapping("/showCarModels")
    public String showCarModels(Model model){

        List<CarModel> carModel = this.carModelRepository.findAll();
        model.addAttribute("carModel",carModel);

        return "model/showModels";
    }

    @PostMapping("/deleteCarModel/{id}")
    public String deleteOrder(@PathVariable Long id){

        this.carModelService.deleteCarModel(id);
        return "redirect:/showCarModels";
    }
}
