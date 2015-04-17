package org.renci.opm.ws.impl;

import org.renci.opm.dao.InsertionDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Insertion;
import org.renci.opm.ws.InsertionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertionServiceImpl implements InsertionService {

    private final Logger logger = LoggerFactory.getLogger(InsertionServiceImpl.class);

    private InsertionDAO insertionDAO;

    @Override
    public Insertion findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Insertion ret = null;
        try {
            ret = insertionDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Insertion insertion) {
        logger.info("ENTERING save(Document)");
        Long ret = null;
        try {
            ret = insertionDAO.save(insertion);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public InsertionDAO getInsertionDAO() {
        return insertionDAO;
    }

    public void setInsertionDAO(InsertionDAO insertionDAO) {
        this.insertionDAO = insertionDAO;
    }

}
