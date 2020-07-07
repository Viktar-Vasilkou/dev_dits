package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Answer;
import by.devincubator.vasilkou.dits.model.User;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class UserServiceImpl implements Service<User> {

    private DaoRepository<User> daoRepository;

    @Autowired
    public UserServiceImpl(DaoRepository<User> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<User> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public User getById(Long id) {
        return daoRepository.getById(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return daoRepository.findAll(User.class);
    }
}
