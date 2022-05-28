package org.parkinglot.paymet;

import org.parkinglot.exception.SpotTypeNotFound;
import org.parkinglot.modal.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PricingEngine {

    public static Map<Type, Integer> priceMap = new HashMap<>();

    public static int getPrice(Type type) {
        return Optional.ofNullable(priceMap.get(type)).orElseThrow(SpotTypeNotFound::new);
    }
}
