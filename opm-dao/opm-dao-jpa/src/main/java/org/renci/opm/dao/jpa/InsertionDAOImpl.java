package org.renci.opm.dao.jpa;

import org.renci.opm.dao.InsertionDAO;
import org.renci.opm.dao.model.Insertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertionDAOImpl extends BaseDAOImpl<Insertion, Long> implements InsertionDAO {

    private final Logger logger = LoggerFactory.getLogger(InsertionDAOImpl.class);

    public InsertionDAOImpl() {
        super();
    }

    @Override
    public Class<Insertion> getPersistentClass() {
        return Insertion.class;
    }

}
