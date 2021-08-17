package com.curso.strategy.service.impl;

import com.curso.strategy.model.StrategyName;
import com.curso.strategy.service.TransportStrategy;
import org.springframework.stereotype.Service;

@Service
public class Car implements TransportStrategy {

    /** Custo por km **/
    private final static Double COST = 350.00;

    @Override
    public Double routeCalc(Double milage) {
        return COST * milage;
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.Car;
    }
}
