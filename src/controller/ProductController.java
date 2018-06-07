package controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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


    public ProductController() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setProduct(Product product) {
        this.product = product;
        productTitleLabel.setText(product.getTitle());
    }
}