package pack;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.util.Pair;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.io.BufferedReader;
import  java.io.FileReader;
import java.time.LocalDate;

public class DocumentController {



    @FXML
    private TableColumn<Document, String> numberColumn;

    @FXML
    private TableColumn<Document, LocalDate> dateColumn;

    @FXML
    private TableColumn<Document, String> userColumn;

    @FXML
    private TableColumn<Document, Double> amountColumn;

    @FXML
    private TableColumn<Document, String> currencyColumn;

    @FXML
    private TableColumn<Document, Double> exchangeRateColumn;

    @FXML
    private TableColumn<Document, String> productColumn;

    @FXML
    private TableColumn<Document, Double> quantityColumn;

    // ... (other code)

    @FXML
    private void initialize() {
        // Configure the cell value factories for each column
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        userColumn.setCellValueFactory(cellData -> cellData.getValue().userProperty());
        //amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
        //currencyColumn.setCellValueFactory(cellData -> cellData.getValue().currencyProperty());
        //exchangeRateColumn.setCellValueFactory(cellData -> cellData.getValue().exchangeRateProperty().asObject());
        //productColumn.setCellValueFactory(cellData -> cellData.getValue().productProperty());
        //quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        // Set the items in the TableView
        documentTable.setItems(FXCollections.observableArrayList());

        // Other initialization code...
    }














































///////////////////////////////////////////////////////////////////////////////////////
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

    private List<Document> documents = new ArrayList<>();
    private ObservableList<String> documentNames = FXCollections.observableArrayList();
//    @FXML
//    private void initialize() {
//        documentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//    }

    private List<Document> getSelectedDocuments(){
        return documents;
    }
    @FXML
    private void createDocuments() {
        // Implement document creation logic and add to the list
        List<String> choices = new ArrayList<>();
        choices.add("Invoice");
        choices.add("Payment");
        choices.add("Payment Request");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Invoice", choices);
        dialog.setTitle("Document Type");
        dialog.setHeaderText("Select Document Type");
        dialog.setContentText("Choose the type of document:");

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        // Get the result of the dialog
        dialog.showAndWait().ifPresent(result -> {
            Document newDocument = null;

            // Create the selected type of document
            switch (result) {
                case "Invoice":
                    newDocument = createInvoice();
                    break;
                case "Payment":
                    newDocument = createPayment();
                    break;
                case "Payment Request":
                    newDocument = createPaymentRequest();
                    break;
            }

            // Add the new document to the list and update the table
            if (newDocument != null) {
                documents.add(newDocument);
                updateTable();
            }
        });
    }

