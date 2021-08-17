package com.curso.strategy;

import com.curso.strategy.model.StrategyName;
import com.curso.strategy.utils.StrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyApplication implements CommandLineRunner {

    @Autowired
    private StrategyFactory factory;

    public static void main(String[] args) {
        SpringApplication.run(StrategyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Double km = 900.00;

        //calculo transporte de aviao
        System.out.println(StrategyName.Airplane.name() + ": " + factory.findStrategy(StrategyName.Airplane).routeCalc(km));

        //calculo transporte de onibus
        System.out.println(StrategyName.Buss.name() + ": " + factory.findStrategy(StrategyName.Buss).routeCalc(km));

        //calculo transporte de carro
        System.out.println(StrategyName.Car.name() + ": " + factory.findStrategy(StrategyName.Car).routeCalc(km));

        //calculo transporte de navio
        System.out.println(StrategyName.Ship.name() + ": " + factory.findStrategy(StrategyName.Ship).routeCalc(km));

    }
}
