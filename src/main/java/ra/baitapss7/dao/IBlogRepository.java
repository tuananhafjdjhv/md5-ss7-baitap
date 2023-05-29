package ra.baitapss7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.baitapss7.model.Blog;
@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
}
