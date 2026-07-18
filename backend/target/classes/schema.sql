CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    real_name VARCHAR(50) NOT NULL,
    college VARCHAR(100),
    major VARCHAR(100),
    skill_tag VARCHAR(255),
    contact VARCHAR(100),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS teams (
    id BIGINT PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    captain VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    members VARCHAR(255),
    description VARCHAR(500),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS projects (
    id BIGINT PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    team_id BIGINT,
    stage VARCHAR(50),
    deadline VARCHAR(20),
    description VARCHAR(500),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT PRIMARY KEY,
    task_name VARCHAR(100) NOT NULL,
    project_id BIGINT,
    assignee VARCHAR(50),
    status VARCHAR(20),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS recruit_posts (
    id BIGINT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(500),
    skill_tag VARCHAR(100),
    contact VARCHAR(100),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
