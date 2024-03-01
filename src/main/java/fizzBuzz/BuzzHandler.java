package fizzBuzz;

public class BuzzHandler extends BaseHandler{
    @Override
    public String process(int number) {
        if(number % 5 == 0){
            return "Buzz\n";
        }
        if (_next != null){
            return _next.process(number);
        }
        return null;
    }
}
