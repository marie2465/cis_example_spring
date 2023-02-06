package com.example.cis_example.repository;

import com.example.cis_example.entity.SkillEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SkillRepository extends CrudRepository<SkillEntity, Integer> {
    SkillEntity findByNameSkill(String nameSkill);

    SkillEntity findByCodeSkill(String codeSkill);

    @Modifying
    @Transactional
    @Query(value = "UPDATE skill_entity SET user_id=?, code_skill=?, name_skill=?, type_skill_id=? WHERE id = ?", nativeQuery = true)
    SkillEntity updateSkill(String codeSkill, String nameSkill, int typeSkillId, int skillId);
}
