package GameMVC;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import util.Coordinates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class GameController {
    @FXML
    private GridPane bigGrid;

    private boolean turn = false;

    private Coordinates playableCellCor = new Coordinates(1,1);
    private Coordinates clickedOnBigCell = new Coordinates();

    @FXML
    public void clickOnCellSmall(MouseEvent e) throws FileNotFoundException {

        Rectangle R = new Rectangle(150,150, Color.AQUA);

        System.out.println("Begin");
        Node source = (Node)e.getSource() ;

        Parent parent = source.getParent();

        Integer colIndex = GridPane.getColumnIndex(parent);
        Integer rowIndex = GridPane.getRowIndex(parent);
        clickedOnBigCell.setColumn(colIndex);
        clickedOnBigCell.setRow(rowIndex);
        System.out.printf("Mouse clicked cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
        if(clickedOnBigCell.equals(playableCellCor)) {

            colIndex = GridPane.getColumnIndex(source);
            rowIndex = GridPane.getRowIndex(source);
            System.out.printf("Mouse clicked subcell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
            Image image;

            if (!turn) {
                image = new Image(new FileInputStream("src/main/resources/circle.png"));
            } else {
                image = new Image(new FileInputStream("src/main/resources/cross.png"));
            }
            turn = !turn;
            ImageView imgV = (ImageView) source;
            imgV.setImage(image);
            playableCellCor.setRow(rowIndex);
            playableCellCor.setColumn(colIndex);

            GridPane grandpa = (GridPane)parent.getParent();
        }
        else{
            System.out.println("Tu ne peux pas jouer ici petit déficient mental");
        }
    }

}
