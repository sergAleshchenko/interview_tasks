package spring_boot_questions.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot_questions.repository.DemoRepository;
import spring_boot_questions.rest.RestClientService;
import spring_boot_questions.services.DemoService;

@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {


    // Setter DI or Constructor DI
    // optional DI
    // immutability in nature
    // circularity of dependency


        private DemoRepository demoRepository;
//
//    public DemoServiceImpl() {
//    }
//
//    @Autowired
//    public DemoServiceImpl(DemoRepository demoRepository) {
//        this.demoRepository = demoRepository;
//    }
//
    @Override
    public void test() {
        demoRepository.saveOrder();
    }
}
