import java.util.Stack;

public class UndoSystem {
	
	Stack <Runnable> stackOfMethods;
	
	public UndoSystem() {
		stackOfMethods = new Stack();
	}
	
	/**
	 * Method to be added to the top of the stack.
	 * This will be the latest method called by the program.
	 * 
	 * @param methodCall
	 */
	public void addMethod(Runnable methodCall) {
		stackOfMethods.push(methodCall);
	}
	
	/**
	 * Method to undo the last method called by the program.
	 * 
	 * @return The object reference to the method called
	 */
	public Runnable undoMethod() {
		
		return stackOfMethods.pop();
	
	}
	
	

}
