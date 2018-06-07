package blogging.repository.impl;

import blogging.model.Blogger;
import blogging.repository.BloggerRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BloggerRepositoryImpl implements BloggerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blogger> findAll() {
        TypedQuery<Blogger> query = em.createQuery("select c from Blogger c ",Blogger.class);
        return query.getResultList();
    }

    @Override
    public Blogger findById(Long id) {
        TypedQuery<Blogger> query = em.createQuery("select c from Blogger c where c.id=:id", Blogger.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
        return null;
        }
    }

    @Override
    public void save(Blogger blogger) {
        if (blogger.getId() != null) {
            em.merge(blogger);
        }else{
            em.persist(blogger);
        }
    }

    @Override
    public void remove(Long id) {
        Blogger blogger = findById(id);
        if (blogger != null) {
            em.remove(blogger);
        }
    }
}
