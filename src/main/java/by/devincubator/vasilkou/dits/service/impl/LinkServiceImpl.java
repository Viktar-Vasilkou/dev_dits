package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Link;
import by.devincubator.vasilkou.dits.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class LinkServiceImpl implements Service<Link> {

    private DaoRepository<Link> daoRepository;

    @Autowired
    public LinkServiceImpl(DaoRepository<Link> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Link> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Link getById(Long id) {
        return daoRepository.getById(Link.class, id);
    }

    @Override
    public List<Link> findAll() {
        return daoRepository.findAll(Link.class);
    }
}
