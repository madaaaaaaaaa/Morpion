package GameMVC;

import gameObjects.Cell;
import gameObjects.ParentCell;
import gameObjects.ChangeCell;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import util.Coordinates;
import util.Mark;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GameController implements PropertyChangeListener {

    private GameModel gModel;

    @FXML
    private GridPane bigGrid;

    private Coordinates playableCellCor = new Coordinates(1, 1);
    private Coordinates clickedOnBigCell = new Coordinates();


    public void initialize() throws FileNotFoundException {
        gModel = new GameModel();
        gModel.initializeRandomTurn();
        paintPlayable();
    }

    public void paintPlayable(){
        if(playableCellCor.getColumn() != -1 && playableCellCor.getColumn() != -1) {
            int index = (playableCellCor.getRow() * 3) + (playableCellCor.getColumn());
            GridPane gp = (GridPane) bigGrid.getChildren().get(index);
            gp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else{
            for(int index = 0; index < 9; index++){
                GridPane gp = (GridPane) bigGrid.getChildren().get(index);
                if(gModel.getRootCell().getChildCells().get(index).getMark() == Mark.EMPTY)
                    gp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }

    public void paintMediumCells(){
        for (int i = 0; i < 9; i++) {
            GridPane gp = (GridPane) bigGrid.getChildren().get(i);
            ParentCell pp = (ParentCell) gModel.getRootCell().getChild((i % 3), (i / 3));

            if (pp.getMark() == Mark.EMPTY) {
                if (i % 2 == 0)
                    gp.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
                else
                    gp.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            } else {
                if (pp.getMark() == Mark.CIRCLE)
                    gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                else
                    gp.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
    }

    public void paintSymbols() throws FileNotFoundException {
        for (int i = 0; i < 9; i++) {
            GridPane med = (GridPane) bigGrid.getChildren().get(i);

            for (int j = 0; j < 9; j++) {
                ImageView imgV = (ImageView) med.getChildren().get(j);
                ParentCell pp = (ParentCell) gModel.getRootCell().getChild((i % 3), (i / 3));
                Image image;

                switch (pp.getChild((j % 3), (j / 3)).getMark()) {

                    case CIRCLE:
                        image = new Image(new FileInputStream("src/main/resources/circle.png"));
                        imgV.setImage(image);

                        break;

                    case CROSS:
                        image = new Image(new FileInputStream("src/main/resources/cross.png"));
                        imgV.setImage(image);
                        break;

                    case EMPTY:
                        break;
                }
            }
        }
    }

    @FXML
    public void onBouton() throws FileNotFoundException {
        paintSymbols();
    }

    public ChangeCell getChangeFromClick(MouseEvent e){

        ChangeCell res = new ChangeCell();

        Node source = (Node)e.getSource() ;

        Parent parent = source.getParent();
        Integer colIndex = GridPane.getColumnIndex(parent);
        Integer rowIndex = GridPane.getRowIndex(parent);

        res.setMediumCellCoordinates(new Coordinates(rowIndex,colIndex));


        ParentCell pp = (ParentCell) gModel.getRootCell().getChild(rowIndex, colIndex);

        colIndex = GridPane.getColumnIndex(source);
        rowIndex = GridPane.getRowIndex(source);

        res.setLeafCellCoordinates(new Coordinates(rowIndex, colIndex));

        res.setMark(this.gModel.getTurn());

        return res;
    }

    @FXML
    public void clickOnCellSmall(MouseEvent e) throws FileNotFoundException {


        ChangeCell cc = getChangeFromClick(e);
        System.out.println(cc);

        clickedOnBigCell = cc.getMediumCellCoordinates();

        if(clickedOnBigCell.equals(playableCellCor) || ((playableCellCor.getColumn() == -1) &&
                gModel.getRootCell().getChild(cc.getMediumCellCoordinates()).getMark() == Mark.EMPTY)) {

            ParentCell pp = (ParentCell) gModel.getRootCell().getChild(cc.getMediumCellCoordinates());


            switch(gModel.getTurn()){
                case CIRCLE:
                    pp.getChild(cc.getLeafCellCoordinates()).setMark(Mark.CIRCLE);
                    gModel.setTurn(Mark.CROSS);
                    break;
                case CROSS:
                    pp.getChild(cc.getLeafCellCoordinates()).setMark(Mark.CROSS);
                    gModel.setTurn(Mark.CIRCLE);
                    break;
            }
            if(gModel.getRootCell().getChild(cc.getMediumCellCoordinates()).getMark() == Mark.EMPTY) {
                playableCellCor = cc.getLeafCellCoordinates();
            }
            else{
                playableCellCor.setRow(-1);
                playableCellCor.setColumn(-1);
            }
        }
        else{
            System.out.println("Tu ne peux pas jouer ici petit déficient mental");
        }
        this.paintSymbols();
        this.paintMediumCells();
        this.paintPlayable();
        for(Cell p: gModel.getRootCell().getChildCells()){
            gModel.getChainOfResponsibility().detect((ParentCell) p);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
