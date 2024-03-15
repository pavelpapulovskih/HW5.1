package org.max.home.accu;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.max.seminar.accu.AbstractTest;
import org.max.seminar.accu.location.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GetLocationHomeWork extends AbstractTest {

    HttpResponse response = httpClient.execute(request);
    int actualStatus = response.getStatusLine().getStatusCode();

    //then
    assertEquals(200, actualStatus);
}

@Test
void get_shouldReturnBadRequest() throws IOException, URISyntaxException {
    logger.info("Тест код ответ 400 запущен");
    //given
    CloseableHttpClient httpClient = HttpClients.createDefault();
    logger.debug("http клиент создан");
    HttpGet request = new HttpGet(getBaseUrl()+"/locations/v1/cities/autoisssss");
    URI uri = new URIBuilder(request.getURI())
            .build();

    request.setURI(uri);

    //when
    HttpResponse response = httpClient.execute(request);
    int actualStatus = response.getStatusLine().getStatusCode();

    //then
    assertEquals(400, actualStatus);
}

@Test
void get_shouldReturn500() throws IOException, URISyntaxException {
    logger.info("Тест код ответ 500 запущен");
    //given
    CloseableHttpClient httpClient = HttpClients.createDefault();
    logger.debug("http клиент создан");
    HttpGet request = new HttpGet(getBaseUrl()+"/locations/v1/cities/autoicanerror");
    URI uri = new URIBuilder(request.getURI())
            .build();

    request.setURI(uri);

    //when
    HttpResponse response = httpClient.execute(request);
    int actualStatus = response.getStatusLine().getStatusCode();

    //then
    assertEquals(500, actualStatus);
}
}
}
