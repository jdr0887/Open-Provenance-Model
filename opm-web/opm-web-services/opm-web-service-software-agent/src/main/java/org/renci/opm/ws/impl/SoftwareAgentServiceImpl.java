package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.SoftwareAgentDAO;
import org.renci.opm.dao.model.SoftwareAgent;
import org.renci.opm.ws.SoftwareAgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoftwareAgentServiceImpl implements SoftwareAgentService {

    private final Logger logger = LoggerFactory.getLogger(SoftwareAgentServiceImpl.class);

    private SoftwareAgentDAO softwareAgentDAO;

    @Override
    public SoftwareAgent findById(Long id) {
        logger.info("ENTERING findById(Long)");
        SoftwareAgent ret = null;
        try {
            ret = softwareAgentDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(SoftwareAgent softwareAgent) {
        logger.info("ENTERING save(SoftwareAgent)");
        Long ret = null;
        try {
            ret = softwareAgentDAO.save(softwareAgent);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public SoftwareAgentDAO getSoftwareAgentDAO() {
        return softwareAgentDAO;
    }

    public void setSoftwareAgentDAO(SoftwareAgentDAO softwareAgentDAO) {
        this.softwareAgentDAO = softwareAgentDAO;
    }

}
