package com.example.competitionsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.competitionsystem.entity.RecruitPost;
import com.example.competitionsystem.mapper.RecruitPostMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recruits")
@CrossOrigin(origins = "*")
public class RecruitPostController {
    private final RecruitPostMapper recruitPostMapper;

    public RecruitPostController(RecruitPostMapper recruitPostMapper) {
        this.recruitPostMapper = recruitPostMapper;
    }

    @GetMapping
    public List<RecruitPost> list() {
        return recruitPostMapper.selectList(new QueryWrapper<RecruitPost>().orderByDesc("create_time"));
    }

    @PostMapping
    public RecruitPost create(@RequestBody RecruitPost recruitPost) {
        recruitPostMapper.insert(recruitPost);
        return recruitPost;
    }
}
