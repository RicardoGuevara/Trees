/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author ESTU-5K
 */
public class BiNode<C> extends Node{
    
    protected BiNode    left,
                        right,
                        root;

    public BiNode(BiNode root, Object content) {
        super(content);
        this.root = root;
        this.init();
    }

    public BiNode(Object content) {
        super(content);
    }

    public BiNode() {
    }
    
//METHODS_______________________________________________________________________
    
    private void init()
    {
        try 
        {
            this.setAbsolute_level(root.getAbsolute_level()+1);
            root.locate(this);
        }
        catch (NullPointerException npe) //el nodo es el root general 
        {
            this.setAbsolute_level(0);
        }
    }
    
    private void locate(BiNode node)
    {
    
    }
    
}
