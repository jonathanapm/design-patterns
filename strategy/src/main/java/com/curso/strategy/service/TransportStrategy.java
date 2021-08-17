package com.curso.strategy.service;

import com.curso.strategy.model.StrategyName;

public interface TransportStrategy {

    /**
     * Recebe a quantidade de quilometros e realiza o calculo do preco da rota
     * @param milage quantidade de quilometros
     * @return valor da rota
     */
    Double routeCalc(Double milage);

    /**
     * Retorna a estrategia como identificador unico
     */
    StrategyName getStrategyName();
}
