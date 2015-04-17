package org.renci.opm.ws.impl;

import org.renci.opm.dao.EndDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.End;
import org.renci.opm.ws.EndService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndServiceImpl implements EndService {

    private final Logger logger = LoggerFactory.getLogger(EndServiceImpl.class);

    private EndDAO endDAO;

    @Override
    public End findById(Long id) {
        logger.info("ENTERING findById(Long)");
        End ret = null;
        try {
            ret = endDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(End end) {
        logger.info("ENTERING save(End)");
        Long ret = null;
        try {
            ret = endDAO.save(end);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public EndDAO getEndDAO() {
        return endDAO;
    }

    public void setEndDAO(EndDAO endDAO) {
        this.endDAO = endDAO;
    }

}
