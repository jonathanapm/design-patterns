package com.curso.chainofresponsability.service;

import com.curso.chainofresponsability.model.AddressVo;

/**
 * Interface orquestradora de servicos de CEP
 */
public interface ZipCodeBaseHandlerService {

    /**
     * Se o CEP nao for encontrado pelo servico, o proximo e chamado
     *
     * @param zipCodeBaseHandlerService proximo servico a ser chamado
     */
    void next(ZipCodeBaseHandlerService zipCodeBaseHandlerService);

    /**
     * Se o cep existir, deve ser retornado caso contrario chama o proximo servico
     * @param zip cep a ser consultado
     */
    AddressVo consultZipCode(String zip);
}
