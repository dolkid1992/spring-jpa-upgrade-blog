package blogging.service.impl;

import blogging.model.Blogger;
import blogging.repository.BloggerRepository;
import blogging.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public Page<Blogger> findAll(Pageable pageable){
        return bloggerRepository.findAll(pageable);
    }

    @Override
    public Blogger findById(Long id) {
        return bloggerRepository.findOne(id);
    }

    @Override
    public void save(Blogger blogger) {
        bloggerRepository.save(blogger);
        }

    @Override
    public void remove(Long id) {
        bloggerRepository.delete(id);
    }

    @Override
    public Page<Blogger> findAllByTitleContaining(String title, Pageable pageable) {
        return bloggerRepository.findAllByTitleContaining(title, pageable);
    }
}
