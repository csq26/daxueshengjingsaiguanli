package com.example.competitionsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.competitionsystem.entity.Team;
import com.example.competitionsystem.mapper.TeamMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*")
public class TeamController {
    private final TeamMapper teamMapper;

    public TeamController(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @GetMapping
    public List<Team> list() {
        return teamMapper.selectList(new QueryWrapper<Team>().orderByDesc("create_time"));
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        teamMapper.insert(team);
        return team;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        teamMapper.deleteById(id);
        return "success";
    }
}
