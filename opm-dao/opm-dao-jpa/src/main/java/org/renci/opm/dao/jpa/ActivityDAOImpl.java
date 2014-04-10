package org.renci.opm.dao.jpa;

import org.renci.opm.dao.ActivityDAO;
import org.renci.opm.dao.model.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityDAOImpl extends BaseDAOImpl<Activity, Long> implements ActivityDAO {

    private final Logger logger = LoggerFactory.getLogger(ActivityDAOImpl.class);

    public ActivityDAOImpl() {
        super();
    }

    @Override
    public Class<Activity> getPersistentClass() {
        return Activity.class;
    }

}
