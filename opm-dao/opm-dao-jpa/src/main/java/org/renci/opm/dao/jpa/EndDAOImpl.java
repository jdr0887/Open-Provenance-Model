package org.renci.opm.dao.jpa;

import org.renci.opm.dao.EndDAO;
import org.renci.opm.dao.model.End;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndDAOImpl extends BaseDAOImpl<End, Long> implements EndDAO {

    private final Logger logger = LoggerFactory.getLogger(EndDAOImpl.class);

    public EndDAOImpl() {
        super();
    }

    @Override
    public Class<End> getPersistentClass() {
        return End.class;
    }

}
