package org.demo;

public class ObserverDemo {

    public static void main(String[] args) {

        Observer observer1 = new ObserverImpl();
        Observer observer2 = new ObserverImpl();
        MailType mailType = new MailType("mailType1");

        MailPublisher mailListener = new MailListener();

        mailListener.notify(mailType);

        mailListener.add(mailType, observer1);
        mailListener.add(mailType, observer2);

        mailListener.notify(mailType);
        mailListener.notify(new MailType("mailType2"));

        mailListener.del(mailType, observer2);
        mailListener.notify(new MailType("mailType1"));
    }
}