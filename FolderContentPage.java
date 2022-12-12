import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FolderContentPage extends VBox {
	public FolderContentPage(Folder folder){
		traverseFolders(folder, "");
	}
	
	public void traverseFolders(Folder folder, String space) {
		if(folder instanceof CompositeFolder) {
			
			CompositeFolder folderr = (CompositeFolder) folder;
			Text text = new Text(space + folderr.getName() + " (" + folderr.getSize()+")");
			super.getChildren().add(text);
			if(folderr.getFolders().isEmpty()) return;
			
				
			for(int i = 0; folderr.getFolders().size() > i; ++i) {
				traverseFolders(folderr.getFolders().get(i), space + "    ");

				}
			}
		else {
			Text text = new Text(space +"- "+folder.getName() + "."+((File)folder).getExtension()+" (" + folder.getSize()+")");
			super.getChildren().add(text);
		}
		
		}
}
