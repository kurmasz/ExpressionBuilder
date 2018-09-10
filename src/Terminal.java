public class Terminal extends Operation {

  private boolean value;

  public Terminal(String name)  {
    super(0, null , name);
    this.operation = (a, b) -> this.getValue();
  }

  public void setValue(boolean new_value) {
    value = new_value;
  }

  public boolean getValue() {
    return value;
  }

}
