package ru.code.open.functions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.code.open.util.ImmutablePair;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@AllArgsConstructor
@Getter
public class SingleFunctionContainer {

    private ImmutablePair<Set<String>, Function<Map<String, Double>, Double>> functions;
    private Set<String> possibleValues;
}
