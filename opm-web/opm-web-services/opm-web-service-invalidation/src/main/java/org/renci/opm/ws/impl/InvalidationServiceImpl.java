package org.renci.opm.ws.impl;

import org.renci.opm.dao.InvalidationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Invalidation;
import org.renci.opm.ws.InvalidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidationServiceImpl implements InvalidationService {

    private final Logger logger = LoggerFactory.getLogger(InvalidationServiceImpl.class);

    private InvalidationDAO invalidationDAO;

    @Override
    public Invalidation findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Invalidation ret = null;
        try {
            ret = invalidationDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Invalidation invalidation) {
        logger.info("ENTERING save(Invalidation)");
        Long ret = null;
        try {
            ret = invalidationDAO.save(invalidation);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public InvalidationDAO getInvalidationDAO() {
        return invalidationDAO;
    }

    public void setInvalidationDAO(InvalidationDAO invalidationDAO) {
        this.invalidationDAO = invalidationDAO;
    }

}
