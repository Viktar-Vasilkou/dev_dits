package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Answer;
import by.devincubator.vasilkou.dits.model.Question;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class QuestionServiceImpl implements Service<Question> {

    private DaoRepository<Question> daoRepository;

    @Autowired
    public QuestionServiceImpl(DaoRepository<Question> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Question> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Question getById(Long id) {
        return daoRepository.getById(Question.class, id);
    }

    @Override
    public List<Question> findAll() {
        return daoRepository.findAll(Question.class);
    }
}
