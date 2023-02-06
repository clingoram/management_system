package mgsystem.management_system.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Handle requests from the client side.
@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    // direct to index.html.
    @GetMapping(path = "/")
    public String index(Model model){
       List<Product> list = service.listAllData();
       model.addAttribute("listProducts", list);
       return "index";
    }

    // direct to add product page.
    @GetMapping(path = "/add")
    public String showAddPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "add_product";
    }

    // insert
    @PostMapping(value = "/save")
    public String saveData(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }


    // direct to edit page and save the edited data.
    @GetMapping(value="/update")
    public ModelAndView showEditPageAndSave(@PathVariable(name = "id") String id){
        int convertType = Integer.parseInt(id);

        ModelAndView edit  = new ModelAndView("edit_product");
        String get = service.getOneData(convertType);
        edit.addObject("product",get);

        return edit;
    }


    // Put method
    @RequestMapping(path = "/edit/{id}")
    public String updateData(@PathVariable(value = "id") Long id, @Param(value="name") String name, @Param(value = "price") int price){
//        String get = service.getOneData(id);

        int result = service.update(id,name,price);
        if(result == 1){
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }
        return "redirect:/";
    }

//     Delete
    @RequestMapping(path = "/delete/{id}")
    public String deleteData(@PathVariable(name = "id") String id){
        int convertType = Integer.parseInt(id);
//        service.delete(convertType);

        String rspMessage = null;
        int removeResult = service.delete(convertType);

        if(removeResult == 1){
            rspMessage = "Data Removed. Effect row: " + removeResult;
        }else{
            rspMessage = "Nothing removed";
        }
//        System.out.println(rspMessage);

        return "redirect:/";
    }

}