    @FXML
    private void saveDocuments() {
        List<Document> selectedDocuments = getSelectedDocuments();

        if (!selectedDocuments.isEmpty()) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                saveDocumentsToFile(selectedDocuments, file);
            }
        }
    }

    private void saveDocumentsToFile(List<Document> documents, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Document document : documents) {
                writer.write(document.toString());
                writer.write("\n\n");
            }

            showAlert("Save Successful", "Documents saved to " + file.getAbsolutePath(), Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            showAlert("Error", "Error saving documents to file", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void loadDocuments() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            List<Document> loadedDocuments = loadDocumentsFromFile(file);
            if (!loadedDocuments.isEmpty()) {
                documents.addAll(loadedDocuments);
                updateTable();
            }
        }
    }

    private List<Document> loadDocumentsFromFile(File file) {
        List<Document> loadedDocuments = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder documentDetails = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Blank line indicates the end of a document details block
                    // Parse the details and create a document
                    Document document = createDocumentFromDetails(documentDetails.toString());
                    if (document != null) {
                        loadedDocuments.add(document);
                    }
                    documentDetails.setLength(0);  // Clear the StringBuilder for the next document
                } else {
                    documentDetails.append(line).append("\n");
                }
            }

            // Check for the last document in case the file doesn't end with a blank line
            if (documentDetails.length() > 0) {
                Document document = createDocumentFromDetails(documentDetails.toString());
                if (document != null) {
                    loadedDocuments.add(document);
                }
            }

            showAlert("Load Successful", "Documents loaded from " + file.getAbsolutePath(), Alert.AlertType.INFORMATION);
        } catch (IOException e) {
            showAlert("Error", "Error loading documents from file", Alert.AlertType.ERROR);
            e.printStackTrace();
        }

        return loadedDocuments;
    }

    private Document createDocumentFromDetails(String details) {
        // Implement logic to parse details and create a Document object
        // You need to modify this method based on the actual structure of your document details
        // For simplicity, we'll assume details contain only one document type (e.g., Invoice)
        String[] lines = details.split("\n");
        // Parse lines and create a document object
        // ...

        return null;  // Return null for now, you need to replace it with the actual document object
    }

    @FXML
    private void viewDocuments() {
        List<Document> selectedDocuments = documents;

        if (!selectedDocuments.isEmpty()) {
            showDocumentDetailsDialog(selectedDocuments);
        }
    }

    private void showDocumentDetailsDialog(List<Document> documents) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Document Details");

        VBox content = new VBox();
        content.setSpacing(10);

        StringBuilder details = new StringBuilder();

        for (Document document : documents) {
            details.append(document.toString()).append("\n\n");
        }

        TextArea textArea = new TextArea(details.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        content.getChildren().add(textArea);
        dialog.getDialogPane().setContent(content);

        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButton);

        dialog.showAndWait();
    }
    @FXML
    private void deleteSelectedDocuments() {
        // Implement logic to delete selected documents from the list and update the table
    }


    private Invoice createInvoice() {
        Dialog<Invoice> dialog = new Dialog<>();
        dialog.setTitle("Create Invoice");
        dialog.setHeaderText("Enter Invoice Details");

        ButtonType createButton = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        // Create the layout and components for the dialog
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(20, 150, 10, 10));

        TextField numberField = new TextField();
        DatePicker datepicker = new DatePicker();
        TextField userField = new TextField();
        TextField amountField = new TextField();
        TextField currencyField = new TextField();
        TextField exchangeRateField = new TextField();
        TextField productField = new TextField();
        TextField quantityField = new TextField();

        grid.add(new Label("Number:"), 0, 0);
        grid.add(numberField, 1, 0);
        grid.add(new Label("Date:"), 0, 1);
        grid.add(datepicker, 1, 1);
        grid.add(new Label("User:"), 0, 2);
        grid.add(userField, 1, 2);
        grid.add(new Label("Amount:"), 0, 3);
        grid.add(amountField, 1, 3);
        grid.add(new Label("Currency:"), 0, 4);
        grid.add(currencyField, 1, 4);
        grid.add(new Label("Exchange Rate:"), 0, 5);
        grid.add(exchangeRateField, 1, 5);
        grid.add(new Label("Product:"), 0, 6);
        grid.add(productField, 1, 6);
        grid.add(new Label("Quantity:"), 0, 7);
        grid.add(quantityField, 1, 7);

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        //?? ???????????????
        // Platform.runLater(() -> numberField.requestFocus());

        // Convert the result to a Document when the create button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                Invoice invoice = new Invoice();
                invoice.setNumber(numberField.getText());
                invoice.setDate(datepicker.getValue());
                invoice.setUser(userField.getText());
                invoice.setAmount(Double.parseDouble(amountField.getText()));
                invoice.setCurrency(currencyField.getText());
                invoice.setExchangeRate(Double.parseDouble(exchangeRateField.getText()));
                invoice.setProduct(productField.getText());
                invoice.setQuantity(Double.parseDouble(quantityField.getText()));

                return invoice;
            }
            return null;
        });

        Optional<Invoice> result = dialog.showAndWait();
        return result.orElse(null);

    }

    private Payment createPayment() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create Payment");
        dialog.setHeaderText("Enter Payment Details");
        dialog.setContentText("Enter Payment Number:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            Payment payment = new Payment();
            payment.setNumber(result.get());

            // Implement logic to gather and set other Payment attributes
            // ...

            return payment;
        }
        return null;
    }

    private PaymentRequest createPaymentRequest() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create Payment Request");
        dialog.setHeaderText("Enter Payment Request Details");
        dialog.setContentText("Enter Payment Request Number:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setNumber(result.get());

            // Implement logic to gather and set other Payment Request attributes
            // ...

            return paymentRequest;
        }
        return null;
    }

    private void updateTable() {
        // Update the table with the names of the documents
        documentNames.clear();
        for (Object document : documents) {
            documentNames.add(document.toString());
        }
    }

}
