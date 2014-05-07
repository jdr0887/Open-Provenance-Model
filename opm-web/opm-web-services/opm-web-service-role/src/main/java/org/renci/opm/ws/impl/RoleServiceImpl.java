package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.RoleDAO;
import org.renci.opm.dao.model.Role;
import org.renci.opm.ws.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleServiceImpl implements RoleService {

    private final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    private RoleDAO roleDAO;

    @Override
    public Role findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Role ret = null;
        try {
            ret = roleDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Role role) {
        logger.info("ENTERING save(Role)");
        Long ret = null;
        try {
            ret = roleDAO.save(role);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

}
