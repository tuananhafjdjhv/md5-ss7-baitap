package ra.baitapss7.service.blog;

import org.springframework.data.domain.Page;
import ra.baitapss7.model.Blog;
import ra.baitapss7.service.IGenericService;

public interface IBlogService extends IGenericService<Blog,Long> {

    Iterable<Blog> findAll();
}
