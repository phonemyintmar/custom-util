package com.pm;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;

/**
 * @author PM
 * @Created 01/06/2023
 * <p>
 * created by sayr G
 */
public class NetworkUtils {

    public WebClient getProxiedWebClient(String host, Integer port) {
        HttpClient httpClient = HttpClient.create()
                .proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
                        .host(host)
                        .port(port));

        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        return WebClient.builder().clientConnector(connector).build();
    }

    public RestTemplate getProxiedRestTemplate(String host, Integer port) {
        final SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
        requestFactory.setProxy(proxy);
        return new RestTemplate(requestFactory);
    }

    public static boolean isReachable(String addressStr) {
        boolean isReachable = false;
        try {
            InetAddress address = InetAddress.getByName(addressStr);
            isReachable = address.isReachable(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isReachable;
    }

    public static String getIpAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    public static HttpHeaders getCommonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }


}
