package GUI;

import Entities.GameObject;
import javafx.scene.layout.Pane;

import java.util.List;

//TODO write javaDoc

/**
 * The purpose of this interface is to specify what the core program needs to provide to get a graphical representation,
 * and what input the GUI will be provided with from the core program.
 *
 * @author MaZeeT
 */
public interface IGUI {

    /**
     * A method to provide a new/update list of {@link GameObject} and redraw, to the {@link IGUI}.
     *
     * @param gameObjects The list of new/updated {@link GameObject}.
     */

    void update(List<GameObject> gameObjects);

    /**
     * A method to return the pane of the {@link IGUI}.
     *
     * @return Returns the pane.
     */
    Pane getPane();

}
