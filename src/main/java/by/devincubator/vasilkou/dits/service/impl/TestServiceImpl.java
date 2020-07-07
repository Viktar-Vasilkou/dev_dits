package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Test;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class TestServiceImpl implements Service<Test> {

    private DaoRepository<Test> daoRepository;

    @Autowired
    public TestServiceImpl(DaoRepository<Test> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Test> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Test getById(Long id) {
        return daoRepository.getById(Test.class, id);
    }

    @Override
    public List<Test> findAll() {
        return daoRepository.findAll(Test.class);
    }
}
