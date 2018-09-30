(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"src/app/administracao/administracao.module": [
		"./src/app/administracao/administracao.module.ts",
		"default~src-app-administracao-administracao-module~src-app-loja-loja-module",
		"src-app-administracao-administracao-module"
	],
	"src/app/loja/loja.module": [
		"./src/app/loja/loja.module.ts",
		"default~src-app-administracao-administracao-module~src-app-loja-loja-module",
		"src-app-loja-loja-module"
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids) {
		return Promise.resolve().then(function() {
			var e = new Error("Cannot find module '" + req + "'");
			e.code = 'MODULE_NOT_FOUND';
			throw e;
		});
	}
	return Promise.all(ids.slice(1).map(__webpack_require__.e)).then(function() {
		var id = ids[0];
		return __webpack_require__(id);
	});
}
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";
module.exports = webpackAsyncContext;

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<router-outlet></router-outlet>\n<ngx-spinner bdColor=\"rgba(51, 51, 51, 0.8)\" size=\"large\" color=\"#fff\" type=\"ball-atom\"></ngx-spinner>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'web-application';
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _sharing_http_request_interceptor__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./sharing/http-request.interceptor */ "./src/app/sharing/http-request.interceptor.ts");
/* harmony import */ var angular_notifier__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! angular-notifier */ "./node_modules/angular-notifier/esm5/angular-notifier.js");
/* harmony import */ var ngx_spinner__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-spinner */ "./node_modules/ngx-spinner/fesm5/ngx-spinner.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var rotas = [
    { path: 'loja', loadChildren: 'src/app/loja/loja.module#LojaModule' },
    { path: 'administrativo', loadChildren: 'src/app/administracao/administracao.module#AdministracaoModule' },
    { path: '', redirectTo: 'loja', pathMatch: 'full' },
    { path: '**', redirectTo: 'loja' }
];
var customNotifierOptions = {
    position: {
        horizontal: { position: 'left', distance: 12 },
        vertical: { position: 'bottom', distance: 12, gap: 10 }
    },
    theme: 'material',
    behaviour: { autoHide: 1500, onClick: 'hide', onMouseover: 'pauseAutoHide', showDismissButton: true, stacking: 4 },
    animations: {
        enabled: true,
        show: {
            preset: 'slide',
            speed: 300,
            easing: 'ease'
        },
        hide: {
            preset: 'fade',
            speed: 300,
            easing: 'ease',
            offset: 50
        },
        shift: {
            speed: 300,
            easing: 'ease'
        },
        overlap: 150
    }
};
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_7__["AppComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HttpClientModule"],
                ngx_spinner__WEBPACK_IMPORTED_MODULE_2__["NgxSpinnerModule"],
                angular_notifier__WEBPACK_IMPORTED_MODULE_1__["NotifierModule"].withConfig(customNotifierOptions),
                _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterModule"].forRoot(rotas, { enableTracing: false, useHash: false })
            ],
            exports: [ngx_spinner__WEBPACK_IMPORTED_MODULE_2__["NgxSpinnerModule"]],
            providers: [
                /*
                {
                  provide: ErrorHandler,
                  useClass: ErrorsHandler
                }, */ {
                    provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HTTP_INTERCEPTORS"],
                    useClass: _sharing_http_request_interceptor__WEBPACK_IMPORTED_MODULE_0__["HttpRequestInterceptor"],
                    multi: true
                }
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_7__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/sharing/http-request.interceptor.ts":
/*!*****************************************************!*\
  !*** ./src/app/sharing/http-request.interceptor.ts ***!
  \*****************************************************/
/*! exports provided: HttpRequestInterceptor */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HttpRequestInterceptor", function() { return HttpRequestInterceptor; });
/* harmony import */ var ngx_spinner__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ngx-spinner */ "./node_modules/ngx-spinner/fesm5/ngx-spinner.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _usuario_logado_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./usuario-logado.service */ "./src/app/sharing/usuario-logado.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var HttpRequestInterceptor = /** @class */ (function () {
    function HttpRequestInterceptor(spinner, usuarioLogadoService) {
        this.spinner = spinner;
        this.usuarioLogadoService = usuarioLogadoService;
    }
    HttpRequestInterceptor.prototype.intercept = function (request, next) {
        if (this.usuarioLogadoService.usuarioEstaLogado()) {
            var cloneRequest = request.clone(
            // { headers: request.headers.set('Authorization', 'Bearer ' + this.usuarioLogadoService.getUsuarioLogado().accessToken) }
            );
            return next.handle(cloneRequest);
        }
        else {
            return next.handle(request);
        }
    };
    HttpRequestInterceptor = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        __metadata("design:paramtypes", [ngx_spinner__WEBPACK_IMPORTED_MODULE_0__["NgxSpinnerService"],
            _usuario_logado_service__WEBPACK_IMPORTED_MODULE_2__["UsuarioLogadoService"]])
    ], HttpRequestInterceptor);
    return HttpRequestInterceptor;
}());



