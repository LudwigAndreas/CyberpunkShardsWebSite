package ru.kpfu.itis.model;

import lombok.*;

import java.util.List;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShardSection {
    private Long id;
    private String title;
    private List<Shard> shardList;

    public String getTitle() {
        return title.toUpperCase(Locale.ROOT);
    }
}
