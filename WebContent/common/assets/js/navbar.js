const sideBar = document.querySelector(".sidebar");
const toggleButton = document.getElementById("sidebar_button");
const listCFMenu = document.querySelectorAll(".cf-menu");

toggleButton.addEventListener("click", () => {
  sideBar.classList.toggle("active");
});

// menu item
const listMenu = document.querySelectorAll(".menu-item");

listMenu.forEach((item) => {
  item.addEventListener("click", () => {
    listMenu.forEach((itm) => {
      itm.classList.remove("is-active");
    });
    listCFMenu.forEach((itm) => {
      itm.classList.remove("active");
      item.classList.remove("visually");
    });
    item.classList.toggle("is-active");
    console.log(item.parentNode);
    item.parentNode.classList.toggle("active");
    setTimeout(() => {
      item.parentNode.classList.add("visually");
    }, 250);
  });
});
