import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class FolderTreeView extends TreeView<Folder> {
	private Folder folderRoot;
	public FolderTreeView(Folder folderRoot) {
		this.folderRoot = folderRoot;
		TreeItem<Folder> rootItem = new TreeItem<Folder>(folderRoot);
		super.setRoot(rootItem);

		placeFoldersInTreeView(folderRoot, rootItem);
	}
	
	public void placeFoldersInTreeView(Folder folder, TreeItem<Folder> rootItem) {
		if(folder instanceof CompositeFolder) {
			CompositeFolder folderr = (CompositeFolder) folder;
			
			if(folderr.getFolders().isEmpty()) return;
				
			for(int i = 0; folderr.getFolders().size() > i; ++i) {
				if(folderr.getFolders().get(i) instanceof CompositeFolder) {
					TreeItem<Folder> treeItem = new TreeItem<Folder>(folderr.getFolders().get(i));
					rootItem.getChildren().add(treeItem);
					placeFoldersInTreeView(folderr.getFolders().get(i), treeItem);
				}
				else {
					placeFoldersInTreeView(folderr.getFolders().get(i), null);

				}
				
			}

		}
	}
}