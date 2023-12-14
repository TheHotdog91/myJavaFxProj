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
    private ObservableList<String> documentNames = FXCollections.observableArrayList();
    @FXML
    private void initialize() {
        documentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
            Object newDocument = null;

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


    private Invoice createInvoice() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create Invoice");
        dialog.setHeaderText("Enter Invoice Details");
        dialog.setContentText("Enter Invoice Number:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            Invoice invoice = new Invoice();
            invoice.setNumber(result.get());

            // Implement logic to gather and set other Invoice attributes
            // ...

            return invoice;
        }
        return null;
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
