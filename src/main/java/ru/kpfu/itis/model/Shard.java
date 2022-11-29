package ru.kpfu.itis.model;

import lombok.*;

import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shard {
    private Long id;
    private Long sectionId;
    private String title;
    private String content;

    public String getTitle() {
        return title.toUpperCase(Locale.ROOT);
    }

    public String getContent() {
        return content.replace("\n", "<br>");
    }
}
