/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author ESTU-5K
 * @param <C>
 */
public class Node<C> {
    //
    protected C content;            //node's content <generic class>
    protected int absolute_level;   //level of one Node relative to the top-root

    public Node(C content) {
        this.content = content;
    }

    public Node() {
    }
    
    
}
