package priv.rdo.sdawwa5.task08;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
class InfoEndpointExtension {

    @ReadOperation
    public WebEndpointResponse<InfoResponse> info() {
        return new WebEndpointResponse<>(
                new InfoResponse(
                        "sda-wwa-5",
                        "sda-wwa-5 spring demo app"
                ),
                200
        );
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class InfoResponse {
        private String name;
        private String desc;
    }
}
