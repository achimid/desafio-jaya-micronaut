package br.com.achimid;

import br.com.achimid.infra.config.SwaggerConfiguration;
import io.micronaut.runtime.Micronaut;


public class Application extends SwaggerConfiguration {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
