package main.domain;

public class SPermission {
    private Long id;
    private String permission;
    private Long roleId;

    public SPermission(Long id, String permission, Long roleId) {
        this.id = id;
        this.permission = permission;
        this.roleId = roleId;
    }

    public SPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
