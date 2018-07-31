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
public class BiNode<C extends Comparable> extends Node{
    
    protected BiNode    left,
                        right,
                        root;

    public BiNode(BiNode root, C content) {
        super(content);
        this.root = root;
        this.init();
    }

    public BiNode(C content) {
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
        switch((this.getContent()).compareTo(node.getContent()))
        {
            case -1:
                //recursivo izquierda
                break;
            case 1:
                //recursivo derecha
                break;
            default:
                //elemento descartado
                break;
        }
    }
    
}
