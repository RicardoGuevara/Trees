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
public class NaNode <T>{

    @Override
    public boolean equals(Object object)
    {
        if(this == object)
        {
            return true;
        }
        else if(object instanceof NaNode)
        {
            return  (((NaNode)object).getLevel() == this.getLevel()) 
                    && ((NaNode)object).getSons().size() == this.getSons().size()
                    && ((NaNode)object).getContent().equals(this.getContent());
        }
        else
        {
            return false;
        }
    }
    
    public String toString()
    {
        return "Node _ Na //"+this.hashCode() +" // "+this.getContent();
    }
    
    public NaNode() 
    {
        sons = new ArrayList<NaNode>();
    }
    
    public NaNode(NaNode father, T content) 
    {
        sons = new ArrayList<NaNode>();
        this.father = father;
        this.content = content;
        this.level = this.getFather().getLevel() + 1;
    }

    public NaNode(T content) 
    {
        sons = new ArrayList<NaNode>();
        this.content = content;
    }

    public NaNode(NaNode father) 
    {
        sons = new ArrayList<NaNode>();
        this.father = father;
        this.level = this.getFather().getLevel() + 1;
    }

    public NaNode(ArrayList<NaNode> sons) 
    {
        this.sons = sons;
    }
    
    public NaNode(ArrayList<NaNode> sons, NaNode father, T content) 
    {
        sons = new ArrayList<NaNode>();
        this.sons = sons;
        this.father = father;
        this.content = content;
        this.level = this.getFather().getLevel() + 1;
    }

//METHODS_______________________________________________________________________

    public int getWe()
    {
        recursiveWe(this);
    }
    
    private int recursiveWe(NaNode nn)
    {
        if(nn == null)
        {
            return 0;
        }
        else
        {
            int total=0;
            ArrayList<NaNode> temp = nn.getSons();
            
            for (NaNode son : temp) 
            {
                // fault
            }
        }
    }
    
    /**
     * add a new son on this node
     * @param son _ new son
     */
    public void addSon(NaNode son)
    {
        son.setFather(this);
        this.sons.add(son);
    }
    
    /**
     * create and add a new son on this node
     * @param content _ the content of the new son
     */
    public void addSon(T content)
    {
        this.sons.add(new NaNode(this,content));
    }
    
    /**
     * delete all the nodes wich contents the parameter
     * @param content 
     */
    public void delSon(T content)
    {
        for (NaNode son : sons) 
        {
            if(son.getContent().equals(content))
            {
                recursiveDel(son);
            }
            else
            {
                son.delSon(content);
            }
        }
    }
    
    /**
     * deletes this model
     */
    public void del()
    {
        recursiveDel(this);
    }
            
    private void recursiveDel(NaNode node)
    {}
    
//GETTERS & SETTERS_____________________________________________________________

    public ArrayList<NaNode> getSons() {
        return sons;
    }

    public void setSons(ArrayList<NaNode> sons) {
        this.sons = sons;
    }

    public NaNode getFather() {
        return father;
    }

    public void setFather(NaNode father) {
        this.father = father;
        this.level = this.getFather().getLevel() + 1;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
//ATRIBUTES_____________________________________________________________________
    
    private ArrayList<NaNode> sons;
    private NaNode father;
    private T content;
    private int level=0;
}
