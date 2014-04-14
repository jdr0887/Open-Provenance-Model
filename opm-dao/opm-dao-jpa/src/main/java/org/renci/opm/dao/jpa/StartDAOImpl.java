package org.renci.opm.dao.jpa;

import org.renci.opm.dao.StartDAO;
import org.renci.opm.dao.model.Start;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartDAOImpl extends BaseDAOImpl<Start, Long> implements StartDAO {

    private final Logger logger = LoggerFactory.getLogger(StartDAOImpl.class);

    public StartDAOImpl() {
        super();
    }

    @Override
    public Class<Start> getPersistentClass() {
        return Start.class;
    }

}
