package ru.kpfu.itis;

import ru.kpfu.itis.dao.base.ShardRepository;
import ru.kpfu.itis.dao.base.ShardSectionRepository;
import ru.kpfu.itis.dao.base.UserRepository;
import ru.kpfu.itis.dao.impl.ShardRepositoryImpl;
import ru.kpfu.itis.dao.impl.ShardSectionRepositoryImpl;
import ru.kpfu.itis.dao.impl.UserRepositoryImpl;
import ru.kpfu.itis.exeptions.DBExeption;
import ru.kpfu.itis.model.ShardSection;
import ru.kpfu.itis.services.UserService;
import ru.kpfu.itis.services.impl.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider con = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("shardSectionRepository", new ShardSectionRepositoryImpl(con.getDataSource()));
            sce.getServletContext().setAttribute("shardRepository", new ShardRepositoryImpl(con.getDataSource()));
            sce.getServletContext().setAttribute("userRepository", new UserRepositoryImpl(con.getDataSource()));
            sce.getServletContext().setAttribute("userService", new UserServiceImpl());
        } catch (DBExeption e) {
            throw new RuntimeException(e);
        }
    }
}
