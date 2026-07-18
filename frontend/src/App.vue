<template>
  <div class="page">
    <header class="hero">
      <div>
        <h1>大学生竞赛组队与项目管理系统</h1>
        <p>解决“找队友难、项目进度难追踪”的实际问题，帮助学生高效组队和管理项目。</p>
      </div>
      <div class="stats">
        <div class="stat-card">
          <strong>{{ overview.teamCount }}</strong>
          <span>活跃队伍</span>
        </div>
        <div class="stat-card">
          <strong>{{ overview.projectCount }}</strong>
          <span>进行中项目</span>
        </div>
        <div class="stat-card">
          <strong>{{ overview.recruitCount }}</strong>
          <span>招募信息</span>
        </div>
      </div>
    </header>

    <main class="content">
      <section class="panel">
        <h2>创建队伍</h2>
        <form @submit.prevent="createTeam">
          <input v-model="teamForm.teamName" placeholder="队伍名称" required />
          <input v-model="teamForm.captain" placeholder="队长姓名" required />
          <input v-model="teamForm.category" placeholder="竞赛方向" required />
          <input v-model="teamForm.members" placeholder="成员名单" required />
          <textarea v-model="teamForm.description" placeholder="队伍目标与说明"></textarea>
          <button type="submit">保存队伍</button>
        </form>
      </section>

      <section class="panel">
        <h2>创建项目</h2>
        <form @submit.prevent="createProject">
          <input v-model="projectForm.projectName" placeholder="项目名称" required />
          <input v-model="projectForm.teamId" placeholder="所属队伍ID" required />
          <input v-model="projectForm.stage" placeholder="阶段（如开发/测试/答辩）" required />
          <input v-model="projectForm.deadline" placeholder="截止日期" required />
          <textarea v-model="projectForm.description" placeholder="项目说明"></textarea>
          <button type="submit">保存项目</button>
        </form>
      </section>

      <section class="panel">
        <h2>发布招募信息</h2>
        <form @submit.prevent="createRecruit">
          <input v-model="recruitForm.title" placeholder="标题" required />
          <textarea v-model="recruitForm.content" placeholder="招募内容"></textarea>
          <input v-model="recruitForm.skillTag" placeholder="技能标签" />
          <input v-model="recruitForm.contact" placeholder="联系方式" />
          <button type="submit">发布招募</button>
        </form>
      </section>
    </main>

    <main class="content grid">
      <section class="panel">
        <h2>队伍列表</h2>
        <div v-for="team in teams" :key="team.id" class="card">
          <h3>{{ team.teamName }}</h3>
          <p>队长：{{ team.captain }} | 方向：{{ team.category }}</p>
          <p>成员：{{ team.members }}</p>
          <p>{{ team.description }}</p>
          <button class="danger" @click="deleteTeam(team.id)">删除</button>
        </div>
      </section>

      <section class="panel">
        <h2>项目列表</h2>
        <div v-for="project in projects" :key="project.id" class="card">
          <h3>{{ project.projectName }}</h3>
          <p>阶段：{{ project.stage }} | 截止：{{ project.deadline }}</p>
          <p>{{ project.description }}</p>
          <button class="danger" @click="deleteProject(project.id)">删除</button>
        </div>
      </section>
    </main>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const overview = ref({ teamCount: 0, projectCount: 0, recruitCount: 0 });
const teams = ref([]);
const projects = ref([]);
const recruits = ref([]);

const teamForm = ref({ teamName: '', captain: '', category: '', members: '', description: '' });
const projectForm = ref({ projectName: '', teamId: '', stage: '', deadline: '', description: '' });
const recruitForm = ref({ title: '', content: '', skillTag: '', contact: '' });

const loadData = async () => {
  const [overviewRes, teamRes, projectRes, recruitRes] = await Promise.all([
    axios.get('/api/overview'),
    axios.get('/api/teams'),
    axios.get('/api/projects'),
    axios.get('/api/recruits')
  ]);
  overview.value = overviewRes.data;
  teams.value = teamRes.data;
  projects.value = projectRes.data;
  recruits.value = recruitRes.data;
};

const createTeam = async () => {
  await axios.post('/api/teams', teamForm.value);
  teamForm.value = { teamName: '', captain: '', category: '', members: '', description: '' };
  await loadData();
};

const createProject = async () => {
  await axios.post('/api/projects', { ...projectForm.value, teamId: Number(projectForm.value.teamId) });
  projectForm.value = { projectName: '', teamId: '', stage: '', deadline: '', description: '' };
  await loadData();
};

const createRecruit = async () => {
  await axios.post('/api/recruits', recruitForm.value);
  recruitForm.value = { title: '', content: '', skillTag: '', contact: '' };
  await loadData();
};

const deleteTeam = async (id) => {
  await axios.delete(`/api/teams/${id}`);
  await loadData();
};

const deleteProject = async (id) => {
  await axios.delete(`/api/projects/${id}`);
  await loadData();
};

onMounted(loadData);
</script>

<style scoped>
* { box-sizing: border-box; }
body { margin: 0; font-family: Arial, sans-serif; background: #f6f8fc; }
.page { padding: 24px; max-width: 1200px; margin: 0 auto; }
.hero { background: linear-gradient(120deg, #2563eb, #1d4ed8); color: white; padding: 24px; border-radius: 16px; display: flex; justify-content: space-between; gap: 16px; align-items: center; }
.stats { display: flex; gap: 12px; flex-wrap: wrap; }
.stat-card { background: rgba(255,255,255,0.15); padding: 12px 14px; border-radius: 12px; min-width: 110px; display: flex; flex-direction: column; }
.stat-card strong { font-size: 24px; }
.content { margin-top: 20px; display: grid; gap: 16px; }
.grid { grid-template-columns: 1fr 1fr; }
.panel { background: white; border-radius: 16px; padding: 16px; box-shadow: 0 6px 16px rgba(0,0,0,0.06); }
form { display: grid; gap: 10px; }
input, textarea, button { font: inherit; padding: 10px 12px; border-radius: 10px; border: 1px solid #dbe4f0; }
textarea { min-height: 80px; resize: vertical; }
button { background: #2563eb; color: white; border: none; cursor: pointer; }
button.danger { background: #ef4444; }
.card { border: 1px solid #e5e7eb; border-radius: 12px; padding: 12px; margin-bottom: 12px; }
@media (max-width: 900px) { .hero, .grid { grid-template-columns: 1fr; display: grid; } }
</style>
