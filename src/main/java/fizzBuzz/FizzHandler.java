package fizzBuzz;

public class FizzHandler extends BaseHandler{
    @Override
    public String process(int number) {
        if (number % 3 == 0){
            return "Fizz\n";
        }
        if (_next != null){
            return _next.process(number);
        }
        return null;
    }
}
