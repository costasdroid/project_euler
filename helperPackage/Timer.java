package helperPackage;

public class Timer {
  private long startTime;

  public void start() {
    startTime = System.currentTimeMillis();
  }

  public void end() {
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Total time: " + totalTime + " milliseconds");
  }
}
