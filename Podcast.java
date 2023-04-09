import java.util.ArrayList;

// Name : Jaihunbek Mohammadullah
// Student ID : 501180612
class Podcast extends AudioContent
{
    private String host;  
    private int numSeasons; 
    ArrayList<Season> seasons; 

    int currentEp; 
    int currentSeason; 
    public static final String TYPENAME = "PODCAST"; 

    public Podcast(String title, int year, String id, String type, String audioFile, int length, String host, ArrayList<Season> seasons)
    {
        super(title, year, id, type, audioFile, length);
        this.host = host; 
        this.seasons = seasons; 
        this.numSeasons = seasons.size(); 
    }

    public String getType()
    {
        return TYPENAME; 
    }

    public void printInfo() 
    {
        super.printInfo(); 
        System.out.println("Host: " + this.getHost() + "\nSeasons: " + this.getNumSeasons()); 
    }

    public void play() 
    {
        super.play(); 
        System.out.println(); 
    }

    public void printTOC(int season)
    {
        // iterate and print the episode titles arraylist in class Season
        for (int i = 0; i < this.getEpisodeTitles(season).size(); i++)
        {
            int index = i + 1; 
            System.out.print("Episode " + index + ". ");
            System.out.println(this.getEpisodeTitles(season).get(i)); // Print this episode title
            System.out.println(); 
        }
    }

    public String getHost()
    {
        return this.host; 
    }

    public int getNumSeasons() 
    {
        return this.numSeasons; 
    }

    public void setEpisodeData(int seasonindex, int WhatEpisode)
    {   
        // here shud be 1-indexed
        this.currentSeason = seasonindex; 
        this.currentEp = WhatEpisode; 
        this.setAudioFile(this.getThisEpisodeTitle(currentSeason, currentEp) + ".\n" + this.getThisEpisodeFile(currentSeason, currentEp));
    }

    public String getThisEpisodeFile(int seasonIndex, int whatEpisode)
    {
        // return the Episode File corresponding to the Episode given inside this Season object
        return this.getEpisodeFiles(seasonIndex).get(whatEpisode - 1); 
    }

    public String getThisEpisodeTitle(int seasonIndex, int whatEpisode)
    {
        // return the Episode title corresponding to the Episode given inside this Season object
        return this.getEpisodeTitles(seasonIndex).get(whatEpisode - 1); 
    }
    public int getThisEpisodeLength(int seasonIndex, int whatEpisode)
    {
        // return the Episode Length corresponding to the Episode given inside this Season object
        return this.getEpisodeLengths(seasonIndex).get(whatEpisode - 1); 
    }

    public ArrayList<String> getEpisodeFiles(int seasonIndex)
    {
        // returns the array list containing the episode files in Seasons object
        return this.seasons.get(seasonIndex - 1).episodeFiles; 
    }

    public ArrayList<String> getEpisodeTitles(int seasonIndex)
    {
        return this.seasons.get(seasonIndex - 1).episodeTitles; 
    }

    public ArrayList<Integer> getEpisodeLengths(int seasonIndex)
    {
        return this.seasons.get(seasonIndex - 1).episodeLengths; 
    }

    public boolean hasSeason(int season)
    {   
        return !(season < 1 || season > seasons.size());
    }

}