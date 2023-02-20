package mgsystem.management_system.product;

import mgsystem.management_system.error.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

// Handle requests from the client side.
@Controller
//@RestController
@RequestMapping("/api")
public class ProductController {
    final String DIRECT_URL = "redirect:/api/index";
    // final String DIRECT_URL = "redirect:/";

    @Autowired
    private ProductService service;

    // direct to index.html.
//    @RequestMapping(path = "/index", method = RequestMethod.GET)
    @GetMapping("/index")
    public String index(Model model){
//       List<Product> list = service.listAllData();
        List<Product> list = service.AllData();
        model.addAttribute("listProducts", list);

        return "/index";
    }

    // direct to add product page.
    @GetMapping("/data")
    public String showAddPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add_product";
    }

    // insert
    @PostMapping("/save")
    public String saveData(@ModelAttribute("product") Product product) {
        try{
            if(product.getPrice() == 0 || product.getName() == null){
//                throw new ArithmeticException();
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
//                throw new ArithmeticException();
                HandleError.throwIdError();
            }else{
                System.out.println("showUpdatePage");
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

    // Put method
    @PutMapping("/update/{id}")
    public String updateData(@PathVariable("id") Long id, @RequestBody Product product){
        System.out.println("updated");


//        String productName = product.getName();
//        Integer productPrice = product.getPrice();
//        System.out.println(productPrice.getClass().getName());

//        service.update(id,productName,productPrice);

        // ---------
        String res = service.getOneData(id);

        product.setName(product.getName());
        product.setPrice(product.getPrice());
//        service.update(product);
        service.save(product);

        return  DIRECT_URL;
    }

//     Delete
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") Long id){
        try{
            String find = service.getOneData(id);
            if(find.isEmpty()){
                //                throw new ArithmeticException();
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
