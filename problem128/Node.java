public class Node {

  // node value or number of nodes
  public int value = 0;

  // define neighbours to 6 directions
  public Node[] neighbour = new Node[6];

  // row nodes of each new row
  static int row = 0;
  static int rowLast = 1;
  static int rowFirst;

  // number of neighbours
  public int totalNeighs = 0;

  // you can delete them
  static Node beginNode;
  public Node next;

  public Node() {
    // on first node, create the 6 directions, assign value 1, move to next row and create the 2nd node, just north of this
    for (int i = 0; i < 6; i++) {
      this.neighbour[i] = null;
    }
    this.value = 1;
    nextRow();
    beginNode = this;
    next = new Node(this, 0, 2);
  }

  // temporary node for only the first of the row (because the south node, has the last one to his N-E and must complete first in each row)
  public Node(int val) {
    for (int i = 0; i < 6; i++) {
      this.neighbour[i] = null;
    }
    value = val;
  }

  public Node(Node n, int fromPos, int val) {

    // fill neighbours when you add a new node
    // Connections
    // 1. connect with the previous one (1st connection)
    // 2. if it is the first, connect to a temporary to your SE (Temp connection)
    // 3. connect with the node move back -> clockwise (2nd connection)
    // 4. check if there is a node for 3rd connection (back -> clockwise -> the same direction as UNback)
    // 5. if it is the last node of the row, adjust properly
    //
    // Move to next node
    // 1. if it is the first go through pos 2
    // 2. if last go throught the first of the row and then to pos 0
    // 3. otherwise
    //   a) go again with the same dirrection
    //   b) add +1 clocowise

    System.out.println();
    System.out.println("=============================");
    System.out.println("Node " + val + " created from node " + n.value + " at pos " + fromPos);
    System.out.println("-----------------------------");

    value = val;

    if (val > 40) {
      return;
    }

    // 1st connection
    n.neighbour[fromPos] = this;
    neighbour[(fromPos + 3) % 6] = n;
    System.out.println("1. Connection through pos " + (fromPos + 3) % 6 + " to node " + n.value);

    // count one more neighbour
    this.totalNeighs++;
    n.totalNeighs++;

    // it is the 1st of the row, so add a temporary to youe NE
    // no need for the other connection because when the NE node will be created, it will fix the connections
    if(value == rowFirst) {
      System.out.println("Node " + value + " is the first of the row");
      Node lastNode;
      lastNode = new Node(rowLast);
      n.neighbour[5] = lastNode;
      System.out.println("Connection of the previous through pos 5 to node " + lastNode.value);

      // count one more neighbour
      n.totalNeighs++;

      // Continue to your SW
      next = new Node(this, 2, value + 1);
      return;
    }

    // 2nd connection
    // connect with the node n1 (previous, 1 clockwise)
    // from n1 and position +1 (node n2)
    Node n1 = n.neighbour[(fromPos + 1) % 6];
    int thisPos = (fromPos + 2) % 6;
    neighbour[thisPos] = n1;
    n1.neighbour[(thisPos + 3) % 6] = this;
    System.out.println("2. Connection through pos " + thisPos + " to node " + n1.value);

    // count one more neighbour
    this.totalNeighs++;
    n1.totalNeighs++;
    if (n1.totalNeighs == 6) printtThem(n1);

    // if it is the last make proper changes
    if (rowLast == value) {
      System.out.println("It is the last node of the row");

      Node first = neighbour[3].neighbour[1].neighbour[0];
      neighbour[1] = first;
      first.neighbour[4] = this;
      neighbour[2] = first.neighbour[3];
      first.neighbour[3].neighbour[5] = this;

      System.out.println("3. Connection through pos 1 to first node of the row " + first.value);

      totalNeighs++;
      first.totalNeighs++;
      if (first.totalNeighs == 6) printtThem(n1);

      nextRow();

      System.out.println("Head for " + first.value);
      next = new Node(first, 0, value + 1);
      return;
    }

    // head back and see if there is a node when you move at the same direction as you came here
    Node n2 = n1.neighbour[fromPos];
    if (n2 != null && value !=6) {
      thisPos = (fromPos + 1) % 6;
      neighbour[thisPos] = n2;
      n2.neighbour[(thisPos + 3) % 6] = this;
      System.out.println("3. Connection through pos " + thisPos + " to node " + n2.value);

      // check if n2 is full
      n2.totalNeighs++;
      this.totalNeighs++;
      if (n2.totalNeighs == 6) printtThem(n2);

      next = new Node(this, fromPos, value + 1);
    } else {
      next = new Node(this, (fromPos + 1) % 6, value + 1);
    }
  }

  public void nextRow() {
    row++;
    rowFirst = rowLast + 1;
    rowLast = rowLast + 6 * row;

    System.out.println("Σειρά: " + row);
    System.out.println("Πρώτος: " + rowFirst);
    System.out.println("Τελευταίος: " + rowLast);
  }

  public void printtThem(Node n) {
    System.out.println();
    System.out.println("****************************");
    System.out.print("O Κομβος " + n.value + " (" + n.totalNeighs + "), γέμισε: ");
      for (int i = 0; i < 6; i++) {
        if (n.neighbour[i] != null)
        System.out.print(n.neighbour[i].value + ", ");
      }
    System.out.println();
    System.out.println("****************************");
    System.out.println();
  }

}
