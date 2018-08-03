/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.util.ArrayList;

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
        this(null, content);
    }

    public BiNode() {
    }
    
//METHODS_______________________________________________________________________
    
    @Override
    public String toString()
    {
        return this.getContent().toString();
    }
    
    /**
     * verifica e inicia parámetros en el noSdo
     */
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
    
    /**
     * añade un elemento al arbol
     * @param ob 
     */
    public void add(C ob)
    {
        new BiNode(this,ob);
    }
    
    public void add(int ob)
    {
        new BiNode(this,ob);
    }
    
    public void add(float ob)
    {
        new BiNode(this,ob);
    }
    
    public void add(byte ob)
    {
        new BiNode(this,ob);
    }
    
    public void add(BiNode node)
    {
        this.locate(node);
    }
    
    /**
     * ubica de forma ordenada un elemento en el arbol
     * @param node 
     */
    private void locate(BiNode node)
    {
        switch((this.getContent()).compareTo(node.getContent()))
        {
            case -1:
                if (this.getLeft()==null) 
                {
                    node.setLeft(node);
                }
                else
                {
                    this.getLeft().locate(node);
                }
                break;
            case 1:
                if (this.getRight()==null) 
                {
                    node.setRight(node);
                }
                else
                {
                    this.getRight().locate(node);
                }
                break;
            default:
                //case 0, elemento descartado
                break;
        }
        //avl();
    }
    
    /**
     * imprime los elementos del árbol en preorden
     */
    public void preOrden()
    {
        System.out.println(this.getContent());
        if (this.getLeft()!=null) 
        {
            this.getLeft().preOrden();
        }
        if (this.getRight()!=null) 
        {
            this.getLeft().preOrden();
        }
    }
    
    /**
     * imprime los elementos del árbol en inorden
     */
    public void inOrden()
    {
        if (this.getLeft()!=null) 
        {
            this.getLeft().inOrden();
        }
        System.out.println(this.getContent());
        
        if (this.getRight()!=null) 
        {
            this.getLeft().inOrden();
        }
    }
    
    /**
     * imprime los elementos del árbol en posorden
     */
    public void posOrden()
    {
        if (this.getLeft()!=null) 
        {
            this.getLeft().posOrden();
        }
        if (this.getRight()!=null) 
        {
            this.getLeft().posOrden();
        }
        System.out.println(this.getContent());
    }
    
    /**
     * imprime  los elementos del árbol por  niveles
     */
    public void perLevels()
    {
        ArrayList<BiNode> array = new ArrayList<>();
        array.add(this);
        
        while(!array.isEmpty())
        {
            System.out.println(array.get(0));
            if (array.get(0).getLeft()!=null) 
            {
                array.add(array.get(0).getLeft());
            }
            if (array.get(0).getRight()!=null) 
            {
                array.add(array.get(0).getRight());
            }
            array.remove(0);
        }
    }    
    
    private void avl()
    {
        
    }
    
    private void doubleRightRotation()
    {
    
    }
    
    private void doubleLeftRotation()
    {
    
    }
    
    private void simpleRightRotation()
    {
    
    }
    
    private void simpleLeftRotation()
    {
    
    }
    
 //GETTERS & SETTERS____________________________________________________________   

    public BiNode getLeft() {
        return left;
    }

    public void setLeft(BiNode left) {
        this.left = left;
    }

    public BiNode getRight() {
        return right;
    }

    public void setRight(BiNode right) {
        this.right = right;
    }

    public BiNode getRoot() {
        return root;
    }

    public void setRoot(BiNode root) {
        this.root = root;
    }
    
    
}
