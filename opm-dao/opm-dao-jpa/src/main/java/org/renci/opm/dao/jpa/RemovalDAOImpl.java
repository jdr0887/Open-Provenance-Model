package org.renci.opm.dao.jpa;

import org.renci.opm.dao.RemovalDAO;
import org.renci.opm.dao.model.Removal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemovalDAOImpl extends BaseDAOImpl<Removal, Long> implements RemovalDAO {

    private final Logger logger = LoggerFactory.getLogger(RemovalDAOImpl.class);

    public RemovalDAOImpl() {
        super();
    }

    @Override
    public Class<Removal> getPersistentClass() {
        return Removal.class;
    }

}
