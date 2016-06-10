var numberList = [1,2,3,4,5,6,7];

checkEqual(numberList);

function checkEqual(numberList){
  var round = Math.round(numberList.length / 2);
  var result = false;
  
  for(var i=1; i<=round; i++){
     result = recursiveCheck(numberList, i, [0]);
     if(result){
       break;
     } 
  }
  
  if(!result){
    console.log("ไม่เท่ากันเลย");
  }
    
}

function recursiveCheck(numberList, numberOfDigit, position){
  var maxLength = numberList.length;
  var sum = numberList.reduce(add, 0);
  var dataOne = 0, 
      dataTwo = 0;
  var positionIndex = position;
  
  if(positionIndex == 0){
    // first round
    positionIndex = [];
    for(var i=0; i<numberOfDigit; i++){
      dataOne += numberList[i];
      // keep index 
      positionIndex.push(i);
    }
  }else{
    for(var j=0; j<positionIndex.length; j++){
      dataOne += numberList[positionIndex[j]];
    }       
  }  
   
    
  dataTwo = sum - dataOne;  
  if(dataOne == dataTwo){
    console.log("positionIndex ="+positionIndex);
    console.log("dataOne = "+dataOne+" | "+"dataTwo = "+dataTwo);
    console.log("ค่าเท่ากัน");
    return true;
  }else{
    //last index +1
    var lastIndex = positionIndex.length-1; 
    positionIndex[lastIndex]++;
        
    if(maxLength == positionIndex[lastIndex]){   
       if(numberOfDigit > 1){
         // first digit
         ++positionIndex[lastIndex-1];
       }else{
         return false;
       }
      
       // last digit
       positionIndex[lastIndex] = positionIndex[lastIndex-1]+1;
    }  
    
    if(numberOfDigit > 1){
      // first digit สุดท้ายละ
      if((maxLength-1) == positionIndex[lastIndex-1]){
        return false;
      }
    }
        
    return recursiveCheck(numberList, numberOfDigit, positionIndex); 
  }
}

function add(a, b) {
    return a + b;
}
