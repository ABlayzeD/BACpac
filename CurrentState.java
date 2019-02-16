/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACpac;

/**
 *
 * @author adupr29
 */
public abstract class CurrentState {
        public CurrentState(){
                
        }
        public abstract void handleUpdate();
        public abstract void displayPage();
    
}
