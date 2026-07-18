package com.example.competitionsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.competitionsystem.entity.Project;
import com.example.competitionsystem.mapper.ProjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public List<Project> list() {
        return projectMapper.selectList(new QueryWrapper<Project>().orderByDesc("create_time"));
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        projectMapper.insert(project);
        return project;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        projectMapper.deleteById(id);
        return "success";
    }
}
