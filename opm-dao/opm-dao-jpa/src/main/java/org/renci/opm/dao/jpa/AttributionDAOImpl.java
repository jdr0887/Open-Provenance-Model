package org.renci.opm.dao.jpa;

import org.renci.opm.dao.AttributionDAO;
import org.renci.opm.dao.model.Attribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributionDAOImpl extends BaseDAOImpl<Attribution, Long> implements AttributionDAO {

    private final Logger logger = LoggerFactory.getLogger(AttributionDAOImpl.class);

    public AttributionDAOImpl() {
        super();
    }

    @Override
    public Class<Attribution> getPersistentClass() {
        return Attribution.class;
    }

}
