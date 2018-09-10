import java.util.function.BiFunction;

public class Operation {

  private int numInputs;
  protected BiFunction<Boolean, Boolean, Boolean> operation;
  private String display;

  public Operation(int inputs, BiFunction<Boolean, Boolean, Boolean> op, String display) {
    numInputs = inputs;
    operation = op;
    this.display  = display;
  }

  public boolean op(boolean a, boolean b) {
    return operation.apply(a, b);
  }

  public int numInputs() {
    return numInputs;
  }

  public String toString() {
    return this.display;
  }
}
