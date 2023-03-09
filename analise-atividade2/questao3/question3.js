const arrayA = [6, 6, 5, 4, 3, 2, 1];
const arrayB = [6, 6, 5, 4, 3, 2, 1].sort();

let turn = 0;

console.log("antes", arrayA);

//aparentemente era só um bubbleSOrt
for (let i = 0; i < arrayA.length; i++) {
  for (let j = 0; j < arrayA.length; j++) {
    if (arrayA[j] > arrayA[j + 1]) {
      //console.log(arrayA[j], arrayA[j + 1]);
      let temp = arrayA[j];
      arrayA[j] = arrayA[j + 1];
      arrayA[j + 1] = temp;
      turn++;
      //console.log("depois", arrayA);
    }
  }
}

console.log("depois", arrayA);
console.log("turn", turn % 2 == 0 ? "carlos" : "marcelo");
