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
public class BiNode <T>{

    @Override
    public String toString()
    {
        return "Node _ Bi //"+ this.hashCode()+" // "+this.getContent();
    }
    
    public BiNode(T content, BiNode izq, BiNode der, BiNode father) 
    {
        this.content = content;
        this.izq = izq;
        this.der = der;
        this.father = father;
        this.setLevel(father.getLevel() + 1);
    }

    public BiNode(BiNode father) 
    {
        this.father = father;
        this.setLevel(father.getLevel() + 1);
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

//METHODS_______________________________________________________________________
    
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
            recursivePreOrden(node.getIzq());
            System.out.println(node);
            recursivePreOrden(node.getDer());
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
            recursivePreOrden(node.getIzq());
            recursivePreOrden(node.getDer());
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
            pila.add(temp.getIzq());
            pila.add(temp.getDer());
        }
        
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

    public void setFather(BiNode father) {
        this.father = father;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

//ATRIBUTES_____________________________________________________________________    
    
    private int level=0;
    private T content;
    private BiNode izq;
    private BiNode der;
    private BiNode father;
}
