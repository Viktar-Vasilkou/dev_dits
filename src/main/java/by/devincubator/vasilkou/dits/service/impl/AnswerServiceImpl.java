package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Answer;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class AnswerServiceImpl implements Service<Answer> {

    private DaoRepository<Answer> daoRepository;

    @Autowired
    public AnswerServiceImpl(DaoRepository<Answer> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Answer> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Answer getById(Long id) {
        return daoRepository.getById(Answer.class, id);
    }

    @Override
    public List<Answer> findAll() {
        return daoRepository.findAll(Answer.class);
    }
}
