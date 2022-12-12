import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mian extends Application{

	public static void main(String[] args) {
		launch(args);
	} 
	
	public Folder initialize() {
		CompositeFolder test = new CompositeFolder("TEST","3345 KB");	
		CompositeFolder folderA = new CompositeFolder("Folder-A","1115 KB");
		CompositeFolder folderA1 = new CompositeFolder("Sub_Folder-A-1","370 KB");
		File imageA11 = new File("image1", "90 KB", "png");
		File imageA12 = new File("image2", "210 KB", "png");
		File imageA13 = new File("image3", "70 KB", "png");
		CompositeFolder folderA2 = new CompositeFolder("Sub_Folder-A-2","745 KB");
		File imageA21 = new File("image1", "435 KB", "png");
		File imageA22 = new File("image2", "310 KB", "png");
		CompositeFolder folderB = new CompositeFolder("Folder-B","1115 KB");
		CompositeFolder folderC = new CompositeFolder("Folder-C","1115 KB");
		
		folderA1.addFolder(imageA11);
		folderA1.addFolder(imageA12);
		folderA1.addFolder(imageA13);
		
		folderA2.addFolder(imageA21);
		folderA2.addFolder(imageA22);
		
		folderA.addFolder(folderA1);
		folderA.addFolder(folderA2);
		
		folderB.addFolder(folderA1);
		folderB.addFolder(folderA2);
		
		test.addFolder(folderA);
		test.addFolder(folderB);
		test.addFolder(folderC);
		
		return test;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Folder test = initialize();
		
		Scene scene = new Scene(screen(test), 800, 500);

		arg0.setTitle("Folder Traverse");
		arg0.setScene(scene);
		arg0.show();
	}
	
	public BorderPane screen(Folder folder) {
		FolderTreeView treeView = new FolderTreeView(folder);

		BorderPane borderPane = new BorderPane();
		
        Button button = new Button("Select Folder");
        button.setOnAction(buttonAction(folder, treeView, borderPane));
        
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(20, 20, 20, 20));
		vbox.setSpacing(15);
		vbox.getChildren().add(treeView);
		vbox.getChildren().add(button);
		

		borderPane.setLeft(vbox);
		
		return borderPane;
	}
	
	public EventHandler<ActionEvent> buttonAction(Folder folder, FolderTreeView treeView, BorderPane borderPane){
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	TreeItem<Folder> selectedItem = (TreeItem<Folder>) treeView.getSelectionModel().getSelectedItem();
            	if(selectedItem == null) return;
            	
            	Folder selectedFolder = selectedItem.getValue();
            	if(selectedFolder == null) {
            		selectedFolder = folder;
            	}
      
            	FolderContentPage folderContent = new FolderContentPage(selectedFolder);
            	folderContent.setPadding(new Insets(20, 0, 20, 20));
            	folderContent.setSpacing(1);
            	
            	borderPane.setCenter(folderContent); 	
            }
        };
		return event;
	}

	
}
