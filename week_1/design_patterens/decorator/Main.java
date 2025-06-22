package decorator;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));

        System.out.println("Email Only");
        emailOnly.send("Library due reminder");

        System.out.println("\nEmail + SMS");
        emailAndSMS.send("Exam schedule published");

        System.out.println("\nEmail + SMS + Slack");
        allChannels.send("System maintenance at midnight");
    }
}
