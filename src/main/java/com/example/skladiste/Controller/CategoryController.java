package com.example.skladiste.Controller;

import com.example.skladiste.Model.Category;
import com.example.skladiste.Repository.CategoryRepository;
import com.example.skladiste.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/showCategoryForm")
    public String addCategory(Model model){

        model.addAttribute("category",new Category());
        return "Category/createCategory";
    }
    @PostMapping("/createCategory")
    public String createCategory(Category category){

        this.categoryRepository.save(category);
        return "redirect:/showCategories";
    }


    @GetMapping("/showCategories")
    public String showCategories(Model model){

        List<Category>category=this.categoryRepository.findAll();

        model.addAttribute("category",category);
        return "Category/showCategories";
    }

    @PostMapping("/deleteCarCategory/{id}")
    public String deleteCarCategory(@PathVariable Long id){

        this.categoryService.deleteCarCategory(id);

        return "redirect:/showCategories";
    }

    @PostMapping ("/updateCarCategory/{id}")
    public String updateCarCategoryForm(Model model,@PathVariable Long id)
    {
        Optional<Category>optionalCategory=this.categoryRepository.findById(id);
        if(optionalCategory.isPresent())
        {
            Category category = optionalCategory.get();
            model.addAttribute("category",category);
            return "Category/updateCarCategory";
        }

        return "redirect:/showCategories";
    }

    @PostMapping("/updateCarCategory")
    public String updateCarCategory(@Valid Category category, BindingResult result,Model model)

    {

        if(result.hasErrors()){
            model.addAttribute("category",category);
            return "Category/updateCarCategory";
        }
        this.categoryService.save(category);
        return "redirect:/showCategories";
    }

}
