package org.renci.opm.dao.jpa;

import org.renci.opm.dao.SoftwareAgentDAO;
import org.renci.opm.dao.model.SoftwareAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoftwareAgentDAOImpl extends BaseDAOImpl<SoftwareAgent, Long> implements SoftwareAgentDAO {

    private final Logger logger = LoggerFactory.getLogger(SoftwareAgentDAOImpl.class);

    public SoftwareAgentDAOImpl() {
        super();
    }

    @Override
    public Class<SoftwareAgent> getPersistentClass() {
        return SoftwareAgent.class;
    }

}
