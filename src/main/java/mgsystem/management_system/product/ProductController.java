package mgsystem.management_system.product;

import mgsystem.management_system.error.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Handle requests from the client side.
@Controller
//@RestController
@RequestMapping("/api")
public class ProductController {
    final String DIRECT_URL = "redirect:/api/index";

    @Autowired
    private ProductService service;

    private ProductCategories ProductCategories;

    // index
    @GetMapping("/index")
    public String index(Model model){
        List<Product> list = service.AllData();
        model.addAttribute("listProducts", list);
        return "/index";
    }

    // management page
    @GetMapping("/management")
    public String showManagement(Model model){
        List<Product> list = service.AllData();
        model.addAttribute("listProducts", list);
        return "management";
    }

    // direct to add product page.
    @GetMapping("/data")
    public String showAddPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add_product";
//        return "backend/add_product";
    }

    // insert
    @PostMapping("/save")
    public String saveData(@ModelAttribute("product") Product product) {
        try{
            if(product.getPrice() == 0 || product.getName() == null){
                HandleError.throwInputsError();
            }else{
                service.save(product);
                System.out.println("成功!!");
            }
        }catch(ArithmeticException e){
            System.out.println("Error: " + e);
        }
        return DIRECT_URL;
    }

    @GetMapping("/update/{id}")
    public String showUpdatePage(@PathVariable(name = "id") Long id,Model model){
        try{
            String find = service.getOneData(id);
            if(find.isEmpty()){
                HandleError.throwIdError();
            }else{
                Product getData = service.get(id);

//                ModelAndView mav  = new ModelAndView("edit_product");
//                mav.addObject("product",getData);

                model.addAttribute("product",getData);
//                return mav;
            }
        }catch(ArithmeticException e){
            System.out.println("Error: " + e);
        }
        return "edit_product";

//        model.addAttribute("product",getData);
//        System.out.println(model);
//        return "edit_product";
    }

    // Update
    @PostMapping("/update/{id}")
    public String updateData(@PathVariable("id") Long id, String name,int price){
        try{
            String find = service.getOneData(id);
            if(find.isEmpty()){
                HandleError.throwIdError();
            }else{
                service.update(id,name,price);
            }
        }catch(ArithmeticException e){
            System.out.println("Error: " + e);
        }
        return DIRECT_URL;
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Long id){
        try{
            String find = service.getOneData(id);
            if(find.isEmpty()){
                HandleError.throwIdError();
            }else{
                service.delete(id);
            }
        }catch(ArithmeticException e){
            System.out.println("Error: " + e);
        }
        return DIRECT_URL;
    }
}