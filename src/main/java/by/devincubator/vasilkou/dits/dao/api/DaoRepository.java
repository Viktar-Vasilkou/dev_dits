package by.devincubator.vasilkou.dits.dao.api;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DaoRepository<T> {

    SessionFactory getBeanToBeAutowired();

    @SuppressWarnings("unchecked")
    default void create(T t){
        getBeanToBeAutowired().getCurrentSession().merge(t);
    }

    default void update(T t){
        getBeanToBeAutowired().getCurrentSession().update(t);
    }

    default void delete(T t){
        getBeanToBeAutowired().getCurrentSession().delete(t);
    }

    default void save(T t){
        getBeanToBeAutowired().getCurrentSession().save(t);
    }

    default T getById(Class<T> tClass, Long id){
        return getBeanToBeAutowired().getCurrentSession().load(tClass, id);
    }

    @SuppressWarnings("unchecked")
    default List<T> findAll(Class T){
        return (List<T>) getBeanToBeAutowired().getCurrentSession().createQuery("from " + T.getSimpleName()).list();
    }

}
