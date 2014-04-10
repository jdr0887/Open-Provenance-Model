package org.renci.opm.dao.jpa;

import org.renci.opm.dao.OtherDAO;
import org.renci.opm.dao.model.Other;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherDAOImpl extends BaseDAOImpl<Other, Long> implements OtherDAO {

    private final Logger logger = LoggerFactory.getLogger(OtherDAOImpl.class);

    public OtherDAOImpl() {
        super();
    }

    @Override
    public Class<Other> getPersistentClass() {
        return Other.class;
    }

}
