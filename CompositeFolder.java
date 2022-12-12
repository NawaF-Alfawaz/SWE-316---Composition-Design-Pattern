import java.util.ArrayList;

public class CompositeFolder extends Folder {
	private  ArrayList<Folder> folders = new ArrayList<Folder>();;
	
	public CompositeFolder(String name, String size) {
		super(name, size);
		
	}
	public void addFolder(Folder folder) {
		folders.add(folder);
	}
	public ArrayList<Folder> getFolders() {
		return folders;
	}

	public void setFolders(ArrayList<Folder> folders) {
		this.folders = folders;
	}
	
	
	public String toString() {
		return super.getName();
		
	}

}
