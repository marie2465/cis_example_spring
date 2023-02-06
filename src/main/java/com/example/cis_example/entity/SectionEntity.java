package com.example.cis_example.entity;

import jakarta.persistence.*;

@Entity
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nameSection;
    private double importance;
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SkillEntity skill;


    public SectionEntity() {
    }

}
