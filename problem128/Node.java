public class Node {

  static int pos = 0;
  static final Primes primes = new Primes(1000);

  // row nodes of each new row
  static int row = 0;
  static int rowLast = 1;

  // last node added (for keeping track of the next)
  static Node lastNode;
  static Node current;

  // number of nodes with 3 primes
  static int threes = 0;

  // node id - value
  public int id = 1;

  // define neighbours to 6 directions
  public Node[] neighbour = new Node[6];

  // next node of this one
  public Node next;

  public Node() {
    nextRow();
    // on first node
    lastNode = new Node(1);
    current = lastNode;

    do {
      fill(current);
      printNeighbours(current);
      current = current.next;
    } while (threes <= 10);
  }

  // node creation
  public Node(int id) {
    for (int i = 0; i < 6; i++) {
      this.neighbour[i] = null;
    }
    this.id = id;
  }

  // fill node's neighbours
  static void fill(Node n) {
    // System.out.println();
    // System.out.println("For node " + n.id);
    // System.out.println("============");

    for (int j = 0; j < 6; j++) {
      int i = (j + pos + 6) % 6;
      Node temp;
      if (n.neighbour[i] == null) {
        // System.out.println(pos + "Δημιουργία κόμβου " + (lastNode.id + 1));
        temp = new Node(lastNode.id + 1);

        // Keep track of node succession
        // System.out.println("Υπάρχει επόμενος του " + n.id + "?");
        if (n.next == null) {
          // System.out.println("Όχι, κάνε επόμενο του τον " + temp.id);
          n.next = temp;
        } else {
          // System.out.println("Ναι o " + n.next.id + ", κάνε επόμενο του " + lastNode.id + " τον " + temp.id);
          lastNode.next = temp;
        }

        // System.out.println(" (" + i + ") -> " + temp.id);
        temp.neighbour[(i + 3) % 6] = n;
        n.neighbour[i] = temp;
        // System.out.println("Added the new node as neighbour through position " + i);

        if (n.neighbour[(i + 1) % 6] != null) {
          n.neighbour[(i + 1) % 6].neighbour[(i + 5) % 6] = temp;
          temp.neighbour[(i + 2) % 6] = n.neighbour[(i + 1) % 6];
        }

        if (n.neighbour[(i + 5) % 6] != null) {
          n.neighbour[(i + 5) % 6].neighbour[(i + 1) % 6] = temp;
          temp.neighbour[(i + 4) % 6] = n.neighbour[(i + 5) % 6];
        }

        lastNode = temp;

        if (temp.id == rowLast) {
          // System.out.println("I Should check primes");

          temp.neighbour[2].neighbour[0].neighbour[4] = temp;
          temp.neighbour[1] = temp.neighbour[2].neighbour[0];
          if (temp.id > 1) check(temp.neighbour[2], n);
          nextRow();
          pos = 0;
          return;
        }

      } else {
        pos = i - 1;
        return;
      }
    }
  }

  static void check(Node n, Node m) {
    if (n.id > m.id) return;
    checkNode(n);
    check(n.next, m);
  }

  static void nextRow() {
    row++;
    rowLast = rowLast + 6 * row;

    // System.out.println("Σειρά: " + row);
    // System.out.println("Τελευταίος: " + rowLast);
  }

  static void checkNode(Node n) {
    // System.out.println();
    // System.out.println("****************************");
    // System.out.print("O Κομβος " + n.id + " ");

    int total = 0;

    for (int i = 0; i < 6; i++) {
      // System.out.print("(" + i + ")");
      // if (n.neighbour[i] != null) System.out.print(n.neighbour[i].id + ", ");
      if (primes.primesArray[Math.abs(n.id - n.neighbour[i].id )]) total++;
    }
    if (total == 3) {
      threes++;
    }
    System.out.println(total);
    // System.out.println("****************************");
    // System.out.println();
  }

  static void printNeighbours(Node n) {
    System.out.println();
    System.out.println("****************************");
    System.out.print("O Κομβος " + n.id + " ");

    int total = 0;

    for (int i = 0; i < 6; i++) {
      System.out.print("(" + i + ")");
      if (n.neighbour[i] != null) System.out.print(n.neighbour[i].id + ", ");
    }
    System.out.println();
    System.out.println("****************************");
    System.out.println();
  }

}
