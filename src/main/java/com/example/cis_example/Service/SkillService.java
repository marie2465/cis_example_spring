package com.example.cis_example.Service;

import com.example.cis_example.entity.SkillEntity;
import com.example.cis_example.entity.UserEntity;
import com.example.cis_example.repository.AuthRepository;
import com.example.cis_example.repository.SkillRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepo;
    @Autowired
    private AuthRepository userRepo;

    @Autowired
    private Gson gson;

    @Async
    public CompletableFuture<SkillEntity> addSkill(SkillEntity skill, int userId) throws Exception {
        UserEntity user = userRepo.findById(userId).get();
        skill.setUserId(user.getId());
        if (skill == null) {
            throw new Exception("Введите данные");
        }
        if (skillRepo.findByCodeSkill(skill.getCodeSkill()) != null && skillRepo.findByNameSkill(skill.getNameSkill()) != null) {
            throw new Exception("Такая компетенция уже сцществует");
        }
        skillRepo.save(skill);
        return CompletableFuture.completedFuture(skill);
    }

    @Async
    public CompletableFuture<String> getSkillByName(String skillName) {
        SkillEntity skill = skillRepo.findByNameSkill(skillName);
        SkillEntity skillEntity = new SkillEntity();
        skillEntity.setCodeSkill(skill.getCodeSkill());
        skillEntity.setNameSkill(skill.getNameSkill());
        skillEntity.setTypeSkillId(skill.getTypeSkillId());
        skillEntity.setId(skill.getId());
        skillEntity.setUserId(skill.getUserId());
        return CompletableFuture.completedFuture(gson.toJson(skillEntity));
    }

    @Async
    public CompletableFuture<SkillEntity> updateSkill(int skillId, SkillEntity skillEntity) {
        SkillEntity skill = skillRepo.findById(skillId).get();
        skill.setCodeSkill(skillEntity.getCodeSkill());
        skill.setNameSkill(skillEntity.getNameSkill());
        skill.setTypeSkillId(skillEntity.getTypeSkillId());
        skillRepo.save(skill);
        return CompletableFuture.completedFuture(skill);
    }

    public void delete(int id) {
        skillRepo.deleteById(id);
    }

}
