package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Literature;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class LiteratureServiceImpl implements Service<Literature> {

    private DaoRepository<Literature> daoRepository;

    @Autowired
    public LiteratureServiceImpl(DaoRepository<Literature> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Literature> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Literature getById(Long id) {
        return daoRepository.getById(Literature.class, id);
    }

    @Override
    public List<Literature> findAll() {
        return daoRepository.findAll(Literature.class);
    }
}
