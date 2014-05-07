package org.renci.opm.dao.jpa;

import org.renci.opm.dao.InvalidationDAO;
import org.renci.opm.dao.model.Invalidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidationDAOImpl extends BaseDAOImpl<Invalidation, Long> implements InvalidationDAO {

    private final Logger logger = LoggerFactory.getLogger(InvalidationDAOImpl.class);

    public InvalidationDAOImpl() {
        super();
    }

    @Override
    public Class<Invalidation> getPersistentClass() {
        return Invalidation.class;
    }

}
