package br.com.siam.dto;

public class CompanyDataDTO {

    private String companyName;
    private String address;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(
            String companyName
    ) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(
            String address
    ) {
        this.address = address;
    }
}