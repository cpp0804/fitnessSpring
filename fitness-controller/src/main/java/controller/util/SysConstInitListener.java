package controller.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import service.ResourceService;
import service.UserService;

import javax.servlet.ServletContext;

public class SysConstInitListener implements InitializingBean, ServletContextAware {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;


    @Override
    public void afterPropertiesSet() throws Exception {
        resourceService.init_RESOURCESTREE();
        userService.init_USERMAP();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
