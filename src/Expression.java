public class Expression {

  public Operation op = null;
  public Expression left = null;
  public Expression right = null;

  public boolean evaluate() {

    boolean leftval = false;
    if (left != null) {
      leftval = left.evaluate();
    }

    boolean rightval = false;
    if (right != null) {
      rightval = right.evaluate();
    }

    return op.op(leftval, rightval);
  }

  public String toString() {
    if (op.numInputs() == 0) {
      return op.toString();
    } else if (op.numInputs() == 1) {
      return String.format("%s(%s)", op.toString(), left.toString());
    } else if (op.numInputs() == 2) {
      return String.format("(%s %s %s)", left.toString(), op.toString(), right.toString());
    }
    return null;
  }
}
