package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.OtherDAO;
import org.renci.opm.dao.model.Other;
import org.renci.opm.ws.OtherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherServiceImpl implements OtherService {

    private final Logger logger = LoggerFactory.getLogger(OtherServiceImpl.class);

    private OtherDAO otherDAO;

    @Override
    public Other findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Other ret = null;
        try {
            ret = otherDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Other other) {
        logger.info("ENTERING save(Other)");
        Long ret = null;
        try {
            ret = otherDAO.save(other);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public OtherDAO getOtherDAO() {
        return otherDAO;
    }

    public void setOtherDAO(OtherDAO otherDAO) {
        this.otherDAO = otherDAO;
    }

}
