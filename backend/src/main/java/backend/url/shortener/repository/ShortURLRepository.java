package backend.url.shortener.repository;

import backend.url.shortener.models.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortURLRepository extends JpaRepository<ShortURL, Long> {

    Optional<ShortURL> findByShortCode(String shortCode);
    boolean existsByShortCode(String shortCode);
    Optional<ShortURL> findById(Long id);
}
