package edu.unc.mapseq.dao.rs;

import java.util.Date;

import org.junit.Test;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Activity;
import org.renci.opm.dao.rs.RSDAOManager;

public class ActivityTest {

    @Test
    public void testFindById() {
        RSDAOManager daoMgr = RSDAOManager.getInstance("org/renci/opm/dao/rs/opm-dao-beans-test.xml");
        try {
            Activity activity = daoMgr.getOPMDAOBean().getActivityDAO().findById(1L);
            System.out.println(activity.toString());
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave() {
        RSDAOManager daoMgr = RSDAOManager.getInstance("org/renci/opm/dao/rs/opm-dao-beans-test.xml");
        try {
            Activity activity = new Activity();
            activity.setStartTime(new Date());
            activity.setEndTime(new Date());
            Long id = daoMgr.getOPMDAOBean().getActivityDAO().save(activity);
            System.out.println(id);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }
    }

}
