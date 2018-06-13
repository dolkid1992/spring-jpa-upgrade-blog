package blogging.controller;

import blogging.model.Blogger;
import blogging.model.Category;
import blogging.service.BloggerService;
import blogging.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/create-blogger")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blogger/create");
        modelAndView.addObject("blogger", new Blogger());
        return modelAndView;
    }

    @PostMapping("/create-blogger")
    public ModelAndView saveBlogger(@ModelAttribute("blogger") Blogger blogger) {
        bloggerService.save(blogger);

        ModelAndView modelAndView = new ModelAndView("/blogger/create");
        modelAndView.addObject("blogger", new Blogger());
        modelAndView.addObject("message", "New Blogger created successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listBlogger(@RequestParam("s")Optional<String>s, Pageable pageable) {
        Page<Blogger> list;
        if (s.isPresent()){
            list = bloggerService.findAllByTitleContaining(s.get(), pageable);
        }else {
            list = bloggerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blogger/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView listDetailBlog(@PathVariable Long id){
        Blogger blogger = bloggerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blogger/listDetails");
        modelAndView.addObject("details", blogger);
        return modelAndView;
    }

    @GetMapping("/edit-blogger/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blogger blogger = bloggerService.findById(id);
        if (blogger != null) {
            ModelAndView modelAndView = new ModelAndView("/blogger/edit");
            modelAndView.addObject("blogger", blogger);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blogger/{id}")
    public ModelAndView updateBlogger(@ModelAttribute("blogger") Blogger blogger) {
        bloggerService.save(blogger);
        ModelAndView modelAndView = new ModelAndView("/blogger/edit");
        modelAndView.addObject("blogger", blogger);
        modelAndView.addObject("message", "Blogger upload successfuly");
        return modelAndView;
    }

    @GetMapping("/delete-blogger/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blogger blogger = bloggerService.findById(id);
        if (blogger != null) {
            ModelAndView modelAndView = new ModelAndView("/blogger/delete");
            modelAndView.addObject("blogger", blogger);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blogger")
    public String deleteBlogger(@ModelAttribute("blogger") Blogger blogger) {
        bloggerService.remove(blogger.getId());
        return "redirect:list";
    }
}
