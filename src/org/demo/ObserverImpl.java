package org.demo;

public class ObserverImpl implements Observer {

    @Override
    public void react(MailType mailType, Object data) {
        System.out.println("MailType " + mailType + " was triggered.");
    }
}