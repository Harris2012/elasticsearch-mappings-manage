package cn.savory.esmanage.config;

import org.springframework.stereotype.Component;

@Component
public class GitlabConfig {

    /**
     * https://the.gitlab.cn/api/v4/projects
     */
    private String host;

    /**
     * 项目编号
     */
    private Integer projectId;

    /**
     * 用户私钥
     */
    private String privateToken;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getPrivateToken() {
        return privateToken;
    }

    public void setPrivateToken(String privateToken) {
        this.privateToken = privateToken;
    }
}
