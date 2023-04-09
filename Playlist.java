import java.util.ArrayList;

/*
 * A Playlist contains an array list of AudioContent (i.e. Song, AudioBooks, Podcasts) from the library
 */
// Name : Jaihunbek Mohammadullah
// Student ID : 501180612
public class Playlist
{
	private String title;
	private ArrayList<AudioContent> contents; // songs, books, or podcasts or even mixture
	
	public Playlist(String title)
	{
		this.title = title;
		contents = new ArrayList<AudioContent>();
	}
	
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void addContent(AudioContent content)
	{
		contents.add(content);
	}
	
	public ArrayList<AudioContent> getContent()
	{
		return contents;
	}

	public void setContent(ArrayList<AudioContent> contents)
	{
		this.contents = contents;
	}
	
	/*
	 * Print the information of each audio content object (song, audiobook, podcast)
	 * in the contents array list. Print the index of the audio content object first
	 * followed by ". " then make use of the printInfo() method of each audio content object
	 * Make sure the index starts at 1
	 */
	public void printContents()
	{
		// Iterate through Arraylist contents and print the index as well as the info for each AudioContent object 
		for (int i = 0; i < contents.size(); i++)
		{
			System.out.print(i+1 + ". ");
			contents.get(i).printInfo();
			System.out.println();
		}
	}

	// Play all the AudioContent in the contents list
	public void playAll()
	{
		System.out.println(this.getTitle());
		// Iterate through the ArrayList contents and play each AudioContent object 
		for (int i = 0; i < contents.size(); i++)
		{
			contents.get(i).play();
		}
	}
	
	// Play the specific AudioContent from the contents array list.
	// First make sure the index is in the correct range. 
	public void play(int index)
	{	
		// Check if the index is valid, 
		if (contains(index)) 
		{
			// then play the AudioContent object at that index in the ArrayList contents 
			contents.get(index - 1).play();
		}
	}
	
	public boolean contains(int index)
	{
		return index >= 1 && index <= contents.size();
	}
	
	// Two Playlists are equal if their titles are equal
	public boolean equals(Object other)
	{
		Playlist othPlaylist = (Playlist) other; 
		return this.getTitle().equals(othPlaylist.getTitle()); 
	}
	
	// Given an index of an audio content object in contents array list,
	// remove the audio content object from the array list
	// Hint: use the contains() method above to check if the index is valid
	// The given index is 1-indexed so convert to 0-indexing before removing
	public void deleteContent(int index)
	{
		if (!contains(index)) return;
		contents.remove(index-1);
	}
	
	// Self made helper method to get the index of a song from a playlist given the title 
	// I use this function in Library class in order to deleteSong both form Library and ALL the playlists in which it might be 
	// @returns the 0-index of the song in the playlist
	// if not found it returns -1 
	public int findSongInPlaylist(String title) 
	{
		for (int i = 0; i < contents.size(); i++)
		{
			if (contents.get(i).getTitle().equals(title)) 
			{
				return i; 
			}
		}

		return -1; 
	}
	
}
