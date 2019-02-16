/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacpac;

import java.awt.Image;
/**
 *
 * @author adupr29
 */
public abstract class DrinkButton {
    protected double AlcoholContent, volume;
    protected Image boozePicture;
    protected String category;
    protected abstract double consume();
    
}
