package org.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class MailListener implements MailPublisher {

    private Map<MailType, Set<Observer>> observers = new HashMap<>();

    @Override
    public void add(MailType mailType, Observer observer) {
        Set<Observer> observers_;
        if (!observers.containsKey(mailType)) {
            observers_ = new HashSet<>();
            observers.put(mailType, observers_);
        } else {
            observers_ = observers.get(mailType);
        }
        observers_.add(observer);
    }


    @Override
    public void notify(MailType mailType) {
        if (observers.containsKey(mailType)) {
            observers.get(mailType).forEach(new Consumer<Observer>() {
                @Override
                public void accept(Observer o) {
                    o.react(mailType, this);
                }
            });
        }

    }

    @Override
    public void del(MailType mailType, Observer observer) {
        if (observers.containsKey(mailType)) {
            observers.get(mailType).remove(observer);

        }
    }
}
