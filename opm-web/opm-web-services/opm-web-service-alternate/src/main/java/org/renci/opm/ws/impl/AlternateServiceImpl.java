package org.renci.opm.ws.impl;

import org.renci.opm.dao.AlternateDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Alternate;
import org.renci.opm.ws.AlternateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlternateServiceImpl implements AlternateService {

    private final Logger logger = LoggerFactory.getLogger(AlternateServiceImpl.class);

    private AlternateDAO alternateDAO;

    @Override
    public Alternate findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Alternate ret = null;
        try {
            ret = alternateDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Alternate document) {
        logger.info("ENTERING save(Document)");
        Long ret = null;
        try {
            ret = alternateDAO.save(document);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public AlternateDAO getAlternateDAO() {
        return alternateDAO;
    }

    public void setAlternateDAO(AlternateDAO alternateDAO) {
        this.alternateDAO = alternateDAO;
    }

}
