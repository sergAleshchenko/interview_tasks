package enum_demo;

public class Runner {
    public static void main(String[] args) {
        MusicType musicType = MusicType.CLASSIC;

        musicType.info();

        MusicType rock = MusicType.valueOf("ROCK");

        System.out.println(musicType.compareTo(rock));
    }
}
