package br.com.siam.integration;

import br.com.siam.dto.CompanyDataDTO;
import br.com.siam.util.CnpjValidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CnpjJaClient
        implements CompanyLookupClient {

    private static final String API_TOKEN =
            "89d842cf-d8f9-45a4-bc50-19379614668e-e5937ef7-a407-48d2-8a71-2b20565d7900";

    @Override
    public CompanyDataDTO findByCnpj(
            String cnpj
    ) {

        if (!CnpjValidator.isValid(cnpj)) {
            throw new IllegalArgumentException(
                    "CNPJ Inválido."
            );
        }

        System.out.println("CNPJ Enviado: " + cnpj);

        try {

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(
                                            "https://api.cnpja.com/office/"
                                                    + cnpj
                                    )
                            )
                            .header(
                                    "Authorization",
                                    API_TOKEN
                            )
                            .GET()
                            .build();

            HttpResponse<String> response =
                    HttpClient.newHttpClient()
                            .send(
                                    request,
                                    HttpResponse.BodyHandlers.ofString()
                            );

            System.out.println(
                    "Status: "
                            + response.statusCode()
            );

            System.out.println(
                    "Body: "
                            + response.body()
            );

            String body =
                    response.body();

            System.out.println(body);

            ObjectMapper objectMapper =
                    new ObjectMapper();

            JsonNode jsonNode =
                    objectMapper.readTree(body);

            CompanyDataDTO dto =
                    new CompanyDataDTO();

            dto.setCompanyName(
                    jsonNode
                            .path("company")
                            .path("name")
                            .asText()
            );

            dto.setAddress(
                    jsonNode
                            .path("address")
                            .path("street")
                            .asText()
                            + ", "
                            + jsonNode
                            .path("address")
                            .path("number")
                            .asText()
            );

            return dto;

        } catch (Exception exception) {

            throw new RuntimeException(
                    "Erro ao consultar CNPJ.",
                    exception
            );
        }
    }
}