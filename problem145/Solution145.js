function hasOnlyOddDigits(number) {
  const digits = String(number).split("");
  return digits.find((digit) => parseInt(digit) % 2 === 0) === undefined;
}

function countReversibleNumbers(limit) {
  let count = 0;
  for (let i = 1; i < limit; i++) {
    const str = String(i);
    if (str.charAt(0) === "0" || str.charAt(str.length - 1) === "0") {
      continue;
    }
    const reversedStr = str.split("").reverse().join("");
    const mirrorNumber = parseInt(str) + parseInt(reversedStr);
    if (hasOnlyOddDigits(mirrorNumber)) {
      count++;
    }
  }
  return count;
}

const limit = 1000000000;
const reversibleCount = countReversibleNumbers(limit);
console.log(reversibleCount);
