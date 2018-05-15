package com.ajsg2.minimaljava.common.ast;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javassist.CtClass;

public class Node {

	private final NodeType nodeId;
	private CtClass type;
	private Object auxData;
	private List<Node> children;
	private StringBuilder sb = new StringBuilder();

	public Node(NodeType nodeId, CtClass type, Object auxData, List<Node> children) {
		this.nodeId = nodeId;
		this.type = type;
		this.auxData = auxData;
		if (children == null) {
			this.children = new LinkedList<>();
		} else {
			this.children = children;
		}
	}

	public Node(NodeType nodeId, Object auxData, List<Node> children) {
		this(nodeId, null, auxData, children);
	}

	public Node(NodeType nodeId, Object auxData, Node child) {
		this(nodeId, null, auxData, new LinkedList<>(Collections.singletonList(child)));
	}


	public Node(NodeType nodeId, Object auxData) {
		this(nodeId, null, auxData, new LinkedList<>());
	}

	public Node(NodeType nodeId, List<Node> children) {
		this(nodeId, null, null, children);
	}

	public Node(NodeType nodeId) {
		this(nodeId, null, null, null);
	}

	public Node(NodeType nodeId, Node child) {
		this(nodeId, null, null, new LinkedList<>(Collections.singletonList(child)));
	}

	public String prettyPrint() {
		if (sb.length() == 0) {
			// Node is changed, we need to rebuild the string
			sb.append("( id: ")
					.append(nodeId);

			if (type != null) {
				sb.append(", type: ").append(type);
			}
			if (auxData != null) {
				sb.append(", data: ").append(auxData.toString());
			}

			if (children.size() > 0) {
				sb.append("\n\tchildren:\n");

				for (Node child : children) {
					// Indent each child by one
					if (child != null) {
						sb.append(child.prettyPrint().replaceAll("(?m)^", "\t")).append("\n");
					} else {
						sb.append("\t[null]\n");
					}
				}
			}
			sb.append(")");
		}

		return sb.toString();
	}

	public NodeType getNodeId() {
		return nodeId;
	}

	public CtClass getType() {
		return type;
	}

	// Empty the stringbuilder if we change this node
	public void setType(CtClass type) {
		if (this.type == null || !this.type.equals(type)) {
			sb.setLength(0);
			this.type = type;
		}
	}

	// Assume the node is changed soon after here
	// Not always safe, but I won't store references to the children
	public List<Node> getChildren() {
		sb.setLength(0);
		return children;
	}

	public Object getData() {
		return auxData;
	}

	public void setData(Object data) {
		this.auxData = data;
	}
}
