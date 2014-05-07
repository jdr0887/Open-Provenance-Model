package org.renci.opm.dao.jpa;

import org.renci.opm.dao.PlanDAO;
import org.renci.opm.dao.model.Plan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanDAOImpl extends BaseDAOImpl<Plan, Long> implements PlanDAO {

    private final Logger logger = LoggerFactory.getLogger(PlanDAOImpl.class);

    public PlanDAOImpl() {
        super();
    }

    @Override
    public Class<Plan> getPersistentClass() {
        return Plan.class;
    }

}
