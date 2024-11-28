package org.example.microservice_demo.e2eTesting;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

@WireMockTest(httpPort=8081)
public class ExternalServiceTest {
    @Test
    public void testExternalService() {
        stubFor(get(WireMock.urlEqualTo("/externalservice"))
                .willReturn(aResponse()
                        .withHeader("Content-Type",
                                "application/json")
                        .withBody("{\"message\":\"success\"}")));

    }
}
