package it.unimore.dipi.iot.demo.cdt.worker;

import it.unimore.dipi.iot.wldt.cache.IWldtCache;
import it.unimore.dipi.iot.wldt.exception.WldtConfigurationException;
import it.unimore.dipi.iot.wldt.exception.WldtRuntimeException;
import it.unimore.dipi.iot.wldt.worker.WldtWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NdtHttpWorker extends WldtWorker<NdtHttpWorkerConfiguration, String, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(NdtHttpWorker.class);

    private static final String METRIC_BASE_IDENTIFIER = "dummy_worker";

    private static final String WORKER_EXECUTION_TIME_METRICS_FIELD = "execution_time";

    private static final String WORKER_VALUE_METRICS_FIELD = "execution_value";

    private static final String CACHE_VALUE_KEY = "physical_obj_value";

    public static final String DEFAULT_PROCESSING_PIPELINE = "default_processing_pipeline";

    private String wldtId = null;

    private int RUN_COUNT_LIMIT = 10000;

    public NdtHttpWorker(String wldtId, NdtHttpWorkerConfiguration workerConfiguration) {
        super(workerConfiguration);
        this.wldtId = wldtId;
    }

    public NdtHttpWorker(String wldtId, NdtHttpWorkerConfiguration workerConfiguration, IWldtCache<String, Integer> wldtCache) {
        super(workerConfiguration, wldtCache);
        this.wldtId = wldtId;
    }

    @Override
    public void startWorkerJob() throws WldtConfigurationException, WldtRuntimeException {
        try{

            //String[] args = new String[0];
            new NdtHttpService().run("server","configuration.yml");
        }catch (Exception e){
            throw new WldtRuntimeException(e.getMessage());
        }
    }
}
