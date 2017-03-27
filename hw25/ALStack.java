import java.util.ArrayList;

public class ALStack<T> {

    private ArrayList<T> _stack;

    public ALStack() {
	_stack = new ArrayList<T>();
    }

    public void push(T obj) {
	_stack.add(obj);
    }

    public T pop() {
	return _stack.remove(_stack.size() - 1);
    }

    public T peek() {
	return _stack.get(_stack.size() - 1);
    }

    public boolean isEmtpy() {
	return _stack.size() == 0;
    }
    
}
