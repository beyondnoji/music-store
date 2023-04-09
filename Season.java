import java.util.ArrayList; 
// Name : Jaihunbek Mohammadullah
// Student ID : 501180612
public class Season {

    ArrayList<String> episodeFiles; // this ArrayList consists of AudioFile strings
    ArrayList<String> episodeTitles; 
    ArrayList<Integer> episodeLengths; // stores episode lengths in minutes 
    
    public Season()
    {
        episodeFiles = new ArrayList<>();
        episodeTitles = new ArrayList<>(); 
        episodeLengths = new ArrayList<>(); 

    }

    public boolean hasEpisode(int episode) 
    {
        return !(episode < 1 || episode > episodeFiles.size());
    }
}