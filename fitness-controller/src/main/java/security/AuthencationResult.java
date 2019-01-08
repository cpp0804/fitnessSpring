package security;


import model.User;
import net.sf.json.JSONObject;

public class AuthencationResult {

    private JSONObject menuJSON;

    private boolean status;

    private User user;

    private String logName;

    private String msg;

    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setMenuJSON(JSONObject menuJSON) {
        this.menuJSON = menuJSON;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getMenuJSON() {
        return menuJSON;
    }

    public boolean isStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public String getLogName() {
        return logName;
    }

    public String getMsg() {
        return msg;
    }
}
