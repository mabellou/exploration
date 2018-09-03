package com.mabellou.specification;

import com.mabellou.specification.composite.Specification;

public class Cargo {
    private final Specification specification;

    public Cargo(final Specification specification) {
        this.specification = specification;
    }

    public Specification getSpecification() {
        return specification;
    }
}
