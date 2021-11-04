/* input type file 요소들 */
const fileElements = document.querySelectorAll("[type=file]");   /* querySelectorAll = 배열X 유사배열O */
/* div image_area 요소들 */
const imageArea = document.querySelectorAll(".image_area");
/* input type file 요소에 change 이벤트 발생 시 (파일 첨부 발생)*/
fileElements.forEach(item => item.addEventListener('change',preview));

function preview(){
   let index = Array.from(fileElements).indexOf(this);   /* 배열로 변환 | this = <input type="file> */
   if(this.files && this.files[0]) {
      let reader = new FileReader();
      reader.readAsDataURL(this.files[0]);   /* url 형식으로 파일을 읽어온다 */
      reader.onload = function(){
         imageArea[index].innerHTML = "<img src='"+reader.result+"'>";   /* 몇 번째 div인지 알아와서 해당 div 영역에 HTML로 삽입 */
      }
   }
}