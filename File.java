
public class File extends Folder {
	private String extension;
	
	public File(String name, String size, String extension) {
		super(name, size);
		this.extension = extension;
	}
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}
