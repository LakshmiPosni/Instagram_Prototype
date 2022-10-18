import java.util.HashSet;

public class Libraries extends PhotoMethodsHolder{
	private final int id;
	private HashSet<Albums> albums; //used a hashset instead of array list to explore different data structures 
	
	//Constructor calls super and initializes new fields
	public Libraries(String name, int id) {
		super(name);
		this.id = id;
		this.albums = new HashSet<>();
	}

	//Getters
	public int getId() {
		return this.id;
	}

	public HashSet<Albums> getAlbums() {
		return this.albums;
	}

	//removes photo from photo feed
	@Override
	public boolean removePhoto(Photos p) {
		boolean Flag = false;

		for (Albums a : albums) {
			if (a.removePhoto(p)) {
				Flag = true;
			}
		}

		if (photos.remove(p)) {
			Flag = true;
		}
		return Flag;
	}

	//checks if there are two of the same libraries
	public boolean equals(Object o) {
		if (o instanceof Libraries) {
			Libraries other = (Libraries) o;
			return (this.id == other.id);
		}
		return (false);
	}

	//toString for the Library - prints name, photos, albums
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Library: ");
		sb.append("\n\tName: ");
		sb.append(name);
		sb.append("\n\tID: ");
		sb.append(id);
		sb.append("\n\tPhotos: ");
		sb.append(photos);
		sb.append("\n\tAlbum names: ");
		for (Albums a : albums) {
			sb.append(a.getName());
		}
		return (sb.toString());
	}

	//creates a new album
	public boolean createAlbum(String albumName) {
		for (Albums a : albums) {
			if (a.getName().equals(albumName)) {
				return false;
			}
		}
		Albums aName = new Albums(albumName);
		this.albums.add(aName);
		return true;
	}

	//removes an existing album
	public boolean removeAlbum(String albumName) {
		for (Albums a : albums) {
			if (a.getName().equals(albumName)) {
				Albums aName = new Albums(albumName);
				this.albums.remove(aName);
				return true;
			}
		}
		return false;
	}

	//adds photos to album
	public boolean addPhotoToAlbum(Photos p, String albumName) {
		for (int i = 0; i < this.photos.size(); i++) {
			if (this.photos.get(i).equals(p)) {
				for (Albums a : albums) {
					if (a.getName().equals(albumName)) {
						for (int j = 0; j < a.getPhotos().size(); j++) {
							if (a.getPhotos().get(j).equals(p)) {
								return false;
							}
						}
						a.getPhotos().add(p);
						return true;
					}
				}
			}
		}
		return false;
	}

	//removes photo from album
	public boolean removePhotoFromAlbum(Photos p, String albumName) {
		for (Albums a : albums) {
			if (a.getName().equals(albumName)) {
				for (Photos photograph : a.getPhotos()) {
					if (photograph.equals(p)) {
						a.getPhotos().remove(p);
						return true;
					}
				}
			}
		}
		return false;
	}

}
