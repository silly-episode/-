package com.dd.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    private Integer qid;
    private Integer model;
    private String question;
    private String answer;
    
}
