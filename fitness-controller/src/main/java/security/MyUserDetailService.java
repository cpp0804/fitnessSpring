package security;

import model.Login;
import model.Role;
import model.UserRole;
import service.LoginService;
import service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginService.getLoginByLoginName(username);

        if (login == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<GrantedAuthority> grantedAuthorities = obtainGrantedAuthorites(login.getUserId());
        User user = new User(username, login.getPassword(), true, true, true, true, grantedAuthorities);
        return user;
    }

    private Set<GrantedAuthority> obtainGrantedAuthorites(Integer userId) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<UserRole> userRoles = userRoleService.getUserRoleListByUser(userId);
        for (UserRole userRole : userRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRoleId().toString()));
        }
        return grantedAuthorities;
    }
}
