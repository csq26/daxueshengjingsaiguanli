DELETE FROM recruit_posts;
DELETE FROM tasks;
DELETE FROM projects;
DELETE FROM teams;
DELETE FROM users;

INSERT INTO users (id, username, real_name, college, major, skill_tag, contact) VALUES
(1001, 'alice', 'Alice', '计算机学院', '软件工程', 'Java,Vue', 'alice@school.edu'),
(1002, 'bob', 'Bob', '自动化学院', '智能科学', 'Python,算法', 'bob@school.edu');

INSERT INTO teams (id, team_name, captain, category, members, description) VALUES
(2001, 'AI创新小队', 'Alice', '人工智能', 'Alice,Bob,Carol', '面向校园场景的智能推荐系统'),
(2002, '数学建模攻坚队', 'David', '数学建模', 'David,Eve', '参与省级数学建模竞赛');

INSERT INTO projects (id, project_name, team_id, stage, deadline, description) VALUES
(3001, '校园活动智能推荐', 2001, '开发', '2026-08-15', '做一个基于兴趣标签的推荐系统'),
(3002, '交通流量预测', 2002, '调研', '2026-09-01', '构建预测模型并撰写论文');

INSERT INTO tasks (id, task_name, project_id, assignee, status) VALUES
(4001, '需求分析', 3001, 'Alice', '进行中'),
(4002, '原型设计', 3001, 'Bob', '待开始');

INSERT INTO recruit_posts (id, title, content, skill_tag, contact) VALUES
(5001, '招募前端开发', '希望找志同道合的前端成员，熟悉Vue和Element UI', 'Vue,ElementUI', 'wechat:alice01'),
(5002, '招募算法研究员', '参与智能优化方向，欢迎有Python基础的同学', 'Python,机器学习', 'qq:123456');
