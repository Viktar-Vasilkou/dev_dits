package by.devincubator.vasilkou.dits.service.api;

import by.devincubator.vasilkou.dits.dao.api.DaoRepository;
import by.devincubator.vasilkou.dits.model.Role;

import java.util.List;

public interface RoleService extends Service<Role> {
    @Override
    DaoRepository<Role> getDaoRepository();

    @Override
    default void create(Role role) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    default void update(Role role) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    default void delete(Role role) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    default void save(Role role) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    Role getById(Long id);

    @Override
    List<Role> findAll();
}
