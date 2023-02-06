package com.example.cis_example.controller;

import com.example.cis_example.Service.SkillService;
import com.example.cis_example.entity.SkillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService skill;

    @PostMapping
    public ResponseEntity createSkill(@RequestBody SkillEntity skillEntity,
                                      @RequestParam int userId) {
        try {
            return ResponseEntity.ok(skill.addSkill(skillEntity, userId).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getSkillByName(@RequestParam String skillName) {
        try {
            return ResponseEntity.ok(skill.getSkillByName(skillName).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

//    @GetMapping
//    public ResponseEntity getAllSkills() {
//        try {
//            return ResponseEntity.ok(skill.getAllSkill());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }

    @PutMapping
    public ResponseEntity updateSkill(@RequestBody SkillEntity skillEntity,
                                      @RequestParam int skillId) {
        try {
            return ResponseEntity.ok(skill.updateSkill(skillId, skillEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteSkill(@RequestParam int skillId){
        try {
            skill.delete(skillId);
            return ResponseEntity.ok("Competition is delete");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
