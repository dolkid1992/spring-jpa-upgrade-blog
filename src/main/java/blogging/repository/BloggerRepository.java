package blogging.repository;

import blogging.model.Blogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BloggerRepository extends PagingAndSortingRepository<Blogger, Long> {
    Page<Blogger> findAllByTitleContaining(String title, Pageable pageable);
}
