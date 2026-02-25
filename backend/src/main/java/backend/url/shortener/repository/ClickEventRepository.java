package backend.url.shortener.repository;

import backend.url.shortener.models.ClickEvent;
import backend.url.shortener.models.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {
    List<ClickEvent> findByShortUrlOrderByClickedAtDesc(ShortURL shortUrl);
}