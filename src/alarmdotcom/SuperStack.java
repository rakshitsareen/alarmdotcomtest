package alarmdotcom;

import java.util.LinkedList;

class Node {
	int val;
	Node next;

	public Node() {

	}

	public Node(int number) {
		Node node = new Node();
		node.val = number;
		node.next = null;
	}
}

public class SuperStack {

	public static void superStack(String[] operations) {
		int noCommands = operations.length;

		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < noCommands; ++i) {
			String command = operations[i];
			String[] split = command.split(" ");
			if (split[0].equals("push")) {
				int number = Integer.parseInt(split[1]);
				stack.add(0, number);
			}

			else if (split[0].equals("pop") && stack.size() > 0) {
				stack.remove(0);
			} else if (split[0].equals("inc")) {
				int count = Integer.parseInt(split[1]);
				int increment = Integer.parseInt(split[2]);
				count = Math.min(stack.size(), count);
				if (count < stack.size()) {
					int numberOfVals = stack.size() - count;
					for (int k = 0; k < numberOfVals; k++) {
						System.out.println("::" + stack.get(numberOfVals + k));
						stack.set(numberOfVals + k, stack.get(numberOfVals + k) + increment);
					}
				} else if (count == stack.size()) {
					// update all values
					for (int k = 0; k < count; k++) {
						stack.set(k, stack.get(k) + increment);
					}
				}
			}

			PrintTop(stack);
			//PrintAll(stack);
		}
	}

	public static void PrintTop(LinkedList<Integer> stack) {
		if (stack.size() == 0) {
			System.out.println("EMPTY");
		} else {
			System.out.println(stack.get(0));
		}
	}
	
	public static void PrintAll(LinkedList<Integer> stack) {
		for(int i = 0;i<stack.size();i++)
			System.out.println(stack.get(i));
		
	}

	public static void main(String[] args) {
		String[] ops = {"push 5","push 6","push 7","push 8","inc 2 4"};
		SuperStack.superStack(ops);
	}
}
