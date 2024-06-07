const N = 1000000;
sticks = [];
given = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6];

class MNum {
  st;
  num;
  expr;
  withAddition;

  constructor(num) {
    this.num = num;
    this.st = (this.num + "")
      .split("")
      .reduce(
        (a, b) => a + (num > 9 ? sticks[parseInt(b)].st : given[parseInt(b)]),
        0
      );
    this.expr = this.num + "";
    sticks.push(this);
    this.searchForMultiplication();
    this.searchForAddition();
  }

  searchForMultiplication = function () {
    for (let i = 2; i <= Math.sqrt(this.num); i++) {
      if (this.num % i == 0) {
        var temp = sticks[this.num / i].st + sticks[i].st + 2;
        if (this.st > temp) {
          this.expr = sticks[i].expr + "*" + sticks[this.num / i].expr;
          this.st = temp;
        }
      }
    }
  };

  searchForAddition = function () {
    for (let i = 1; i <= this.num / 2; i++) {
      var temp =
        (sticks[this.num - i].withAddition || sticks[this.num - i].st) +
        (sticks[i].withAddition || sticks[i].st) +
        2;
      if ((this.withAddition || this.st) > temp) {
        // if (this.num % 100000 == 0) console.log(this.num);
        this.expr = sticks[i].expr + "+" + sticks[this.num - i].expr;
        this.withAddition = temp;
      }
    }
  };

  getExpr = function () {
    return `${this.num}: ${this.expr} = ${this.st}`;
  };
}

for (let i = 0; i <= N; i++) {
  new MNum(i);
}

// sticks.forEach((s) => {
//   console.log(s.getExpr());
//   // s.hasAddition ? console.log(s.getExpr()) : "";
// });
// sticks.forEach((s) => {
//   eval(s.expr) !== s.num ? console.log(s.getExpr()) : "";
// });
console.log(
  sticks.reduce((a, b) => a + (b.withAddition ? b.withAddition : b.st), 0) - 6
);
