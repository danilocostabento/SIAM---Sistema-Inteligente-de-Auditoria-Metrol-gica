package br.com.siam.integration;

import br.com.siam.dto.CompanyDataDTO;

public interface CompanyLookupClient {

    CompanyDataDTO findByCnpj(
            String cnpj
    );
}