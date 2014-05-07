package org.renci.opm.dao.jpa;

import org.renci.opm.dao.UsageDAO;
import org.renci.opm.dao.model.Usage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageDAOImpl extends BaseDAOImpl<Usage, Long> implements UsageDAO {

    private final Logger logger = LoggerFactory.getLogger(UsageDAOImpl.class);

    public UsageDAOImpl() {
        super();
    }

    @Override
    public Class<Usage> getPersistentClass() {
        return Usage.class;
    }

}
