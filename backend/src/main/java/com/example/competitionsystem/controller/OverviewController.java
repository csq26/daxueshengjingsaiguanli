package com.example.competitionsystem.controller;

import com.example.competitionsystem.mapper.ProjectMapper;
import com.example.competitionsystem.mapper.RecruitPostMapper;
import com.example.competitionsystem.mapper.TeamMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/overview")
@CrossOrigin(origins = "*")
public class OverviewController {
    private final TeamMapper teamMapper;
    private final ProjectMapper projectMapper;
    private final RecruitPostMapper recruitPostMapper;

    public OverviewController(TeamMapper teamMapper, ProjectMapper projectMapper, RecruitPostMapper recruitPostMapper) {
        this.teamMapper = teamMapper;
        this.projectMapper = projectMapper;
        this.recruitPostMapper = recruitPostMapper;
    }

    @GetMapping
    public Map<String, Object> overview() {
        Map<String, Object> data = new HashMap<>();
        data.put("teamCount", teamMapper.selectCount(null));
        data.put("projectCount", projectMapper.selectCount(null));
        data.put("recruitCount", recruitPostMapper.selectCount(null));
        return data;
    }
}
