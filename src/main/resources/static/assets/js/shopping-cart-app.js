const app= angular.module("shopping-cart-app",[]);
app.controller("shopping-cart-ctrl", function($scope,$http){
  $scope.size = [];
  	$scope.form = {};
	//   dùng load

	
    // quản lý giỏ hàng
    $scope.cart = {
	
        items:[],
        //thêm sản phẩm
        add(IDSP) {
          var item = this.items.find(item=>item.IDSP==IDSP);
          if(item) {
            item.qty++;
            this.saveToLocalStorage();
          }
          else {
            $http.get(`/rest/DSSP/${IDSP}`).then(resp => {//rest sửa
                resp.data.qty = 1;
                this.items.push(resp.data);
                this.saveToLocalStorage();
            })
          }
        },
        //xóa sản phẩm
        remove(IDSP){
          var index=this.items.findIndex(item=>item.IDSP==IDSP);
          this.items.splice(index,1);
          this.saveToLocalStorage();
        },
        //lưu
        clear(){
		this.items=[]
		this.saveToLocalStorage();
},
        //tính tiền
        amt_of(item){},
        
        //tính tổng
        get count() {
			return this.items
			.map(item => item.qty)
			.reduce((total,qty) => total+=qty,0);
		},
        //tính thành tiền các mặt hàng
        get amount() {
			return this.items
			.map(item => item.qty * item.gia)
			.reduce((total,qty) => total+=qty,0);
		},
        //Lưu giỏ hàng vào local storages
        saveToLocalStorage(){
            var json=JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        //Đọc giỏ hàng từ local storages
         loadFromLocalStorage(){
	   var json=localStorage.getItem("cart");//neu co gang item
            this.items=json?JSON.parse(json):[];//k co gan ma rong
}
    }
     $scope.cart.loadFromLocalStorage();// tải lại tất cả các mặt hàng lại trong cua hang


	$scope.donHang={
		ngay: new Date(),
		sdt:"",
		diaChi:"",
		username: {username:$("#username").text()},//username lấy bằng jquery
		get chitietdonhang(){//get chiTietDonHang tất cả mặt hàng được chuyển vào orderdetail
			return $scope.cart.items.map(item=>{
				return{
				DSSP:{id: item.id},
				gia:item.gia,
				sl:item.qty
				}
			});
		},
		purchase(){//gửi thông tin lên server
			var donHang =angular.copy(this);//lấy ra đơn hàng hiện tại
			$http.post("/rest/orders",donHang).then(resp=>{
				alert("Đặt hàng thành công!");
				$scope.cart.clear();
				location.href="/order/detail/"+resp.data.IDDonHang;
			}).catch(error=>{
				alert("Đặt hàng thất bại")
				console.log(error)
			})
		}
		
	}
	
}
)
