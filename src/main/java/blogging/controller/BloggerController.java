package blogging.controller;

import blogging.model.Blogger;
import blogging.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

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
    public ModelAndView listBlogger() {
        List<Blogger> list = bloggerService.findAll();
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

    @PostMapping("/edit-blogger")
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
