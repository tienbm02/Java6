app.controller("sanpham-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.th = [];
	$scope.gt = [];
	$scope.size = [];
	$scope.form = {};
	//   dùng load

	$scope.initialize = function() {

		$scope.form = {
			hinh1: 'matdinh.jpg',
			trangThai: true
		};
		//san pham

		$http
			.get("/rest/product")
			.then((resp) => {
				$scope.items = resp.data;
				console.log("hoàn thành: ", resp.date);
			})
			.catch((erro) => {
				console.log("lổi ", erro);
			});

		//thuong hieu
		$http.get("/rest/thuonghieu").then((resp) => {
			$scope.th = resp.data;
		});

		//Gioi tinh
		$http.get("/rest/gioitinh").then((resp) => {
			$scope.gt = resp.data;
		})

		//size
		$http.get("/rest/size").then((resp) => {
			$scope.size = resp.data;
		})

	};

	$scope.initialize();

	$scope.reset = function() {
		$scope.form = {
			hinh1: 'matdinh.jpg',
			trangThai: true
		};
	};

	$scope.edit = function(item) {
		if (confirm("Bạn có muốn Sửa ?") == true) {
			$scope.form = angular.copy(item);
			console.log(angular.copy(item));
		} else {
			console.log("Không");
		}
	};

	$scope.create = function() {
		var item = angular.copy($scope.form);
		console.log("form", item)
		$http.post(`/rest/product`, item).then((resp) => {
			$scope.items.push(resp.data);
			$scope.reset();
			setTimeout(function() {
				alert("Thêm Thành Công");
			}, 1000);
		}).catch(error => {
			setTimeout(function() {
			alert("Thêm Thất Bại");}, 1000);
			console.log("Lổi thêm ", error);
		})

	};

	$scope.update = function() {
		if (confirm("Bạn có muốn cập nhật lại sản phẩm không ?") == true) {
			var item = angular.copy($scope.form);
			$http.put(`/rest/product/${item.idsp}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.idsp == item.idsp);
				$scope.items[index] = item;
				alert("Update thành công");
			}).catch(error => {
				alert("Lổi cập nhật");
				console.log("error", error);
			})
		} else {
			$scope.reset();
		}

	};

	$scope.delete = function(item) {
		if (confirm("Bạn có muốn xoá sản phẩm không ?") == true) {
			$http.delete(`/rest/product/${item.idsp}`).then(resp => {
				var index = $scope.items.findIndex(p => p.idsp == item.idsp);
				$scope.items.splice(index, 1)
				$scope.reset();
				alert("Xoá Thành Công");
			}).catch(error => {
				alert("Không thể xoá");
				console.log("error", error);
			})
		} else {
			$scope.reset();
		}
	};

	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/sanpham', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.hinh1 = resp.data.name;
		}).catch(erro => {
			alert("Có lổi Trong quá trình lưu hình`");
			console.log("lổi quá: ", erro);
		})
		alert("ulr");
	};
});