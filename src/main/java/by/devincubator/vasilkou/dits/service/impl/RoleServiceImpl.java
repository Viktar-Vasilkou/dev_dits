package by.devincubator.vasilkou.dits.service.impl;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Role;
import by.devincubator.vasilkou.dits.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private DaoRepository<Role> daoRepository;

    @Autowired
    public RoleServiceImpl(DaoRepository<Role> daoRepository) {
        this.daoRepository = daoRepository;
    }

    @Override
    public DaoRepository<Role> getDaoRepository() {
        return daoRepository;
    }

    @Override
    public Role getById(Long id) {
        return daoRepository.getById(Role.class, id);
    }

    @Override
    public List<Role> findAll() {
        return daoRepository.findAll(Role.class);
    }
}
