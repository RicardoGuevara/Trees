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

    //busca r tio, hermano, 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {    
        BiNode<String> root = new BiNode<>(null,"a");
        BiNode<String> b = new BiNode<>(root,"b");
        BiNode<String> c = new BiNode<>(root,"c");
        BiNode<String> d = new BiNode<>(root,"d");
        BiNode<String> e = new BiNode<>(root,"e");
        BiNode<String> f = new BiNode<>(root,"f");
        BiNode<String> g = new BiNode<>(root,"g");
        BiNode<String> h = new BiNode<>(root,"h");
        BiNode<String> i = new BiNode<>(root,"i");
        
        System.out.println("preorden:\n");
        root.preOrden();
        System.out.println("inorden:\n");
        root.inOrden();
        System.out.println("posorden:\n");
        root.posOrden();
        System.out.println("niveles::\n");
        root.perLevels();
        
    }
    
}
