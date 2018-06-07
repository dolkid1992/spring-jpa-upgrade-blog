package blogging.service;

import blogging.model.Blogger;

import java.util.List;

public interface BloggerService {
    List<Blogger> findAll();

    Blogger findById(Long id);

    void save(Blogger blogger);

    void remove(Long id);
}
