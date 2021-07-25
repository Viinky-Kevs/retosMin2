public class App {
    public static void main(String[] args){
        SchoolGradingSystem operaciones = new SchoolGradingSystem();
        operaciones.readData();
        System.out.println(operaciones.question1());
        System.out.println(operaciones.question2());
        System.out.println(operaciones.question3());
        System.out.println(operaciones.question4());
    }
}
