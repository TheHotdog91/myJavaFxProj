package pack;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentController {

    @FXML
    private TableView<String> documentTable;

    @FXML
    private Button createButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button viewButton;

    private List<Object> documents = new ArrayList<>();

    @FXML
    private void initialize() {
        documentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void createDocument() {
        // Implement document creation logic and add to the list
    }

    @FXML
    private void saveDocuments() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                // Implement logic to write documents to the file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void loadDocuments() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            // Implement logic to read documents from the file and add to the list
        }
    }

    @FXML
    private void viewDocuments() {
        // Implement logic to display selected documents in a separate window
    }

    @FXML
    private void deleteSelectedDocuments() {
        // Implement logic to delete selected documents from the list and update the table
    }
}
