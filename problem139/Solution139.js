function gcd(a, b) {
  while (b !== 0) {
    let temp = b;
    b = a % b;
    a = temp;
  }
  return a;
}

function generateRightTriangles(maxPerimeter) {
  let triangles = 0;

  for (let m = 2; m * m <= maxPerimeter / 2; m++) {
    for (let n = 1; n < m; n++) {
      if ((m - n) % 2 === 1 && gcd(m, n) === 1) {
        let a = m * m - n * n;
        let b = 2 * m * n;
        let c = m * m + n * n;
        let perimeter = a + b + c;

        if (perimeter > maxPerimeter) {
          break;
        }

        let k = 1;
        if (c % Math.abs(b - a) === 0) {
          //   console.log([k * a, k * b, k * c]);
          triangles += Math.floor(maxPerimeter / perimeter);
        }
      }
    }
  }

  return triangles;
}

let maxPerimeter = 100000000;
console.time("Benchmark");
console.log(generateRightTriangles(maxPerimeter));
console.timeEnd("Benchmark");
