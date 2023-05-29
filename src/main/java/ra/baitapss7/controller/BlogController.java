package ra.baitapss7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.baitapss7.model.Blog;
import ra.baitapss7.service.blog.IBlogService;

import java.util.Optional;

@Controller
@RequestMapping({"/","/blog"})
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @ModelAttribute("blogs")
    Iterable<Blog> getAllBlog(){
        return blogService.findAll();
    }
    @GetMapping({"/","/homeController"})
    public String home(@RequestParam("sortBy") Optional<String> sortBy, ModelMap model, Pageable pageable) {
        Sort sort = null;
        if (sortBy.isPresent()) {
            switch (sortBy.get()) {
                case "ASC":
                    sort = Sort.by("name").ascending();
                    break;
                case "DESC":
                    sort = Sort.by("name").descending();
                    break;
                default:
                    break;
            }
        }else {
            sort = Sort.by("name").ascending();
        }
        Page<Blog> list = blogService.findAll(pageable,sort);
        model.addAttribute("list", list);
        return "/blog/home";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView add() {
        return new ModelAndView("add", "customer", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Blog b) {
        blogService.save(b);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<Blog> customer = blogService.findById(id);
        return new ModelAndView("edit", "customer", customer.get());
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Blog c) {
        blogService.save(c);
        return "redirect:/";
    }
}
