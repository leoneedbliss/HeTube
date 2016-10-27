package hello;

public class GreetingEngine implements IGreetingEngine {

    private JavaEngine engine;

    public GreetingEngine() {
        engine = new JavaEngine();
    }

    public String generateGreeting(Customer customer) {
        EngineResponse response = new EngineResponse();

        engine.run(customer, response);

        String result = response.get("greeting") + ", " +
                response.get("salutation") + " " +
                customer.getName() + "!";
        System.out.println("Generated Greeting: " + result);
        return result;
    }
    public static void main(String[] args) {
        GreetingEngine engine = new GreetingEngine();

        Customer customer = new Customer();
        customer.setName("Robinson");
        customer.setGender("Female");
        customer.setMaritalStatus("Married");

        engine.generateGreeting(customer);
    }
}