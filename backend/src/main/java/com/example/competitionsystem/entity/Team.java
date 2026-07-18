package com.example.competitionsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName("teams")
public class Team {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String teamName;
    private String captain;
    private String category;
    private String members;
    private String description;
    private LocalDateTime createTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public String getCaptain() { return captain; }
    public void setCaptain(String captain) { this.captain = captain; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getMembers() { return members; }
    public void setMembers(String members) { this.members = members; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
