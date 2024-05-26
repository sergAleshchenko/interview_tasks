package evgeny_borisov.spring_puzzlers.part_1;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @author Sergei Aleshchenko
 */
@Service
@Getter
@Setter
public class JokerConfServiceImpl implements JokerConfService {

    private String conference;

    @Autowired
    private JokerConfService proxy;

    @Audit
    public void pay() {
        System.out.println("JokerConfServiceImpl.pay() is called. Conference: "
                + conference);
    }

    @Transactional
    public void payTransactional() {
        System.out.println("JokerConfServiceImpl.payTransactional() is called. Conference: "
                + conference);
        proxy.informAboutPayment();
    }

    @PostConstruct
    public void setup() {
        System.out.println("JokerConfServiceImpl.setup() is called. Conference: "
                + conference);
    }

    @PostInitialize
    @Transactional
    public void warmCache() {
        System.out.println("JokerConfServiceImpl.warmCache() is called.");
    }

    @Override
    public void processPayment() {
        System.out.println("JokerConfServiceImpl.processPayment() is called.");
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void informAboutPayment() {
        System.out.println("Money was transferred");
    }

}
