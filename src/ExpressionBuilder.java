import java.util.Random;

public class ExpressionBuilder {

  public static Operation AND = new Operation(2, (a, b) -> a && b, "and");
  public static Operation OR = new Operation(2, (a, b) -> a && b, "or");
  public static Operation NOT = new Operation(1, (a, b) -> !a, "~");

  public static Operation[] operations = {AND, OR, NOT};

  public static Random rand = new Random();


  public static Expression build(int max_depth, Terminal[] terminals) {

    Operation op;

    int choice =  rand.nextInt(operations.length + 1);

    if (max_depth == 0 || choice == operations.length) {
      op = terminals[rand.nextInt(terminals.length)];
    } else {
      op = operations[choice];
    }

    Expression answer = new Expression();
    answer.op = op;
    if (op.numInputs() >= 1) {
      answer.left = build(max_depth -1, terminals);
    }

    if (op.numInputs() >=2) {
      answer.right = build(max_depth-1, terminals);
    }
    return answer;
  }

  public static void main(String[] args) {
    Terminal[] terminals = {new Terminal("A"), new Terminal("B"), new Terminal("C")};
    Expression e1 = ExpressionBuilder.build(3, terminals);
    System.out.println(e1);
    System.out.flush();

    System.out.println(e1.evaluate());

    terminals[0].setValue(true);
    terminals[1].setValue(true);
    terminals[2].setValue(true);
    System.out.println(e1.evaluate());
  }

}
