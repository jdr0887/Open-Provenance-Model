package org.renci.opm.ws.impl;

import org.renci.opm.dao.AttributionDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Activity;
import org.renci.opm.dao.model.Attribution;
import org.renci.opm.ws.AttributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributionServiceImpl implements AttributionService {

    private final Logger logger = LoggerFactory.getLogger(AttributionServiceImpl.class);

    private AttributionDAO attributionDAO;

    @Override
    public Attribution findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Attribution ret = null;
        try {
            ret = attributionDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Attribution attribution) {
        logger.info("ENTERING save(Attribution)");
        Long ret = null;
        try {
            ret = attributionDAO.save(attribution);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public AttributionDAO getAttributionDAO() {
        return attributionDAO;
    }

    public void setAttributionDAO(AttributionDAO attributionDAO) {
        this.attributionDAO = attributionDAO;
    }

}
