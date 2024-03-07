import java.util.ArrayList;
import java.util.List;

// Step 1: Create the MusicPlayer interface
interface MusicPlayer {
    void play();
    void pause();
    void stop();
    void addSong(String song);
    void removeSong(String song);
}

// Step 2: Implement the MusicPlayer interface
class MyMusicPlayer implements MusicPlayer {
    private List<String> playlist;
    private boolean isPlaying;

    public MyMusicPlayer() {
        playlist = new ArrayList<>();
        isPlaying = false;
    }

    @Override
    public void play() {
        if (!playlist.isEmpty()) {
            System.out.println("Playing: " + playlist.get(0));
            isPlaying = true;
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    @Override
    public void pause() {
        if (isPlaying) {
            System.out.println("Pausing: " + playlist.get(0));
            isPlaying = false;
        } else {
            System.out.println("No song is playing.");
        }
    }

    @Override
    public void stop() {
        if (isPlaying) {
            System.out.println("Stopping: " + playlist.get(0));
            isPlaying = false;
        } else {
            System.out.println("No song is playing.");
        }
    }

    @Override
    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added: " + song + " to the playlist.");
    }

    @Override
    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed: " + song + " from the playlist.");
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }
}

// Step 3: Main class to test the program
public class Main {
    public static void main(String[] args) {
        // Create an instance of MyMusicPlayer
        MyMusicPlayer player = new MyMusicPlayer();

        // Add songs to the playlist
        player.addSong("Song 1");
        player.addSong("Song 2");
        player.addSong("Song 3");
        player.addSong("Song 4");
        player.addSong("Song 5");

        // Play a song
        player.play();

        // Pause the currently playing song
        player.pause();

        // Remove a song from the playlist
        player.removeSong("Song 3");

        // Stop the currently playing song
        player.stop();
    }
}
