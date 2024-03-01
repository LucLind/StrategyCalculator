package fizzBuzz;

public class Controller {
    private BaseHandler _handler;

    public void setHandler(BaseHandler handler){
        _handler = handler;
    }

    public BaseHandler getHandler(){
        return _handler;
    }

    public String process(int endNumber){
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= endNumber; i++) {
            result.append(_handler.process(i));
        }
        return result.toString();
    }
}
