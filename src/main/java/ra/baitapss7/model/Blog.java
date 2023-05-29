package ra.baitapss7.model;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String blogName;
    private String blogDetail;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog(String blogName, String blogDetail, Category category) {
        this.blogName = blogName;
        this.blogDetail = blogDetail;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(String blogDetail) {
        this.blogDetail = blogDetail;
    }
}
