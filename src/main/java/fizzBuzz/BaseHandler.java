package fizzBuzz;

public abstract class BaseHandler {

    protected BaseHandler _next;

    public final BaseHandler setNext(BaseHandler handler){
        _next = handler;
        return _next;
    }
    public final BaseHandler getNext(){
        return _next;
    }

    public abstract String process(int number);
}
