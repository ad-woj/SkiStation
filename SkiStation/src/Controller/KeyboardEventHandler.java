/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import java.awt.Container;
import java.lang.ReflectiveOperationException;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import View.*;
/**
 *
 * @author Marzena
 */
public class KeyboardEventHandler implements KeyListener {
    
    static MainWindow mainWindow;
    
    public KeyboardEventHandler( MainWindow mw ){
        mainWindow = mw;
    }
    
    public void keyTyped(KeyEvent e) {
    char c = e.getKeyChar();
  }

  public void keyPressed(KeyEvent e) {
    if( e.getKeyCode() != KeyEvent.VK_ENTER )
        return;
    
    String componentName = e.getComponent().getName();
    
    switch( componentName )
    {
        case "LoginPanel":
            mainWindow.PerformLoginAction();
            break;
        case "RegisterButton":
            mainWindow.PerformRegisterAction();
            break;
        case "BackButton":
            mainWindow.PreviewView();
            break;
        case "CashierPanel":
            break;
    }    
  }

  public void keyReleased(KeyEvent e) {
    char c = e.getKeyChar();
  }
}
