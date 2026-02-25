package backend.url.shortener.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "short_urls")
public class ShortURL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String originalURL;

    @Column(nullable = false, unique = true)
    private String shortURL;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "shortUrl", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClickEvent> clicks = new ArrayList<>();

    public long getClickCount() {
        return clicks.size();
    }

}
