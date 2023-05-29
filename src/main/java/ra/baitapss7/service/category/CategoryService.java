package ra.baitapss7.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.baitapss7.dao.IBlogRepository;
import ra.baitapss7.dao.ICategoryRepository;
import ra.baitapss7.model.Category;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(),5,sort);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return categoryRepository.findById(aLong);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
