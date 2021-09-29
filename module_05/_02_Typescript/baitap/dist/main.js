function fibo(i) {
    if (i == 0) {
        return 0;
    }
    if (i == 1) {
        return 1;
    }
    return fibo(i - 1) + fibo(i - 2);
}
let sum = 0;
let n = 20;
console.log("Dãy số fibonacci là : ");
for (let i = 0; i < n; i++) {
    console.log(fibo(i));
    sum += fibo(i);
}
console.log("Tổng dãy số fibonaci là : " + sum);
//# sourceMappingURL=main.js.map