package org.renci.opm.dao.jpa;

import org.renci.opm.dao.AlternateDAO;
import org.renci.opm.dao.model.Alternate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlternateDAOImpl extends BaseDAOImpl<Alternate, Long> implements AlternateDAO {

    private final Logger logger = LoggerFactory.getLogger(AlternateDAOImpl.class);

    public AlternateDAOImpl() {
        super();
    }

    @Override
    public Class<Alternate> getPersistentClass() {
        return Alternate.class;
    }

}
