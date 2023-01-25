package TreeLib;

import java.util.ArrayList;

public class treeNode<T> {

	treeNode<T> parent;
	ArrayList< treeNode<T> > children = new ArrayList< treeNode<T> >();
	T data;
	
	public treeNode(T data) {
		
		this.data = data;
		this.parent = null;
	}
	
	public treeNode(T data, treeNode<T> parent) {
		
		this.data = data;
		this.parent = parent;
	}
	
	public void addChild(T data) {
		
		treeNode<T> child = new treeNode<T>(data);
		child.parent = this;
		this.children.add(child);
	}
	
	public void addChild(treeNode<T> child) {
		
		child.parent = this;
		this.children.add(child);
	}
}
