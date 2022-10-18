
public class Albums extends PhotoMethodsHolder{
	
	//calls super to photomethodholder
	public Albums(String name) {
		super(name);

	}
	
	//checks if there are two of the same albums
	public boolean equals(Object o) {
		if (o instanceof Albums) {
			Albums other = (Albums) o;
			return (this.name.equals(other.name));
		}
		return false;
	}
	
	//toString prints album name and the photo filenames in the album 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Album Name: ");
		sb.append(name);
		sb.append("\nPhoto Filename: ");
		sb.append("\n");
		for (Photos photograph : photos) {
			sb.append(photograph);
		}
		return sb.toString();
	}


}


