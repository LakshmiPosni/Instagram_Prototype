import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Photos {
	private final String caption;
	private final String filename;
	private int rating;
	private final String datePosted;
	protected BufferedImage imageData;
	

	//Constructor
	public Photos(String filename, String caption, String datePosted, int rating) {
		this.filename = filename;
		this.caption = caption;

		if (rating > 5 || rating < 1) {
			this.rating = 1;
		} else {
			this.rating = rating;
		}
		
		if (DateLibrary.isValidDate(datePosted) == false) {
			this.datePosted = "1901-01-01";
		} else {
			this.datePosted = datePosted;
		}
		

	}

	// Getters
	public String getCaption() {
		return this.caption;
	}

	public String getFilename() {
		return this.filename;
	}

	public int getRating() {
		return this.rating;
	}

	public String getDateTaken() {
		return this.datePosted;
	}
	
	public BufferedImage getImageData() {
		return this.imageData;
	}
	
	// Setters 
	public void setImageData(BufferedImage imageData) {
		this.imageData = imageData;
	}

	public boolean setRating(int newRating) {
		if ((newRating != this.rating) && (newRating >= 1 && newRating <= 5)) { //rating range: 1-5
			this.rating = newRating;
			return (true);
		}
		return (false);
	}
	
	//checks if two photos are equal
	public boolean equals(Object o) {
		if (o instanceof Photos) {
			Photos other = (Photos) o;
			return (this.filename.equals(other.filename)) && (this.caption.equals(other.caption));
		}
		return (false);
	}


	//toString 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// sb.append("\n");
		sb.append("Photo: ");
		sb.append("\n\tFilename: ");
		sb.append(filename);
		sb.append("\n\tCaption: ");
		sb.append(caption);
		return (sb.toString());
	}

	//Created a hashcode to have a unique address for each photo 
	@Override
	public int hashCode() {
		return this.filename.hashCode();
	}
	
	//loads the data of the given image file
	public boolean loadImageData(String filename) {	
		boolean flag = true;
		try {
			BufferedImage img = ImageIO.read(new File(filename));
			this.imageData = img;
		} catch (IOException e) {
			flag = false;
			
		}
		return flag;

	}


}
