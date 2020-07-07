package by.devincubator.vasilkou.dits.dao.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoRepositoryImpl<T> implements DaoRepository<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public DaoRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }
}
