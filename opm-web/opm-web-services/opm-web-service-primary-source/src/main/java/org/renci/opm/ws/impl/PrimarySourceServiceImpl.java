package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.PrimarySourceDAO;
import org.renci.opm.dao.model.PrimarySource;
import org.renci.opm.ws.PrimarySourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimarySourceServiceImpl implements PrimarySourceService {

    private final Logger logger = LoggerFactory.getLogger(PrimarySourceServiceImpl.class);

    private PrimarySourceDAO primarySourceDAO;

    @Override
    public PrimarySource findById(Long id) {
        logger.info("ENTERING findById(Long)");
        PrimarySource ret = null;
        try {
            ret = primarySourceDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(PrimarySource primarySource) {
        logger.info("ENTERING save(Document)");
        Long ret = null;
        try {
            ret = primarySourceDAO.save(primarySource);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public PrimarySourceDAO getPrimarySourceDAO() {
        return primarySourceDAO;
    }

    public void setPrimarySourceDAO(PrimarySourceDAO primarySourceDAO) {
        this.primarySourceDAO = primarySourceDAO;
    }

}
