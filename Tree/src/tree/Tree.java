/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author rpayan
 */

import nodes.*;

public class Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {    
        //root node
        BiNode<String> node = new BiNode("root");
        
        BiNode<String> node11 = new BiNode("izq",node);
        BiNode<String> node12 = new BiNode("der",node);
        
        BiNode<String> node21 = new BiNode("izqizq",node11);
        BiNode<String> node22 = new BiNode("izqder",node11);
        
        BiNode<String> nod23 = new BiNode("derizq",node12);
        BiNode<String> nod24 = new BiNode("derder",node12);
        
        System.out.println("altura: " +node.getHeigth()+"\n");
        System.out.println("inorden_____________________________________________");
        node.inOrden();
        System.out.println("preorden_____________________________________________");
        node.preOrden();
        System.out.println("posorden_____________________________________________");
        node.posOrden();
        System.out.println("perlevels_____________________________________________");
        node.perLevels();

    }
    
}
