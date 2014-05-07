package org.renci.opm.dao.jpa;

import org.renci.opm.dao.InfluenceDAO;
import org.renci.opm.dao.model.Influence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfluenceDAOImpl extends BaseDAOImpl<Influence, Long> implements InfluenceDAO {

    private final Logger logger = LoggerFactory.getLogger(InfluenceDAOImpl.class);

    public InfluenceDAOImpl() {
        super();
    }

    @Override
    public Class<Influence> getPersistentClass() {
        return Influence.class;
    }

}
