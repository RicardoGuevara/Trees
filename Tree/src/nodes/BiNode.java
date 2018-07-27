/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.util.ArrayList;

/**
 *
 * @author rpayan
 */
public class BiNode <T> extends Node{

    @Override
    public String toString()
    {
        return "Node _ Bi //"+ this.hashCode()+" // "+this.getContent();
    }
    
    public BiNode(T content, BiNode izq, BiNode der, BiNode father, boolean orientation) 
    {
        this.content = content;
        this.izq = izq;
        this.der = der;
        this.setFather(father, orientation);
        this.setLevel(father.getLevel() + 1);
        mayLevel = level>mayLevel? level:mayLevel;
    }

    public BiNode(BiNode father, boolean orientation) 
    {
        this.setFather(father, orientation);
        this.setLevel(father.getLevel() + 1);
        mayLevel = level>mayLevel? level:mayLevel;
    }

    public BiNode(T content, BiNode father, boolean orientation) 
    {
        this.content = content;
        this.setFather(father, orientation);
        this.setLevel(father.getLevel() + 1);
        mayLevel = level>mayLevel? level:mayLevel;
    }

    public BiNode(T content) 
    {
        this.content = content;
    }

    public BiNode() {
    }

    public BiNode(BiNode izq, BiNode der) 
    {
        this.izq = izq;
        this.der = der;
    }

    public BiNode(BiNode izq, BiNode der, BiNode father, boolean orientation) {
        this.izq = izq;
        this.der = der;
        this.setFather(father, orientation);
    }
    
    
    
//METHODS_______________________________________________________________________
    
    /**
     * this is absolute useless
     * @param node
     * @param orientation 
     */
    public void add(BiNode node, boolean orientation)
    {
        node.setFather(this, orientation);
    }
    
    /**
     * recorrido pre_orden
     */
    public void preOrden()
    {
        recursivePreOrden(this);
    }
    
    /**
     * recorrido recursivo pre_orden
     * @param node 
     */
    private void recursivePreOrden(BiNode node)
    {
        if (node != null) 
        {
            System.out.println(node);
            recursivePreOrden(node.getIzq());
            recursivePreOrden(node.getDer());
        }        
    }
    
    /**
     * recorrido in_orden
     */
    public void inOrden()
    {
        recursiveInOrden(this);
    }
    
    /**
     * recorrido in_orden recursivo
     * @param node 
     */
    private void recursiveInOrden(BiNode node)
    {
        if (node != null) 
        {
            recursiveInOrden(node.getIzq());
            System.out.println(node);
            recursiveInOrden(node.getDer());
        } 
    }
    
    /**
     * recorrido pos_orden
     */
    public void posOrden()
    {
        recursivePosOrden(this);
    }
    
    /**
     * recorrido pos_orden recursivo
     * @param node 
     */
    private void recursivePosOrden(BiNode node)
    {
        if (node != null) 
        {
            recursivePosOrden(node.getIzq());
            recursivePosOrden(node.getDer());
            System.out.println(node);
        } 
    }
    
    /**
     * recorrido por niveles
     */
    public void perLevels()
    {
        ArrayList<BiNode> pila = new ArrayList<>();
        pila.add(this);
        BiNode temp;
        
        while(!pila.isEmpty())
        {
            temp = pila.get(0);
            System.out.println(temp);
            pila.remove(0);
            if (temp.getIzq() != null) 
            {
                pila.add(temp.getIzq());
            }
            if (temp.getDer() != null) 
            {
                pila.add(temp.getDer());
            }
        }
        
    }

    public int getHeigth()
    {
        return mayLevel - level;
    }
    
    
//GETTERS & SETTERS_____________________________________________________________    

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BiNode getIzq() {
        return izq;
    }

    public void setIzq(BiNode izq) {
        this.izq = izq;
    }

    public BiNode getDer() {
        return der;
    }

    public void setDer(BiNode der) {
        this.der = der;
    }

    public BiNode getFather() {
        return father;
    }

    public void setFather(BiNode father, boolean orientation) {
        if(orientation)
        {
            father.setDer(this);
        }
        else
        {
            father.setIzq(this);
        }
        this.father = father;
        this.level = father.getLevel() + 1;
        mayLevel = level>mayLevel? level:mayLevel;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

//ATRIBUTES_____________________________________________________________________    
    
    public static int mayLevel=0;
    private T content;
    private BiNode izq;
    private BiNode der;
    private BiNode father;
}
