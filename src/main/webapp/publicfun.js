function menuTest(e){
    // 遍历所有内容，隐藏它们
    const contents = document.querySelectorAll(".cont");
    contents.forEach((content) => {
        content.classList.remove("show");
    });

    // 根据按钮 ID 显示相应的内容
    const id = e.id;
    const contentToShow = document.querySelector(`#cont${id}`);
    contentToShow.classList.add("show");
}

