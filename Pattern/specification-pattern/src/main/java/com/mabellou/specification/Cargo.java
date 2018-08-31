package com.mabellou.specification;

public class Cargo {
    private final Specification specification;

    public Cargo(final Specification specification) {
        this.specification = specification;
    }

    public Specification getSpecification() {
        return specification;
    }
}
