package mgsystem.management_system.category;
import mgsystem.management_system.error.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RestController
@RequestMapping(path="/api",consumes = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    final String DIRECT_URL = "redirect:/api/index";

    @Autowired
    private CategoryService categoryService;

    // index
    @GetMapping("/index")
    public String index(Model model){
        List<Category> list = categoryService.AllCategoryData();
//        String list = categoryService.AllCategoryData();
        System.out.println(list);
//        model.addAttribute("categories", list);

        return "/index";
    }
}
