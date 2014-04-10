package org.renci.opm.dao.jpa;

import org.renci.opm.dao.RoleDAO;
import org.renci.opm.dao.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleDAOImpl extends BaseDAOImpl<Role, Long> implements RoleDAO {

    private final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

    public RoleDAOImpl() {
        super();
    }

    @Override
    public Class<Role> getPersistentClass() {
        return Role.class;
    }

}
