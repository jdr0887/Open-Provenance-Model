package org.renci.opm.ws.impl;

import org.renci.opm.dao.InfluenceDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Influence;
import org.renci.opm.ws.InfluenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfluenceServiceImpl implements InfluenceService {

    private final Logger logger = LoggerFactory.getLogger(InfluenceServiceImpl.class);

    private InfluenceDAO influenceDAO;

    @Override
    public Influence findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Influence ret = null;
        try {
            ret = influenceDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Influence influence) {
        logger.info("ENTERING save(Influence)");
        Long ret = null;
        try {
            ret = influenceDAO.save(influence);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public InfluenceDAO getInfluenceDAO() {
        return influenceDAO;
    }

    public void setInfluenceDAO(InfluenceDAO influenceDAO) {
        this.influenceDAO = influenceDAO;
    }

}
