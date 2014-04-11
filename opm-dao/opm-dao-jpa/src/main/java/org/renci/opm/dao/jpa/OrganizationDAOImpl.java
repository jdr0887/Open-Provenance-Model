package org.renci.opm.dao.jpa;

import org.renci.opm.dao.OrganizationDAO;
import org.renci.opm.dao.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrganizationDAOImpl extends BaseDAOImpl<Organization, Long> implements OrganizationDAO {

    private final Logger logger = LoggerFactory.getLogger(OrganizationDAOImpl.class);

    public OrganizationDAOImpl() {
        super();
    }

    @Override
    public Class<Organization> getPersistentClass() {
        return Organization.class;
    }

}
