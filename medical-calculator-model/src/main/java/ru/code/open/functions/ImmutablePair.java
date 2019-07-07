package ru.code.open.functions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ImmutablePair<C, F> {

    private C cField;
    private F fField;
}
