package com.curso.chainofresponsability.repository.impl;

import com.curso.chainofresponsability.model.AddressVo;
import com.curso.chainofresponsability.repository.SearchZipRepository;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class SearchRepositoryImpl implements SearchZipRepository {

    private static final String CONTENT_TYPE = "application/json";

    @Override
    public AddressVo searchZipViaCep(String zip) {
            final String url = "https://viacep.com.br/ws/" + zip + "/json/";

            String response = executeHttp(url);

            return AddressVo.builder()
                    .response(response)
                    .viaCep(true).build();
    }

    @Override
    public AddressVo searchZipApiCep(String zip) {
        final String url = "https://ws.apicep.com/cep/" + zip + ".json";

        String response = executeHttp(url);

        return AddressVo.builder()
                .response(response)
                .apiCep(true).build();
    }

    @Override
    public AddressVo searchZipGov(String zip) {
        final String url = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + zip + "&formato=json";

        String response = executeHttp(url);
        return AddressVo.builder()
                .response(response)
                .apiRepublicVirtual(true).build();
    }

    private String executeHttp(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-type", CONTENT_TYPE)
                    .uri(new URI(url))
                    .GET().build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
