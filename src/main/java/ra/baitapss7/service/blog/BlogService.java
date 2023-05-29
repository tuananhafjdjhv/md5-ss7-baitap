package ra.baitapss7.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.baitapss7.dao.IBlogRepository;
import ra.baitapss7.model.Blog;

import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(), 5,sort);
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long aLong) {
        return blogRepository.findById(aLong);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long aLong) {
        blogRepository.deleteById(aLong);
    }

    @Override
    public Iterable<Blog> findAll() {
      return   blogRepository.findAll();
    }
}
