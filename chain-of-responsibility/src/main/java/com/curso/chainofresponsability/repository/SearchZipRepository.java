package com.curso.chainofresponsability.repository;

import com.curso.chainofresponsability.model.AddressVo;

public interface SearchZipRepository {

    AddressVo searchZipViaCep(String zip);

    AddressVo searchZipApiCep(String zip);

    AddressVo searchZipGov(String zip);
}
