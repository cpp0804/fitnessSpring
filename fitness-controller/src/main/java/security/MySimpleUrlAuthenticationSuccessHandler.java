package security;

import model.Login;
import model.User;
import service.LoginService;
import service.RoleResourceService;
import service.UserService;
import service.commonService.util.SysConst;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MySimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleResourceService roleResourceService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();

        AuthencationResult authencationResult = new AuthencationResult();

        setAuthencationResult(request, authentication, authencationResult);

        printWriter.print(JSONObject.fromObject(authencationResult));
        printWriter.flush();
        printWriter.close();

    }

    private void setAuthencationResult(HttpServletRequest request, Authentication authentication, AuthencationResult authencationResult) {
        Login login = loginService.getLoginByLoginName(authentication.getName());
        User user = userService.getUserById(login.getUserId());
        authencationResult.setUser(user);
        authencationResult.setLogName(login.getLoginName());
        authencationResult.setStatus(true);
        authencationResult.setMsg("登录验证成功");
        doLoginForUser(request, authentication, authencationResult, user);
    }

    private void doLoginForUser(HttpServletRequest request, Authentication authentication, AuthencationResult authencationResult, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUserId());
        List<Integer> roleList = roleResourceService.getResourceIdList(getRoleList(authentication));
        if (roleList == null) {
            authencationResult.setMenuJSON(null);
            authencationResult.setMsg("您还未分配角色，请于管理员联系");
        } else {
            if (roleList.get(0).equals(1)) {
                authencationResult.setRole("coach");
            } else {
                authencationResult.setRole("student");
            }
            JSONObject menuJSON = SysConst.RESOURCESTREE.buildMenuResourceTree(roleList);
            authencationResult.setMenuJSON(menuJSON);
        }

        session.setAttribute("roleList", roleList);

    }

    private List<Integer> getRoleList(Authentication authentication) {
        List<Integer> roleList = new ArrayList<>();
        Collection<GrantedAuthority> grantedAuthorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
        Iterator<GrantedAuthority> iterator = grantedAuthorities.iterator();
        while (iterator.hasNext()) {
            roleList.add(Integer.parseInt(iterator.next().getAuthority()));
        }
        return roleList;
    }
}
