package priv.rdo.sdawwa5.task05;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task05Controller {

    private final ApplicationContext applicationContext;
    private final NotManagedBySpring notManagedBySpring;
    private final String kota;

    public Task05Controller(ApplicationContext applicationContext,
                            @Qualifier("notManagedBySpring") NotManagedBySpring strangeBean,
                            @Qualifier("alaMaKota") String kota) {
        this.applicationContext = applicationContext;
        this.notManagedBySpring = strangeBean;
        this.kota = kota;
    }

    @GetMapping("task05")
    NotManagedBySpring bla() {
        return notManagedBySpring;
    }

    @GetMapping("task05kota")
    String kota() {
        return kota;
    }
}
