package enum_demo;

public enum MusicType {
    ROCK("Rock"), JAZZ("Jazz"), CLASSIC;

    private String realName;

    private MusicType() {

    }

    MusicType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void info() {
        switch (this) {
            case JAZZ:
                System.out.println("this is " + realName);
                break;
            case ROCK:
                System.out.println("this is " + realName);
                break;
            case CLASSIC:
                System.out.println("this is " + realName);
                break;
            default:
                System.out.println("no that style");
        }
    }
}