/***/ }),

/***/ "./src/app/sharing/usuario-logado.service.ts":
/*!***************************************************!*\
  !*** ./src/app/sharing/usuario-logado.service.ts ***!
  \***************************************************/
/*! exports provided: UsuarioLogadoService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UsuarioLogadoService", function() { return UsuarioLogadoService; });
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var USUARIO_LOGADO = '@usuarioLogado';
var CLIENTE = 'CLIENTE';
var VENDEDOR = 'VENDEDOR';
var ADMINISTRADOR = 'ADMINISTRADOR';
var UsuarioLogadoService = /** @class */ (function () {
    function UsuarioLogadoService() {
        this.subject = new rxjs__WEBPACK_IMPORTED_MODULE_0__["Subject"]();
    }
    UsuarioLogadoService.prototype.registrarUsuarioLogado = function (usuario, tokens) {
        localStorage.setItem(USUARIO_LOGADO, JSON.stringify(usuario));
        this.subject.next(usuario);
    };
    UsuarioLogadoService.prototype.usuarioEstaLogado = function () {
        var usuario = this.getUsuarioLogado();
        var v = usuario !== null;
        // console.log( this.isCliente() );
        // console.log( this.isVendedor() );
        // console.log( this.isAdministrador() );
        return v;
    };
    UsuarioLogadoService.prototype.getUsuarioLogado = function () {
        var usuario = JSON.parse(localStorage.getItem(USUARIO_LOGADO));
        return usuario;
    };
    UsuarioLogadoService.prototype.getUsuarioStorage = function () {
        return this.subject.asObservable();
    };
    UsuarioLogadoService.prototype.logoff = function () {
        localStorage.clear();
        this.subject.next(undefined);
    };
    UsuarioLogadoService.prototype.isVendedor = function () {
        var resultado = this.temPerfil(VENDEDOR);
        // console.log('Is vendedor: ' + resultado);
        return resultado;
    };
    UsuarioLogadoService.prototype.isCliente = function () {
        var resultado = this.temPerfil(CLIENTE);
        // console.log('Is cliente: ' + resultado);
        return resultado;
    };
    UsuarioLogadoService.prototype.isAdministrador = function () {
        var resultado = this.temPerfil(ADMINISTRADOR);
        // console.log('Is administrador: ' + resultado);
        return resultado;
    };
    UsuarioLogadoService.prototype.temPerfil = function (nomePerfill) {
        if (!this.usuarioEstaLogado()) {
            return false;
        }
        var usuarioLogado = this.getUsuarioLogado();
        for (var _i = 0, _a = usuarioLogado.perfis; _i < _a.length; _i++) {
            var perfil = _a[_i];
            if (perfil.nome === nomePerfill) {
                return true;
            }
        }
        return false;
    };
    UsuarioLogadoService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [])
    ], UsuarioLogadoService);
    return UsuarioLogadoService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, for easier debugging, you can ignore zone related error
 * stack frames such as `zone.run`/`zoneDelegate.invokeTask` by importing the
 * below file. Don't forget to comment it out in production mode
 * because it will have a performance impact when errors are thrown
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/waelson/OneDrive/TCC-ADS/workspace/camada-web/web-application/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map