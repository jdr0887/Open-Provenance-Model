package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.StartDAO;
import org.renci.opm.dao.model.Start;
import org.renci.opm.ws.StartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartServiceImpl implements StartService {

    private final Logger logger = LoggerFactory.getLogger(StartServiceImpl.class);

    private StartDAO startDAO;

    @Override
    public Start findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Start ret = null;
        try {
            ret = startDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Start start) {
        logger.info("ENTERING save(Start)");
        Long ret = null;
        try {
            ret = startDAO.save(start);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public StartDAO getStartDAO() {
        return startDAO;
    }

    public void setStartDAO(StartDAO startDAO) {
        this.startDAO = startDAO;
    }

}
