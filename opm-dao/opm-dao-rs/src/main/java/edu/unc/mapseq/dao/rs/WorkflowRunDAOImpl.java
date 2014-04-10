package edu.unc.mapseq.dao.rs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.unc.mapseq.config.MaPSeqConfigurationService;
import edu.unc.mapseq.dao.MaPSeqDAOException;
import edu.unc.mapseq.dao.WorkflowRunDAO;
import edu.unc.mapseq.dao.model.WorkflowRun;
import edu.unc.mapseq.dao.model.WorkflowRunStatusType;

/**
 * 
 * @author jdr0887
 */
public class WorkflowRunDAOImpl extends BaseEntityDAOImpl<WorkflowRun, Long> implements WorkflowRunDAO {

    private final Logger logger = LoggerFactory.getLogger(WorkflowRunDAOImpl.class);

    private MaPSeqConfigurationService configurationService;

    public WorkflowRunDAOImpl() {
        super(WorkflowRun.class);
    }

    public void init() {
        setRestServiceURL(String.format("http://%1$s:%2$d/cxf/%3$s/%3$sService", getConfigurationService()
                .getWebServiceHost("localhost"), 8181, WorkflowRun.class.getSimpleName()));
    }

    @Override
    public Long save(WorkflowRun entity) throws MaPSeqDAOException {
        logger.debug("ENTERING save(WorkflowRun)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public List<WorkflowRun> findByExample(WorkflowRun workflowRun) throws MaPSeqDAOException {
        return null;
    }

    @Override
    public WorkflowRun findById(Long id) throws MaPSeqDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        WorkflowRun workflowRun = client.path("findById/{id}", id).accept(MediaType.APPLICATION_JSON)
                .get(WorkflowRun.class);
        return workflowRun;
    }

    @Override
    public List<WorkflowRun> findByName(String name) throws MaPSeqDAOException {
        logger.debug("ENTERING findByName(String)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Collection<? extends WorkflowRun> ret = client.path("findByName/{name}", name)
                .accept(MediaType.APPLICATION_JSON).getCollection(WorkflowRun.class);
        return new ArrayList<WorkflowRun>(ret);
    }

    @Override
    public List<WorkflowRun> findByCreatorAndCreationDateRange(Long accountId, Date startDate, Date endDate)
            throws MaPSeqDAOException {
        logger.debug("ENTERING findByName(String)");

        String formattedStartDate = DateFormatUtils.ISO_DATE_FORMAT.format(startDate);
        String formattedEndDate = DateFormatUtils.ISO_DATE_FORMAT.format(endDate);
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());

        Collection<? extends WorkflowRun> ret = client
                .path("findByCreatorAndCreationDateRange/{accountId}/{startDate}/{endDate}", accountId,
                        formattedStartDate, formattedEndDate).accept(MediaType.APPLICATION_JSON)
                .getCollection(WorkflowRun.class);
        return new ArrayList<WorkflowRun>(ret);
    }

    @Override
    public List<WorkflowRun> findByStudyNameAndSampleNameAndWorkflowName(String studyName, String sampleName,
            String workflowName) throws MaPSeqDAOException {
        logger.debug("ENTERING findByStudyNameAndSampleNameAndWorkflowName(String, String, String)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Collection<? extends WorkflowRun> ret = client
                .path("findByStudyNameAndSampleNameAndWorkflowName/{studyName}/{sampleName}/{workflowName}", studyName,
                        sampleName, workflowName).accept(MediaType.APPLICATION_JSON).getCollection(WorkflowRun.class);
        return new ArrayList<WorkflowRun>(ret);
    }

    @Override
    public List<WorkflowRun> findByWorkflowId(Long id) throws MaPSeqDAOException {
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Collection<? extends WorkflowRun> ret = client.path("findByWorkflowId/{workflowId}", id)
                .accept(MediaType.APPLICATION_JSON).getCollection(WorkflowRun.class);
        return new ArrayList<WorkflowRun>(ret);
    }

    @Override
    public List<WorkflowRun> findByCreatorAndStatusAndCreationDateRange(Long accountId, WorkflowRunStatusType status,
            Date startDate, Date endDate) {
        logger.debug("ENTERING findByCreatorAndStatusAndCreationDateRange(Long, WorkflowRunStatusType, Date, Date)");

        String formattedStartDate = DateFormatUtils.ISO_DATE_FORMAT.format(startDate);
        String formattedEndDate = DateFormatUtils.ISO_DATE_FORMAT.format(endDate);
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());

        Collection<? extends WorkflowRun> ret = client
                .path("findByCreatorAndStatusAndCreationDateRange/{accountId}/{status}/{startDate}/{endDate}",
                        accountId, formattedStartDate, formattedEndDate).accept(MediaType.APPLICATION_JSON)
                .getCollection(WorkflowRun.class);
        return new ArrayList<WorkflowRun>(ret);
    }

    public MaPSeqConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(MaPSeqConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

}
