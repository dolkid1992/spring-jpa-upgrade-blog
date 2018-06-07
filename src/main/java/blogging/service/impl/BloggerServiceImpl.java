package blogging.service.impl;

import blogging.model.Blogger;
import blogging.repository.BloggerRepository;
import blogging.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public List<Blogger> findAll() {
        return bloggerRepository.findAll();
    }

    @Override
    public Blogger findById(Long id) {
        return bloggerRepository.findById(id);
    }

    @Override
    public void save(Blogger blogger) {
        bloggerRepository.save(blogger);
        }

    @Override
    public void remove(Long id) {
        bloggerRepository.remove(id);
    }
}
