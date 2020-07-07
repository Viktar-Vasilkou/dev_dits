package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Answer;
import by.devincubator.vasilkou.dits.model.Statistic;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class StatisticServiceImpl implements Service<Statistic> {

    private DaoRepository<Statistic> daoRepository;

    @Autowired
    public StatisticServiceImpl(DaoRepository<Statistic> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Statistic> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Statistic getById(Long id) {
        return daoRepository.getById(Statistic.class, id);
    }

    @Override
    public List<Statistic> findAll() {
        return daoRepository.findAll(Statistic.class);
    }
}
