package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.OrganizationDAO;
import org.renci.opm.dao.model.Organization;
import org.renci.opm.ws.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrganizationServiceImpl implements OrganizationService {

    private final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private OrganizationDAO organizationDAO;

    @Override
    public Organization findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Organization ret = null;
        try {
            ret = organizationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Organization organization) {
        logger.info("ENTERING save(Organization)");
        Long ret = null;
        try {
            ret = organizationDAO.save(organization);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public OrganizationDAO getOrganizationDAO() {
        return organizationDAO;
    }

    public void setOrganizationDAO(OrganizationDAO organizationDAO) {
        this.organizationDAO = organizationDAO;
    }

}
