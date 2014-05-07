package org.renci.opm.ws.impl;

import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.PlanDAO;
import org.renci.opm.dao.model.Plan;
import org.renci.opm.ws.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanServiceImpl implements PlanService {

    private final Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

    private PlanDAO planDAO;

    @Override
    public Plan findById(Long id) {
        logger.info("ENTERING findById(Long)");
        Plan ret = null;
        try {
            ret = planDAO.findById(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Long save(Plan plan) {
        logger.info("ENTERING save(Plan)");
        Long ret = null;
        try {
            ret = planDAO.save(plan);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public PlanDAO getPlanDAO() {
        return planDAO;
    }

    public void setPlanDAO(PlanDAO planDAO) {
        this.planDAO = planDAO;
    }

}
