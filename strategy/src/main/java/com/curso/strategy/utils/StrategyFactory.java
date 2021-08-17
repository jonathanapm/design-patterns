package com.curso.strategy.utils;

import com.curso.strategy.model.StrategyName;
import com.curso.strategy.service.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StrategyFactory {

    private Map<StrategyName, TransportStrategy> strategies;

    @Autowired
    public StrategyFactory(final Set<TransportStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public TransportStrategy findStrategy(final StrategyName strategyName) {
        return strategies.get(strategyName);
    }

    private void createStrategy(final Set<TransportStrategy> strategySet) {
        strategies = new HashMap();

        strategySet.forEach(strategy ->
            strategies.put(strategy.getStrategyName(), strategy)
        );
    }
}
