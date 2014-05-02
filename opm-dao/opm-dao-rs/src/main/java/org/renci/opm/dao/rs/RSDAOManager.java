package org.renci.opm.dao.rs;

import org.renci.opm.dao.OPMDAOBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author jdr0887
 */
public class RSDAOManager {

    private static RSDAOManager instance;

    private String beanXMLFile = "org/renci/opm/dao/rs/opm-dao-beans.xml";

    private ClassPathXmlApplicationContext applicationContext = null;

    public static RSDAOManager getInstance() {
        if (instance == null) {
            instance = new RSDAOManager();
        }
        return instance;
    }

    public static RSDAOManager getInstance(String beanXMLFile) {
        if (instance == null) {
            instance = new RSDAOManager(beanXMLFile);
        }
        return instance;
    }

    private RSDAOManager() {
        this.applicationContext = new ClassPathXmlApplicationContext(this.beanXMLFile);
    }

    private RSDAOManager(String beanXMLFile) {
        this.beanXMLFile = beanXMLFile;
        this.applicationContext = new ClassPathXmlApplicationContext(this.beanXMLFile);
    }

    public OPMDAOBean getOPMDAOBean() {
        OPMDAOBean bean = (OPMDAOBean) applicationContext.getBean("opmBean", OPMDAOBean.class);
        return bean;
    }

}
