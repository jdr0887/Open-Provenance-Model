package org.renci.opm.ws.impl;

import org.renci.opm.dao.ActivityDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Activity;
import org.renci.opm.ws.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityServiceImpl implements ActivityService {

    private final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    private ActivityDAO activityDAO;

    @Override
    public Activity findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Activity ret = null;
        try {
            ret = activityDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Activity document) {
        logger.info("ENTERING save(Document)");
        Long ret = null;
        try {
            ret = activityDAO.save(document);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public ActivityDAO getActivityDAO() {
        return activityDAO;
    }

    public void setActivityDAO(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

}
