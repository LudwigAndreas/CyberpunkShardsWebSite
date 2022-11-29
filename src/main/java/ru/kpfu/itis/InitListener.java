package ru.kpfu.itis;

import ru.kpfu.itis.dao.base.ShardRepository;
import ru.kpfu.itis.dao.base.ShardSectionRepository;
import ru.kpfu.itis.dao.impl.ShardRepositoryImpl;
import ru.kpfu.itis.dao.impl.ShardSectionRepositoryImpl;
import ru.kpfu.itis.exeptions.DBExeption;
import ru.kpfu.itis.model.ShardSection;

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
            ShardSectionRepository shardSectionRepository = new ShardSectionRepositoryImpl(con.getDataSource());
            ShardRepository shardRepository = new ShardRepositoryImpl(con.getDataSource());
            sce.getServletContext().setAttribute("shardSectionRepository", shardSectionRepository);
            sce.getServletContext().setAttribute("shardRepository", shardRepository);
        } catch (DBExeption e) {
            throw new RuntimeException(e);
        }
    }
}
