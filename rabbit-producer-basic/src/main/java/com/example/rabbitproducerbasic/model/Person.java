package com.example.rabbitproducerbasic.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {

    private String name;
    private Integer collageCompletedYear;
    private LocalDate bornAt;
    private Boolean active; 
	
}
