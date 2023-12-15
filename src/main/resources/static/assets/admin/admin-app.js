app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
        .when("/TaiKhoan", {
            templateUrl: "/assets/admin/taikhoan/taikhoan.html",
            controller: "taikhoan-ctrl"
        })
        .when("/sanpham", {
            templateUrl: "/assets/admin/sanpham/sanpham.html",
            controller: "sanpham-ctrl"
        })
        .otherwise({
            templateUrl: "/assets/admin/thongke/thongke.html",
            controller: "thongke-ctrl"
        })
})