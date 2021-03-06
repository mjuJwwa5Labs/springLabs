package com.mjuApps.springDemo.tasks.task08;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

/**
 * @author marek_j on 2018-04-15
 */
@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoEndpointExtension  {

    @ReadOperation
    public WebEndpointResponse<InfoResponse> info() {
        return new WebEndpointResponse<>(
                new InfoResponse("sda-wwa-5","sda-wwa-5 spring demo app"),200);
    }

    private static class InfoResponse {
        private String name;
        private String description;

        public InfoResponse() {}

        public InfoResponse(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }

}
