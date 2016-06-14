/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.awt.Container;
/**
 *
 * @author Marzena
 */
public class ViewSwitcher {
    public Container mainContainer = null;
    public String containerName = "";
    public Container card = null;
    public String cardName = "";
    
    public ViewSwitcher() {}
    
    public ViewSwitcher( Container _mainContainer, String _containerName ) {
        mainContainer = _mainContainer;
        containerName = _containerName;
    }
    
    public ViewSwitcher( Container _mainContainer, String _containerName, Container _card, String _cardName ) {
        mainContainer = _mainContainer;
        containerName = _containerName;
        card = _card;
        cardName = _cardName;
    }
}
