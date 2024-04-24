package Posttest5;

class Agent {
    public String nama_agent;
    public String role;
    public String skill;
    public String utility;
   
    Agent(String nama_agent, String role, String skill, String utility) {
        this.nama_agent = nama_agent;
        this.role = role;
        this.skill = skill;
        this.utility = utility;
    }
    public void setNama_agent(String nama_agent) {
        this.nama_agent = nama_agent;
    }
    public void setRole_agent(String role) {
        this.role = role;
    }
    public void setSkill_agent(String skill) {
        this.skill = skill;
    }
    public void setUtility_agent(String utility) {
        this.nama_agent = utility;
    }
    public String getNama() {
        return nama_agent;
    }
    public String getRole() {
        return role;
    }
    public String getSkill() {
        return skill;
    }
    public String getUtility() {
        return utility;
    }
}