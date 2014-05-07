package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.UsageDAO;
import org.renci.opm.dao.model.Usage;
import org.renci.opm.ws.UsageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageServiceImpl implements UsageService {

    private final Logger logger = LoggerFactory.getLogger(UsageServiceImpl.class);

    private UsageDAO usageDAO;

    @Override
    public Usage findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Usage ret = null;
        try {
            ret = usageDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Usage usage) {
        logger.info("ENTERING save(Usage)");
        Long ret = null;
        try {
            ret = usageDAO.save(usage);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public UsageDAO getUsageDAO() {
        return usageDAO;
    }

    public void setUsageDAO(UsageDAO usageDAO) {
        this.usageDAO = usageDAO;
    }

}
