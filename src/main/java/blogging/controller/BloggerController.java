package blogging.controller;

import blogging.model.Blogger;
import blogging.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @GetMapping("/create-blogger")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blogger/create");
        modelAndView.addObject("blogger", new Blogger());
        return modelAndView;
    }

    @PostMapping("/create-blogger")
    public ModelAndView saveBlogger(@ModelAttribute("blogger") Blogger blogger){
        bloggerService.save(blogger);

        ModelAndView modelAndView = new ModelAndView("/blogger/create");
        modelAndView.addObject("blogger", new Blogger());
        modelAndView.addObject("message", "New Blogger created successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listBlogger(){
        List<Blogger> bloggers = bloggerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blogger/list");
        modelAndView.addObject("bloggers", bloggers);
        return modelAndView;
    }
}
