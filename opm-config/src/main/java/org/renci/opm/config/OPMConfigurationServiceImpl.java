package org.renci.opm.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class OPMConfigurationServiceImpl implements OPMConfigurationService {

    private Properties properties;

    public OPMConfigurationServiceImpl() {
        this.properties = new Properties();
        try {

            // get properties from jar
            InputStream is = this.getClass().getResourceAsStream("opm.properties");
            this.properties.load(is);
            is.close();

            // get properties from file system
            File opmHiddenDir = new File(System.getProperty("user.home"), ".opm");
            File hiddenOPMPropertiesFile = new File(opmHiddenDir, "opm.properties");
            if (hiddenOPMPropertiesFile.exists()) {
                is = new FileInputStream(hiddenOPMPropertiesFile);
                this.properties.load(is);
                is.close();
            }

            // overload with System props
            this.properties.putAll(System.getProperties());
            this.properties.putAll(System.getenv());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String getVersion(String def) {
        return getProperties().getProperty(OPMConfigurationService.VERSION, def);
    }

    @Override
    public String getWebServiceHost(String def) {
        return getProperties().getProperty(OPMConfigurationService.WEB_SERVICE_HOST, def);
    }

    public void setWebServiceHost(String value) {
        getProperties().setProperty(OPMConfigurationService.WEB_SERVICE_HOST, value);
    }

    @Override
    public RunModeType getRunMode() {
        String version = getVersion(null);
        if (StringUtils.isEmpty(version) || (StringUtils.isNotEmpty(version) && version.contains("SNAPSHOT"))) {
            return RunModeType.DEV;
        }
        return RunModeType.PROD;
    }

    @Override
    public Long getWebServiceTimeout(Long def) {
        String timeout = getProperties().getProperty(OPMConfigurationService.WEB_SERVICE_TIMEOUT, "300000");
        return Long.valueOf(timeout);
    }

    public void setWebServiceTimeout(Long value) {
        getProperties().setProperty(OPMConfigurationService.WEB_SERVICE_TIMEOUT, value.toString());
    }

}