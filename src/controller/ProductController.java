package controller;

import javafx.fxml.Initializable;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Cart;
import model.Product;

public class ProductController implements Initializable {
    @FXML private ImageView productImage;
    @FXML private Label productTitleLabel;
    @FXML private Label productArtistLabel;
    @FXML private Label productTypeLabel;
    @FXML private Label productGenreLabel;
    @FXML private Label productPriceLabel;
    @FXML private Button addToCartButton;
    @FXML private Button productDetailsButton;

    private Product product;
    private StoreController fatherController;


    public ProductController() {
    }

    /**
     * Metodo che setta il controller padre per poterne utilizzare i metodi.
     * @param controller controller padre.
     */
    public void setFatherController(StoreController controller){
        this.fatherController = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productDetailsButton.setOnAction(event -> {
            try {
                fatherController.setDetails(this.product);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Metodo setta i valori della scheda di ogni prodotto.
     * @param product istanza di un prodotto.
     */
    public void setProduct(Product product) throws MalformedURLException {
        this.product = product;
        productTitleLabel.setText(product.getTitle());
        File im = new File("data/products/img/" + product.getImg());
        productImage.setImage(new Image(im.toURI().toURL().toExternalForm()));
        productTypeLabel.setText(product.getType());
        productGenreLabel.setText(product.getGenre());
        productArtistLabel.setText(product.getPerformer());
        productPriceLabel.setText(String.format("%.2f", product.getPrice()));
        // addToCartButton.setOnAction(event -> Cart.getInstance().addToCart(this.product, 1));
        addToCartButton.setOnAction(event -> addToCart(this.product));
    }

    /**
     * Metodo che permette di aggiungere un prodotto al carrello tramite l'apposito bottone.
     * @param product istanza di un prodotto.
     */
    private void addToCart(Product product) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText("Hai aggiunto un nuovo prodotto al carrello!");

        alert.showAndWait();
        Cart.getInstance().addToCart(product, 1);
    }
}
