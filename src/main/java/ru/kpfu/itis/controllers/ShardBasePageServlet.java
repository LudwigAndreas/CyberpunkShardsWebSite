package ru.kpfu.itis.controllers;

import ru.kpfu.itis.dao.base.ShardRepository;
import ru.kpfu.itis.dao.base.ShardSectionRepository;
import ru.kpfu.itis.model.ShardSection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/database")
public class ShardBasePageServlet extends HttpServlet {
    private final static int SECTION_LIMIT = 100;
    private final static int SHARD_LIMIT = 600;
    private ShardSectionRepository shardSectionRepository;
    private ShardRepository shardRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        shardSectionRepository = (ShardSectionRepository) config.getServletContext().getAttribute("shardSectionRepository");
        shardRepository = (ShardRepository) config.getServletContext().getAttribute("shardRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShardSection> shardSectionList = shardSectionRepository.findAll(0, SECTION_LIMIT);
        for (ShardSection section: shardSectionList) {
            section.setShardList(shardRepository.getSectionContent(section.getId(), 0, SHARD_LIMIT));
        }
        getServletContext().setAttribute("shardSectionsList", shardSectionList);

        getServletContext().getRequestDispatcher("/WEB-INF/view/shardbase.jsp").forward(req, resp);
    }
}
