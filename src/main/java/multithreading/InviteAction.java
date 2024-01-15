package multithreading;

public class InviteAction {
    private String name;

    public InviteAction(String name) {
        this.name = name;
    }

    public synchronized void invite(InviteAction obj) {
        System.out.println(name + " invites " + obj.name.toUpperCase());
        obj.action();
    }

    public synchronized void action() {
        System.out.println(name + " action");
    }
}
