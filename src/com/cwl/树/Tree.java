package com.cwl.树;

import java.util.List;

public class Tree
{
    private  Tree left;
    private  Tree right;
    private  Tree root;

    private Object data;
    public List<Tree> datas;

    public Tree(Tree left, Tree right, Object data)
    {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Tree(Object data)
    {
        this(null,null,data);
    }

    public Tree()
    {

    }



}
