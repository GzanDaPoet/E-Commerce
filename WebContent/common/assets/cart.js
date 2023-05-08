
var quantityElement = document.getElementById("quantity");


var increaseButton = document.getElementById("increase");
increaseButton.addEventListener("click", function() {
  var currentValue = parseInt(quantityElement.innerHTML);
  quantityElement.innerHTML = currentValue + 1;
});

var decreaseButton = document.getElementById("decrease");
decreaseButton.addEventListener("click", function() {
  var currentValue = parseInt(quantityElement.innerHTML);
  if (currentValue > 0) {
    quantityElement.innerHTML = currentValue - 1;
  }
});
