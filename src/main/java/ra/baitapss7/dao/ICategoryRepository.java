package ra.baitapss7.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.baitapss7.model.Category;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
