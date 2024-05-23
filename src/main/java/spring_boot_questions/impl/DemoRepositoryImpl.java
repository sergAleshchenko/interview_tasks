package spring_boot_questions.impl;

import org.springframework.stereotype.Repository;
import spring_boot_questions.repository.DemoRepository;

/**
 * @author Sergei Aleshchenko
 */
@Repository
public class DemoRepositoryImpl implements DemoRepository {
    @Override
    public void saveOrder() {
        System.out.println("DemoRepositoryImpl.saveOrder() ..... complete");
    }
}
