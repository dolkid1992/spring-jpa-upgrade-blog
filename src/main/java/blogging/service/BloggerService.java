package blogging.service;

import blogging.model.Blogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BloggerService {
    Page<Blogger> findAll(Pageable pageable);

    Blogger findById(Long id);

    void save(Blogger blogger);

    void remove(Long id);

    Page<Blogger> findAllByTitleContaining(String title, Pageable pageable);
}
