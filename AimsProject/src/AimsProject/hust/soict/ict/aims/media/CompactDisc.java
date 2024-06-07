package AimsProject.hust.soict.ict.aims.media;

import AimsProject.hust.soict.ict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public List<String> getTracksName() {
		List<String> tracksName = new ArrayList<String>();
		for (int i=0;i<tracks.size();i++){
			tracksName.add(tracks.get(i).getTitle());
		}
 		return tracksName;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public String getArtist() {
		return artist;
	}
	public CompactDisc (int id, String title, String category, float cost, String director, String artist, List<Track> tracks){
		super(id, title, category, cost, director );
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc (int id, String title, String category, float cost, String director, List<Track> tracks){
		super(id, title, category, cost, director );
		this.tracks = tracks;
	}
	public CompactDisc (int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, director );
		this.artist = artist;
	}
	public CompactDisc (int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public CompactDisc() {
        super();
    }
	public void addTrack(Track track) {
		if(!tracks.contains(track)){
            tracks.add(track);
        }
        else{
            System.out.println("The track is already in the list");
        }
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)){
            tracks.remove(track);
        }
        else{
            System.out.println("The track is not in the list");
        }
	}
	
	@Override
	public int getLength() {
		int totalLength = 0;
        for(int i = 0; i < tracks.size(); i++){
            totalLength += tracks.get(i).getLength();
        }
        return totalLength;
	}

	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0){
			Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()){
				nextTrack = (Track) iter.next();
				try{
					nextTrack.play();
				}
				catch (PlayerException e){
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}

	public String toString() {
        return "CD: " + super.toString() + " - " + getArtist() + " - " + getTracksName();
    }
}
