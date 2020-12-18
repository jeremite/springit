package com.travis.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
//@NoArgsConstructor
public class Vote extends Auditable{

    @Id
    @GeneratedValue
    private long id;

    //private int vote;

    //user
    //link

}
