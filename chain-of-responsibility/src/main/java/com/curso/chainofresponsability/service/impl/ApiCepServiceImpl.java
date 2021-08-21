package com.curso.chainofresponsability.service.impl;

import com.curso.chainofresponsability.model.AddressVo;
import com.curso.chainofresponsability.repository.SearchZipRepository;
import com.curso.chainofresponsability.service.ZipCodeBaseHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiCepServiceImpl implements ZipCodeBaseHandlerService {

    @Autowired
    private ZipCodeBaseHandlerService zipCodeBaseHandlerService;

    @Autowired
    private SearchZipRepository searchZipRepository;

    @Override
    public void next(ZipCodeBaseHandlerService zipCodeBaseHandlerService) {
        this.zipCodeBaseHandlerService = zipCodeBaseHandlerService;
    }

    @Override
    public AddressVo consultZipCode(String zip) {
        if (zip.isEmpty()) {
            throw new RuntimeException("Cep nao informado");
        }

        return searchZipRepository.searchZipApiCep(zip.replace("-", ""));
    }
}
