const readline = require("readline").createInterface({
	input: process.stdin,
	output: process.stdout,
});

"use strict"

let NT = [];
let ai = [];
let bi = [];
let lineNum = 0;

readline
	.on("line", (line) => {
    switch (lineNum) {
      case 0:
        NT = line.trim().split(' ');
        break;
      case 1:
        ai = line.trim().split(' ');
        break;
      case 2:
        bi = line.trim().split(' ');
        break;
      default:
        break;
    }
    lineNum += 1;
	})
	.on("close", () => {
    console.log(solve(NT[0], NT[1], ai, bi));
		process.exit(0);
	});

function solve(N, T, a, b) {
  let customers = [N];
  let k =0, min = Infinity;
  let flag = true;
  for (let i = 0; i < T; i++) {
    if(k === N) k = 0;
    if(customers[k] < b[i]){
      customers[k] += 1;
      k++;
    }else{
      k++;
      continue;
    }
  }
  for (let i = 0; i < N; i++) {
    if(customers[i] < a[i]) flag = false;
  }

  if(flag) return "YES";
  return "NO"
}