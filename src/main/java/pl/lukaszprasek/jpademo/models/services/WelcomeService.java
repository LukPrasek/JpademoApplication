package pl.lukaszprasek.jpademo.models.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)//zasieg w jednej sesji
public class WelcomeService {
    private String name;

    public String generateWelcomeString(){
        if (name==null){
            throw new IllegalStateException();
        }
        return "Witaj, "+getName();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
