package org.renci.opm.dao.jpa;

import org.renci.opm.dao.DelegationDAO;
import org.renci.opm.dao.model.Delegation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelegationDAOImpl extends BaseDAOImpl<Delegation, Long> implements DelegationDAO {

    private final Logger logger = LoggerFactory.getLogger(DelegationDAOImpl.class);

    public DelegationDAOImpl() {
        super();
    }

    @Override
    public Class<Delegation> getPersistentClass() {
        return Delegation.class;
    }

}
