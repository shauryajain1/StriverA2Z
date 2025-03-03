class MyQueue {
    private Stack<Integer> myQueue;
    private Stack<Integer> stack;
    public MyQueue() {
        myQueue=new Stack<>();
        stack=new Stack<>();
    }
    
    public void push(int x) {
        stack.add(x);
        
    }
    
    public int pop() {
        if(myQueue.isEmpty()){
        while(!stack.isEmpty()){
            myQueue.add(stack.pop());
        }}
        return myQueue.pop();

    }
    
    public int peek() {
        if(myQueue.isEmpty()){
        while(!stack.isEmpty()){
            myQueue.add(stack.pop());
        }}
        return myQueue.peek();
    }
    
    public boolean empty() {
        if(myQueue.isEmpty() && stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */