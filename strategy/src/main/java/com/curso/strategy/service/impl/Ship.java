package com.curso.strategy.service.impl;

import com.curso.strategy.model.StrategyName;
import com.curso.strategy.service.TransportStrategy;
import org.springframework.stereotype.Service;

@Service
public class Ship implements TransportStrategy {

    /** Custo por km **/
    private final static Double COST = 1200.00;

    @Override
    public Double routeCalc(Double milage) {
        return COST * milage;
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.Ship;
    }
}
