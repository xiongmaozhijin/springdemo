package main.domain;

public class SRole {
    private Long id;
    private String roleName;
    private Long userId;

    public SRole() {
    }

    public SRole(Long id, String roleName, Long userId) {
        this.id = id;
        this.roleName = roleName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
