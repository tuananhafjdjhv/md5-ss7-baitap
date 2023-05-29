package ra.baitapss7.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "categoryName",columnDefinition = "text")
    private String categoryName;
    @OneToMany(mappedBy = "category",targetEntity = Blog.class)
    private Set<Blog> blogs;

    public Category() {
    }

    public Category( String categoryName, Set<Blog> blogs) {
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
