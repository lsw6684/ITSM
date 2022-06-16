package com.service.ITSM.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Size(min=2, max=30)
    private String TITLE;
    private String CLASSIFICATION;
    private String TYPE;
    private String NAME;
    private String CONTENT;
    private String CREATE_DATE;
    private String UPDATE_DATE;
}
