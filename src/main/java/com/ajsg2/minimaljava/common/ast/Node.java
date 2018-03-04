package com.ajsg2.minimaljava.common.ast;

import com.ajsg2.minimaljava.parse.NonTerms;
import java.util.LinkedList;
import java.util.List;

public class Node {

	private final int nodeId;
	private String type;
	private Object auxData;
	private List<Node> children;
	private StringBuilder sb = new StringBuilder();

	public Node(int nodeId, String type, Object auxData, List<Node> children) {
		this.nodeId = nodeId;
		this.type = type;
		this.auxData = auxData;
		if (children == null) {
			this.children = new LinkedList<>();
		} else {
			this.children = children;
		}
	}

	public Node(int nodeId, Object auxData, List<Node> children) {
		this(nodeId, null, auxData, children);
	}

	public Node(int nodeId, Object auxData) {
		this(nodeId, null, auxData, new LinkedList<>());
	}

	public Node(int nodeId, List<Node> children) {
		this(nodeId, null, null, children);
	}

	public Node(int nodeId) {
		this(nodeId, null, null, new LinkedList<>());
	}

	public String prettyPrint() {
		if (sb.length() == 0) {
			// Node is changed, we need to rebuild the string
			sb.append("( id: ")
					.append(NonTerms.ID[nodeId]);

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

	public int getNodeId() {
		return nodeId;
	}

	public String getType() {
		return type;
	}

	// Empty the stringbuilder if we change this node
	public void setType(String type) {
		if (!this.type.equals(type)) {
			sb.setLength(0);
			this.type = type;
		}
	}

	// Assume the node is changed here
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
