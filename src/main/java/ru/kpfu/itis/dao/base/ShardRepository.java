package ru.kpfu.itis.dao.base;

import ru.kpfu.itis.model.Shard;

import java.util.List;

public interface ShardRepository extends CrudRepository<Shard, Long> {
    List<Shard> getSectionContent(Long sectionId, int page, int limit);
}
