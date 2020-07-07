package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Topic;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class TopicServiceImpl implements Service<Topic> {

    private DaoRepository<Topic> daoRepository;

    @Autowired
    public TopicServiceImpl(DaoRepository<Topic> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Topic> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Topic getById(Long id) {
        return daoRepository.getById(Topic.class, id);
    }

    @Override
    public List<Topic> findAll() {
        return daoRepository.findAll(Topic.class);
    }
}
