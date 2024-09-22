package com.leaf.domain;

import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.MappedSuperclass;

@MappedSuperclass
public interface ID {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id();
}
