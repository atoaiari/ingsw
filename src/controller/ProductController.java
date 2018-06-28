package controller;

import javafx.fxml.Initializable;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


    public void setProduct(Product product) throws MalformedURLException {
        this.product = product;
        productTitleLabel.setText(product.getTitle());
        File im = new File("data/products/img/" + product.getImg());
        productImage.setImage(new Image(im.toURI().toURL().toExternalForm()));
        productTypeLabel.setText(product.getType());
        productGenreLabel.setText(product.getGenre());
        productArtistLabel.setText(product.getPerformer());
        productPriceLabel.setText(String.valueOf(product.getPrice()));
    }
}
