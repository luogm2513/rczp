package luo.rczp.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b_user_login", catalog = "rczp")
public class UserLogin implements java.io.Serializable{
	
    private String sessionId;
    private Long userId;
    private Date loginTime;
    private Date lastTime;
    private String loginServer;
    private String ipAddr;
    private String client;
    private String browser;
    private Integer online;
    
	// Constructors
  
	/** default constructor */
    public UserLogin(){  	
    }
	/** minimal constructor */
	public UserLogin(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public UserLogin(String sessionId,Long userId,
			Date loginTime, Date lastTime,
			String loginServer,String ipAddr,String client,
			String browser,Integer online) {
        this.sessionId = sessionId;
		this.userId = userId;
		this.loginTime = loginTime;
		this.lastTime = lastTime;
		this.loginServer = loginServer;
		this.ipAddr = ipAddr;
		this.client = client;
		this.browser = browser;
		this.online = online;
	}

	// Property accessors
	
	@Id
	@Column(name = "session_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

	@Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	@Column(name = "login_time", nullable = false)
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

	@Column(name = "last_time", nullable = false)
    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

	@Column(name = "login_server", nullable = false)
    public String getLoginServer() {
        return loginServer;
    }

    public void setLoginServer(String loginServer) {
        this.loginServer = loginServer == null ? null : loginServer.trim();
    }

	@Column(name = "ip_addr", nullable = false)
    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

	@Column(name = "client", nullable = false)
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

	@Column(name = "browser", nullable = false)
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

	@Column(name = "online", nullable = false)
    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}