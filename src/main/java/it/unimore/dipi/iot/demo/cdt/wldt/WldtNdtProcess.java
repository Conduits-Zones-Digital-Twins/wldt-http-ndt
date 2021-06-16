package it.unimore.dipi.iot.demo.cdt.wldt;

import it.unimore.dipi.iot.demo.cdt.worker.NdtHttpWorker;
import it.unimore.dipi.iot.demo.cdt.worker.NdtHttpWorkerConfiguration;
import it.unimore.dipi.iot.wldt.engine.WldtConfiguration;
import it.unimore.dipi.iot.wldt.engine.WldtEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class WldtNdtProcess {

    private static final String TAG = "[WLDT-Process]";

    private static final Logger logger = LoggerFactory.getLogger(WldtNdtProcess.class);

    public static void main(String[] args)  {

        try{

            logger.info("{} Initializing WLDT-Engine ... ", TAG);

            //Manual creation of the WldtConfiguration
            WldtConfiguration wldtConfiguration = new WldtConfiguration();
            wldtConfiguration.setDeviceNameSpace("it.unimore.dipi.things");
            wldtConfiguration.setWldtBaseIdentifier("wldt");
            wldtConfiguration.setWldtStartupTimeSeconds(10);
            wldtConfiguration.setApplicationMetricsEnabled(false);

            WldtEngine wldtEngine = new WldtEngine(wldtConfiguration);

            NdtHttpWorker ndtHttpWorker = new NdtHttpWorker(UUID.randomUUID().toString(), new NdtHttpWorkerConfiguration());

            wldtEngine.addNewWorker(ndtHttpWorker);
            wldtEngine.startWorkers();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

