package org.renci.opm.config;

public interface OPMConfigurationService {

    public static final String VERSION = "version";

    public static final String RUN_MODE = "runMode";

    public static final String WEB_SERVICE_HOST = "webServiceHost";

    public static final String WEB_SERVICE_TIMEOUT = "webServiceTimeout";

    public String getVersion(String def);

    public RunModeType getRunMode();

    public String getWebServiceHost(String def);

    public Long getWebServiceTimeout(Long def);

}
