package multithreading.locking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Aleshchenko
 */
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public void createCategory(Integer id, String name) {
        categoryRepository.save(new Category(1, name));
    }

}
