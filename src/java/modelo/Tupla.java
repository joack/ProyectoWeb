/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Joack
 */
public class Tupla 
{
    int primaryKey;
    int foreignKey;
    
    public Tupla( int pK, int fK )
    {
        this.primaryKey = pK;
        this.foreignKey = fK;
    }
    
    public int getPrimaryKey()
    {
        return primaryKey;
    }
    
    public int getForeignKey()
    {
        return foreignKey;
    }
    
    public void setForeignKey(int key)
    {
        this.foreignKey = key;
    }
}
