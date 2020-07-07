package by.devincubator.vasilkou.dits.service.api;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service<T> {

    DaoRepository<T> getDaoRepository();

    default void create(T t){
        getDaoRepository().create(t);
    }

    default void update(T t){
        getDaoRepository().update(t);
    }

    default void delete(T t){
        getDaoRepository().delete(t);
    }

    default void save(T t){
        getDaoRepository().save(t);
    }

    T getById(Long id);

    List<T> findAll();
}
