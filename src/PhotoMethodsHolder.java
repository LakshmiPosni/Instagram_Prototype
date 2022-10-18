import java.util.ArrayList;

public class PhotoMethodsHolder {
	protected String name;
	protected ArrayList<Photos> photos;

	// Constructor 
	public PhotoMethodsHolder(String name) {
		this.name = name;
		this.photos = new ArrayList<>();
	}

	// Getters 
	public String getName() {
		return this.name;
	}

	public ArrayList<Photos> getPhotos() {
		return this.photos;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	//adds a new photo
	public boolean addPhoto(Photos p) {
		if (p == null) {
			return false;
		}
		for (Photos photograph : photos) {
			if (photograph.equals(p)) {
				return false;
			}
		}
		this.photos.add(p);
		return true;
	}

	//checks whether photo already exists
	public boolean hasPhoto(Photos p) {
		for (Photos photograph : photos) {
			if (photograph.equals(p)) {
				return true;
			}
		}
		return false;
	}

	//removes an existing photo
	public boolean removePhoto(Photos p) {
		for (Photos photograph : photos) {
			if (photograph.equals(p)) {
				this.photos.remove(p);
				return true;
			}
		}
		return false;
	}

	//calculates total number of photos in array
	public int numPhotos() {
		return this.photos.size();
	}

	
	//collects all the photos in a given year
	public ArrayList<Photos> getPhotosInYear(int year) {
		ArrayList<Photos> out = new ArrayList<Photos>();

		for (int i = 0; i < photos.size(); i++) {
			if (year >= 0001 && year <= 9999) {
				if (DateLibrary.getYear(this.photos.get(i).getDateTaken()) == year) {
					out.add(this.photos.get(i));
				} else {

				}

			} else {
				return null;
			}

		}
		return out;
	}

	//collects all the photos is a given month and year 
	public ArrayList<Photos> getPhotosInMonth(int month, int year) {
		ArrayList<Photos> out = new ArrayList<Photos>();

		for (int i = 0; i < photos.size(); i++) {
			if (year >= 0001 && year <= 9999) {
				if (month >= 01 && month <= 12) {
					if (DateLibrary.getYear(this.photos.get(i).getDateTaken()) == year) {
						if (DateLibrary.getMonth(this.photos.get(i).getDateTaken()) == month) {
							out.add(this.photos.get(i));
						} else {

						}
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return out;
	}

	
}