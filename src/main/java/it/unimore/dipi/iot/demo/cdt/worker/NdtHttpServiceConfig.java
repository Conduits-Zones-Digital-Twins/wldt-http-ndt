package it.unimore.dipi.iot.demo.cdt.worker;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class NdtHttpServiceConfig extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    private INdtDataManager ndtDataManager = null;

    public INdtDataManager getNdtDataManager(){

        if(this.ndtDataManager == null)
            this.ndtDataManager = new DefaultNdtDataManger();

        return this.ndtDataManager;
    }
}