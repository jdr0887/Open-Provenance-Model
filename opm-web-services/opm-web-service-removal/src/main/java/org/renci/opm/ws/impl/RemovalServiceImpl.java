package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.RemovalDAO;
import org.renci.opm.dao.model.Removal;
import org.renci.opm.ws.RemovalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemovalServiceImpl implements RemovalService {

    private final Logger logger = LoggerFactory.getLogger(RemovalServiceImpl.class);

    private RemovalDAO removalDAO;

    @Override
    public Removal findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Removal ret = null;
        try {
            ret = removalDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Removal removal) {
        logger.info("ENTERING save(Document)");
        Long ret = null;
        try {
            ret = removalDAO.save(removal);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public RemovalDAO getRemovalDAO() {
        return removalDAO;
    }

    public void setRemovalDAO(RemovalDAO removalDAO) {
        this.removalDAO = removalDAO;
    }

}
