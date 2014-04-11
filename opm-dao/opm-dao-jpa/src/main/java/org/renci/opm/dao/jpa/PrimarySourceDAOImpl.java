package org.renci.opm.dao.jpa;

import org.renci.opm.dao.PrimarySourceDAO;
import org.renci.opm.dao.model.PrimarySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimarySourceDAOImpl extends BaseDAOImpl<PrimarySource, Long> implements PrimarySourceDAO {

    private final Logger logger = LoggerFactory.getLogger(PrimarySourceDAOImpl.class);

    public PrimarySourceDAOImpl() {
        super();
    }

    @Override
    public Class<PrimarySource> getPersistentClass() {
        return PrimarySource.class;
    }

}
