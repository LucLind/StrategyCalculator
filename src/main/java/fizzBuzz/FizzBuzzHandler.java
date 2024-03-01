package fizzBuzz;

public class FizzBuzzHandler extends BaseHandler {

    @Override
    public String process(int number) {
        if(number % 15 == 0){
            return "FizzBuzz\n";
        }
        if (_next != null){
            return _next.process(number);
        }
        return null;
    }

}
