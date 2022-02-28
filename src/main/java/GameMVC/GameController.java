package GameMVC;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class GameController {
    @FXML
    private GridPane bigGrid;

    @FXML
    public void clickOnCellBig(MouseEvent e){
        Node source = (Node)e.getSource() ;
        System.out.println(source);
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());

    }

    @FXML
    public void clickOnCellSmall(MouseEvent e) throws FileNotFoundException {
        Node source = (Node)e.getSource() ;
        System.out.println(source);


        Image image = new Image(new FileInputStream("src/main/resources/circle.png"));


        ImageView imgV = (ImageView) source;
        imgV.setImage(image);

    }

}
