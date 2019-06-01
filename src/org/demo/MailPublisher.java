
package org.demo;

public interface MailPublisher {

    void add(MailType mailType, Observer observer);

    void notify(MailType mailType);

    void del(MailType mailType, Observer observer);
}
