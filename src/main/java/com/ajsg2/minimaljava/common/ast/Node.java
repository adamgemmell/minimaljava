package com.ajsg2.minimaljava.common.ast;

import com.ajsg2.minimaljava.common.nonterminals;
import java.util.LinkedList;
import java.util.List;

public class Node {

	private final int nodeId;
	private String type;
	private Object value;
	private List<Node> children;
	private StringBuilder sb = new StringBuilder();

	public Node(int nodeId, String type, Object value, List<Node> children) {
		this.nodeId = nodeId;
		this.type = type;
		this.value = value;
		if (children == null) {
			this.children = new LinkedList<>();
		} else {
			this.children = children;
		}
	}

	public Node(int nodeId, Object value, List<Node> children) {
		this(nodeId, null, value, children);
	}

	public Node(int nodeId, Object value) {
		this(nodeId, null, value, new LinkedList<>());
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
					.append(nonterminals.nonterms[nodeId]);

			if (type != null) {
				sb.append(", type: ").append(type);
			}
			if (value != null) {
				sb.append(", value: ").append(value.toString());
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
