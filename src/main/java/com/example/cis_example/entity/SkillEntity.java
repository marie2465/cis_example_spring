package com.example.cis_example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String codeSkill;
    private String nameSkill;
    private int typeSkillId;
    private int UserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    private List<SectionEntity> section;

    public SkillEntity() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCodeSkill() {
        return codeSkill;
    }

    public void setCodeSkill(String codeSkill) {
        this.codeSkill = codeSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public int getTypeSkillId() {
        return typeSkillId;
    }

    public void setTypeSkillId(int typeSkillId) {
        this.typeSkillId = typeSkillId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public List<SectionEntity> getSection() {
        return section;
    }

    public void setSection(List<SectionEntity> section) {
        this.section = section;
    }
}
