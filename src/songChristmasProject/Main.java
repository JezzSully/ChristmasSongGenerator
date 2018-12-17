package songChristmasProject;

public class Main 
{
	public static void main(String[] args)
	{
		SongGen song = new SongGen();
		
		song.loadNouns();
		song.loadVerbs();
		song.loadAdjectives();
		
		String fullSong = song.generate12Days();
		
		System.out.println(fullSong);
	}
}
